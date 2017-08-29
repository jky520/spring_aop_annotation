package com.hx.spring.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hx.spring.dao.UserDao;
import com.hx.spring.entity.User;

/**
 * @author @DT人 2017年7月20日 下午9:39:54
 *
 */
// 下面这个注解相当于<bean id="userDao" class="com.hx.spring.dao.impl.UserDaoImpl"/>
//@Component("userDao") // 可以说公共创建bean的注解
@Repository("userDao") // @Repository一般用于DAO的注入
public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("添加了"+user);
	}

	@Override
	public void delete(int id) {
		System.out.println("删除了："+id);
	}

	@Override
	public User load(int id) {
		System.out.println("load:"+id);
		return null;
	}

}
