package com.hr.dao;

import com.hr.bean.User;

public interface UserDao {

	/**
	 * 登录
	 * 	sql: select * from users where username=? and password=?
	 */
	User getUser(User user);
	
}
