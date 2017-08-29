package com.hx.spring.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hx.spring.controller.UserController;
import com.hx.spring.entity.HelloWorld;
import com.hx.spring.entity.User;

public class TestSpring {
	// 创建spring的工厂
	private BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
	
	
	@Test
	public void testHello() {
		// 通过factory获得spring的对象
		// 此处getBean中的hw就是beans.xml配置文件的id
		HelloWorld hello = factory.getBean("hw", HelloWorld.class);
		
		HelloWorld hello1 = factory.getBean("hw", HelloWorld.class);
		
		// 此时的hello对象就是被spring所管理的对象
		System.out.println(hello == hello1);
	}
	
	@Test
	public void testUser() {
		UserController uc = factory.getBean("userController", UserController.class);
		User u = new User();
		u.setId(1);
		u.setUserName("悟空");
		u.setNickName("张三");
		u.setPassWord("12345");
		u.setEmail("wk@admin.com");
		uc.setUser(u); // 这个user对象就模拟从客户端请求过来的数据，作用是给UserController中User user对象赋值
		uc.add();
		/*
		UserController uc1 = factory.getBean("userController", UserController.class);
		uc1.add(); */
	}
	
	@Test
	public void testList() {
		UserController uc = factory.getBean("userController", UserController.class);
		uc.list();
	}

}
