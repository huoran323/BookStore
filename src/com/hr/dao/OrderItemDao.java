package com.hr.dao;

import com.hr.bean.OrderItem;

public interface OrderItemDao {

	/**
	 * 添加orderItem
	 * @param orderItem
	 */
	void insertOrderItem(OrderItem orderItem);
}
