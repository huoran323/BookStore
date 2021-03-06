package com.hr.dao;

import com.hr.bean.User;

public interface UserDao {

	/**
	 * 登录
	 * 	sql: select * from users where username=? and password=?
	 */
	User getUser(User user);
	
	/**
	 * 检查用户名是否存在
	 */
	boolean checkUserName(String username);
	
	/**
	 * 将user信息保存到数据库中
	 * sql:insert into users(username,password,email) values(?,?,?)
	 */
	void saveUser(User user);
}
