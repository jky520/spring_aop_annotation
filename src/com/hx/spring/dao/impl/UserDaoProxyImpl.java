package com.hx.spring.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hx.spring.dao.UserDao;
import com.hx.spring.entity.User;
import com.hx.spring.log.Logger;

@Component("userDaoProxy")
public class UserDaoProxyImpl implements UserDao {
	
	private UserDao  userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		Logger.info("增加了用户");
		userDao.add(user);
	}

	@Override
	public void delete(int id) {
		Logger.info("删除了用户");
		userDao.delete(id);
	}

	@Override
	public User load(int id) {
		return null;
	}

}
