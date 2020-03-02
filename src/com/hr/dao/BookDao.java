package com.hr.dao;


import java.util.List;

import com.hr.bean.Book;
import com.hr.bean.Page;

public interface BookDao {

	/**
	 * 查询所有book信息
	 */
	public List<Book> getAllBooks();
	
	/**
	 * 添加book信息
	 */
	public void addBook(Book book);
	
	/**
	 * 删除Book
	 */
	public void delBookById(String id);
	
	public Book getBookById(String id);
	
	/**
	 * 修改Book
	 */
	public void updateBook(Book book);
	
	/**
	 * 重载修改Book的销量和库存
	 */
	public void updateBook(int stock, int sales, int id);
	
	/**
	 * 批处理
	 * @param params
	 */
	public void updateBook(Object[][] params);
	
	/**
	 * 实现分页查询Book
	 */
	public Page<Book> getBooksByPage(Page<Book> page);
	
	/**
	 * 实现带价格区间的分页查询
	 */
	public Page<Book> getBooksByPageAndPrice(Page<Book> page, double min, double max);
}
