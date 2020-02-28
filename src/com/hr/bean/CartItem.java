package com.hr.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	private int count;
	private double amount; //总金额 = book.price*count
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * 计算购物项金额
	 * @return
	 */
	public double getAmount() {
		//使用BigDecimal解决double精度的问题，即double相乘，小数点后位数变多
		BigDecimal price = new BigDecimal(book.getPrice()+"");
		BigDecimal c = new BigDecimal(count+"");
		return price.multiply(c).doubleValue();
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public CartItem(Book book, int count, double amount) {
		super();
		this.book = book;
		this.count = count;
		this.amount = amount;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", amount=" + amount + "]";
	}
	
	
}
