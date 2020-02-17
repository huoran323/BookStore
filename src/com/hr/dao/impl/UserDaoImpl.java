package com.hr.dao.impl;

import com.hr.bean.User;
import com.hr.dao.BaseDao;
import com.hr.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUser(User user) {
		
		String sql = "SELECT id,username,`password`,email FROM users WHERE username=? AND `password`=?";
		User user2 = this.getBean(sql, user.getUsername(),user.getPassword());
		return user2;
	}

}
