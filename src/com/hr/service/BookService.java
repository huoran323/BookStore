package com.hr.service;

import java.util.List;

import com.hr.bean.Book;
import com.hr.bean.Page;

public interface BookService {

	//查询图书
	public List<Book> getAllBooks();
	
	//添加图书
	public void addBook(Book book);
	
	//删除图书
	public void delBookById(String id);
	
	public Book getBookById(String id);
	
	//修改图书
	public void updateBook(Book book);
	
	//分页查询
	public Page<Book> getBookByPage(String pageNo);
}
