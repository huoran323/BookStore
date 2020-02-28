package com.hr.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//购物项集合, key:bookId , value:CartItem
	private Map<String,CartItem> map = new LinkedHashMap<>();
	//总商品数量
	private int totalCount;
	//总金额
	private double totalAmount;
	
	/**
	 * 加入购物车
	 * @param book
	 */
	public void addBookToCart(Book book) {
		//通过bookId获取CartItem
		CartItem cartItem = map.get(book.getId()+"");//通过map.get(key) 获取购物项,判断购物车中是否存在此购物项，若存在，则证明此购物项已经加入了购物车
		if (cartItem == null) {
			//没买过
			cartItem = new CartItem();
			cartItem.setCount(1); //数量+1
			cartItem.setBook(book); //添加购物项
			map.put(book.getId()+"", cartItem);
		} else {
			//买过,购物车数量加一
			int nCount = cartItem.getCount() + 1;
			cartItem.setCount(nCount);
		}
	}
	
	/**
	 * 获取所有的CartItems
	 * @return
	 */
	public List<CartItem> getCartItems() {
		return new ArrayList<CartItem>(map.values());
	}
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	/**
	 * 计算购物车总数量
	 * @return
	 */
	public int getTotalCount() {
		int totalCount = 0;
		for(CartItem cartItem : getCartItems()) {
			totalCount += cartItem.getCount();
		}
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 计算购物车的总金额
	 * @return
	 */
	public double getTotalAmount() {
		BigDecimal tAmount = new BigDecimal("0");
//		int totalAmount = 0;
		for(CartItem cartItem : getCartItems()) {
			BigDecimal amount = new BigDecimal(cartItem.getAmount()+"");
			tAmount = tAmount.add(amount); //解决double相加运算精度的问题
//			totalAmount += cartItem.getAmount();
		}
		return tAmount.doubleValue();
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Cart(Map<String, CartItem> map, int totalCount, double totalAmount) {
		super();
		this.map = map;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cart [map=" + map + ", totalCount=" + totalCount + ", totalAmount=" + totalAmount + "]";
	}
}
