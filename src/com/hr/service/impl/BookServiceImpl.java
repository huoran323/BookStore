package com.hr.service.impl;

import java.util.List;

import com.hr.bean.Book;
import com.hr.bean.Page;
import com.hr.dao.BookDao;
import com.hr.dao.impl.BookDaoImpl;
import com.hr.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();
	@Override
	public List<Book> getAllBooks() {
		
		return bookDao.getAllBooks();
	}
	
	@Override
	public void addBook(Book book) {
		
		bookDao.addBook(book);
	}

	@Override
	public void delBookById(String id) {
		
		bookDao.delBookById(id);
	}

	@Override
	public Book getBookById(String id) {
		
		return bookDao.getBookById(id);
	}

	@Override
	public void updateBook(Book book) {
		
		bookDao.updateBook(book);
	}

	@Override
	public Page<Book> getBookByPage(String pageNo) {
		
		Page<Book> page = new Page<Book>();
		int pNo = 1;
		try {
			//解决第一次请求页码为空时，将页码赋值为1
			pNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
			
		}
		page.setPageNo(pNo);
		return bookDao.getBooksByPage(page);
	}

}
