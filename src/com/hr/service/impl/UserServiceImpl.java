package com.hr.service.impl;

import com.hr.bean.User;
import com.hr.dao.UserDao;
import com.hr.dao.impl.UserDaoImpl;
import com.hr.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

	@Override
	public boolean checkUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.checkUserName(username);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveUser(user);
	}

}
