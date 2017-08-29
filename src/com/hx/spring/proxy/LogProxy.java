package com.hx.spring.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import com.hx.spring.annotation.LogInfo;
import com.hx.spring.log.Logger;

/**
 * 动态代理之日志代理类
 * 
 * @author @DT人 2017年7月24日 下午4:42:37
 *
 */

public class LogProxy implements InvocationHandler {
	
	// 创建一个代理对象
	private Object targer;
	
	private LogProxy() {} //构造方法私有化
	
	// 3、创建一个方法来生成对象，这个方法的参数是要代理的对象
	public static Object getInstance(Object o) {
		// 3.1、创建LogProxy的对象
		LogProxy proxy = new LogProxy();
		// 3.2、设置这个代理对象
		proxy.targer = o;
		/*
		 * 3.3、通过Proxy类的方法创建代理对象，
		 * 第一个参数要代理对象的类的加载器(getClassLoader)
		 * 第二个参数是要代理对象实现的所有接口
		 * 第三个参数是实现了InvocationHandler接口类的对象
		 * 此时的result就是一个代理对象，代理的是o,比如我们在getInstance(userService),
		 * 那么我们代理的就是userService这个对象
		 */
		Object result = Proxy.newProxyInstance(o.getClass().getClassLoader(),
				o.getClass().getInterfaces(), proxy);
		return result;
	}
	/*
	 * 当有了代理对象之后，不管这个代理对象执行什么方法，都会调用下面的invoke方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		/*if(method.getName().equals("add") || "delete".equals(method.getName())) {
			Logger.info("进行相应的操作");
		}*/
		if(method.isAnnotationPresent(LogInfo.class)) {
			LogInfo li = method.getAnnotation(LogInfo.class);
			Logger.info(li.value());
		}
		Object obj = method.invoke(targer, args);
		return obj;
	}

}
