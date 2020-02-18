package com.hr.service;

import com.hr.bean.User;

public interface UserService {

	/**
	 * 登录	
	 */
	User getUser(User user);
	
	/**
	 * 检查用户名是否存在
	 */
	boolean checkUserName(String username);
	
	/**
	 * 将user信息保存到数据库中
	 */
	void saveUser(User user);
}
