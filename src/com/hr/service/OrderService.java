package com.hr.service;

import com.hr.bean.Cart;
import com.hr.bean.User;

public interface OrderService {

	/**
	 * 生成订单
	 * @param cart
	 * @param user
	 * @return 返回订单号
	 */
	public String createOrder(Cart cart, User user);
}
