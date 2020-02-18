package com.hr.test;

import org.junit.jupiter.api.Test;

import com.hr.bean.User;
import com.hr.dao.UserDao;
import com.hr.dao.impl.UserDaoImpl;

class UserDaoImplTest {

	//多态
	private UserDao userDao = new UserDaoImpl();
	
	@Test
	void testGetUser() {
		
		User user = userDao.getUser(new User(null, "test01", "test01", null));
		
		System.out.println(user);
	}
	
	@Test
	void testCheckUserName() {
		boolean bool = userDao.checkUserName("test01");
		System.out.println(bool);
	}

}
