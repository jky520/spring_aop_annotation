package com.hx.spring.service;

import com.hx.spring.entity.User;

/**
 * @author @DT人 2017年7月20日 下午9:36:17
 *
 */
public interface UserService {
	void add(User user);
	
	void delete(int id);
	
	User load(int id);
}
