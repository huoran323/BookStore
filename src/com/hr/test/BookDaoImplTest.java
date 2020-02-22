package com.hr.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.hr.bean.Book;
import com.hr.dao.BookDao;
import com.hr.dao.impl.BookDaoImpl;

class BookDaoImplTest {
	
	BookDao bookDao = new BookDaoImpl();
	private List<Book> allBooks;

	@Test
	void testGetAllBooks() {
		allBooks = bookDao.getAllBooks();
		for(Book book : allBooks) {
			System.out.println(book);
		}
	}

}
