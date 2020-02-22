package com.hr.service;

import java.util.List;

import com.hr.bean.Book;

public interface BookService {

	//查询图书
	public List<Book> getAllBooks();
	
	//添加图书
	public void addBook(Book book);
	
	//删除图书
	public void delBookById(String id);
}
