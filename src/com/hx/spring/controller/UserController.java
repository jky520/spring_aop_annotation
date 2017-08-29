package com.hx.spring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.hx.spring.entity.User;
import com.hx.spring.service.UserService;

/**
 * @author @DT人 2017年7月21日 上午10:19:04
 *
 */
//@Component("userController")
@Scope("prototype") // 注解指定为多例
@Controller("userController") // @Controller用于控制层的注入
public class UserController {
	/*
	 * 这些变量或对象都是用来接收参数的,也是被下面方法所使用的
	 */
	private User user;
	private UserService userService;
	private Integer id;
	private List<String> names;
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * 在控制器实现自己的三个方法 add delete load
	 */
	public void add() {
		userService.add(user);
	}
	
	public void delete() {
		userService.delete(id);
	}
	
	public void load() {
		userService.load(id);
	}
	
	public void list() {
		System.out.println(names);
	}
}
