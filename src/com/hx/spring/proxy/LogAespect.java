package com.hx.spring.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.hx.spring.log.Logger;

/**
 * @author @DT人 2017年7月24日 下午8:35:50
 *
 */
@Component("logAspect") // 让这个切面类被spring所管理
@Aspect // 声明这个类是一个切面
public class LogAespect {
	
	@Pointcut("execution(* com.hx.spring.dao.*.*(..))")
	public void test(){}
	
	/**
	 * 执行函数前执行
	 * 
	 * execution(* com.hx.spring.dao.*.*(..))表达式的说明：
	 * 第一个*表示任意的返回值
	 * 第二个*表示com.hx.spring.dao下面的所有类
	 * 第三个*表示类里面的所有方法
	 * (..)表示任意的参数
	 * 如果有多个表但是可以用 || 隔开
	 * add*或dele*表示以add或dele开头的方法 
	 */
	//@Before("execution(* com.hx.spring.dao.*.add*(..)) || "
			//+ "execution(* com.hx.spring.dao.*.dele*(..))") // 这是一个通知advice
	@Before(value="test()")
	public void logStart(JoinPoint jp) { // 连接点JoinPoint
		// getTarget得到执行的对象
		System.out.println(jp.getTarget());
		// getSignature得到执行的方法
		System.out.println(jp.getSignature().getName());
		Logger.info("方法调用前");
	}
	
	/*
	 * 执行函数后执行
	 */
	@After("execution(* com.hx.spring.dao.*.add*(..)) || "
			+ "execution(* com.hx.spring.dao.*.dele*(..))") // 这是一个通知advice
	public void logEnd(JoinPoint jp) {
		Logger.info("方法调用后");
	}
	
	/*
	 * 执行函数中执行
	 */
	@Around("execution(* com.hx.spring.dao.*.add*(..)) || "
			+ "execution(* com.hx.spring.dao.*.dele*(..))") // 这是一个通知advice
	public void logAround(ProceedingJoinPoint pjp) {
		Logger.info("开始在arond中加入日志");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} // 执行程序
		Logger.info("结束Around的日志加入");
	}
}
