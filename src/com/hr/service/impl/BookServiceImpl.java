package com.hr.service.impl;

import java.util.List;

import com.hr.bean.Book;
import com.hr.dao.BookDao;
import com.hr.dao.impl.BookDaoImpl;
import com.hr.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooks();
	}

}
