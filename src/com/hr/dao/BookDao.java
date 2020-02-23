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
	 * 实现分页查询Book
	 */
	public Page<Book> getBooksByPage(Page<Book> page);
}
