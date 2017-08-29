package com.hx.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hx.spring.dao.UserDao;
import com.hx.spring.entity.User;
import com.hx.spring.service.UserService;

/**
 * @author @DT人 2017年7月21日 上午8:39:37
 *
 */
//@Component("userService")
@Service("userService") // @Service用于业务逻辑层的注入
public class UserServiceImpl implements UserService {
	
	private UserDao userDao; // 实例化对应的dao接口对象
	
	/*
	 * @Resource可以不加值，默认是通过名称注入
	 * 在JSR330中提供@Inject来注入（这个需要导入Inject的jar才能用）
	 * 如果指定name = "userDao"，则 与dao类上Conpnent的值一致
	 */
	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user); // 通过接口对象调用相应的方法
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public User load(int id) {
		return userDao.load(id);
	}

}
