package com.hr.dao;


import java.util.List;

import com.hr.bean.Book;

public interface BookDao {

	/**
	 * 查询所有book信息
	 */
	public List<Book> getAllBooks();
}
