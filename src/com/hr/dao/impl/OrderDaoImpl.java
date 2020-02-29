package com.hr.dao.impl;

import com.hr.bean.Order;
import com.hr.dao.BaseDao;
import com.hr.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public void insertOrder(Order order) {
		
		String sql = "insert into orders(id, order_time, total_count, total_amount, state, user_id) values(?,?,?,?,?,?)";
		this.update(sql, order.getId(), order.getOrderTime(), order.getTotalCount(), order.getTotalAmount(), order.getState(), order.getUserId());
	}

}
