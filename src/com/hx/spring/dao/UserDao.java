package com.hx.spring.dao;

import com.hx.spring.annotation.LogInfo;
import com.hx.spring.entity.User;

public interface UserDao {
	@LogInfo("新增用户")
	void add(User user);
	
	void delete(int id);
	
	User load(int id);
}
