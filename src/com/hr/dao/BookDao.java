package com.hr.dao;


import java.util.List;

import com.hr.bean.Book;

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
}
