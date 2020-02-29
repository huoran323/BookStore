package com.hr.service.impl;

import java.util.Date;
import java.util.List;

import com.hr.bean.Book;
import com.hr.bean.Cart;
import com.hr.bean.CartItem;
import com.hr.bean.Order;
import com.hr.bean.OrderItem;
import com.hr.bean.User;
import com.hr.dao.BookDao;
import com.hr.dao.OrderDao;
import com.hr.dao.OrderItemDao;
import com.hr.dao.impl.BookDaoImpl;
import com.hr.dao.impl.OrderDaoImpl;
import com.hr.dao.impl.OrderItemDaoImpl;
import com.hr.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public String createOrder(Cart cart, User user) {
		//1.生成订单
		//orderId=时间戳+userid
		String orderId = System.currentTimeMillis()+""+user.getId();
		orderDao.insertOrder(new Order(orderId, new Date(), cart.getTotalCount(), cart.getTotalAmount(), 0, user.getId()));
		
		//获取所有购物项
		List<CartItem> cartItems = cart.getCartItems();
		//遍历购物项，添加到订单详情
		for(CartItem cartItem : cartItems) {
			//2.生成订单详情
			Book book = cartItem.getBook();
			int count = cartItem.getCount(); //购买的数量
			orderItemDao.insertOrderItem(new OrderItem(null, count, cartItem.getAmount(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getImgPath(), orderId));
			
			//3.更改相应book的库存和销量
			int stock = book.getStock() - count; //剩余库存
			int sales = book.getSales() + count; //目前销量
			bookDao.updateBook(stock, sales, book.getId());
		}
		
		//4.清空购物车
		cart.emptyCart();
		
		return orderId;
	}

}
