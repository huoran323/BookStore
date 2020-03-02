package com.hr.dao.impl;

import com.hr.bean.OrderItem;
import com.hr.dao.BaseDao;
import com.hr.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	@Override
	public void insertOrderItem(OrderItem orderItem) {
		
		String sql = "insert into order_item(`count`, amount, title, author, price, img_path, order_id) values(?,?,?,?,?,?,?)";
		this.update(sql, orderItem.getCount(),orderItem.getAmount(),orderItem.getTitle(),orderItem.getAuthor(),orderItem.getPrice(),orderItem.getImgPath(),orderItem.getOrderId());
	}

	@Override
	public void insertOrderItem(Object[][] params) {
		
		String sql = "insert into order_item(`count`, amount, title, author, price, img_path, order_id) values(?,?,?,?,?,?,?)";
		this.batchUpdate(sql, params);
	}

}
