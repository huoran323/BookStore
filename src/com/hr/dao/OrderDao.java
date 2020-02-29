package com.hr.dao;

import com.hr.bean.Order;

public interface OrderDao {

	/**
	 * 添加Order
	 * @param order
	 */
	void insertOrder(Order order);
}
