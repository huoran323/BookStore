package com.hr.dao.impl;

import com.hr.bean.User;
import com.hr.dao.BaseDao;
import com.hr.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUser(User user) {
		
		String sql = "SELECT id,username,`password`,email FROM users WHERE username=? AND `password`=?";
		return this.getBean(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public boolean checkUserName(String username) {
		// TODO Auto-generated method stub
		String sql = "select id, username, `password`, email from users where username = ?";
		User user = this.getBean(sql, username);
		return user != null;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into users(username, password, email) values(?,?,?)";
		this.update(sql, user.getUsername(),user.getPassword(),user.getEmail());
	}

}
