package com.hr.dao.impl;

import java.util.List;

import com.hr.bean.Book;
import com.hr.dao.BaseDao;
import com.hr.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getAllBooks() {
		
		String sql = "select id,title,author,price,sales,stock,img_path from books";
		return this.getBeanList(sql);
	}

	@Override
	public void addBook(Book book) {
		
		String sql = "insert into books(title, author, price, sales, stock, img_path) values(?,?,?,?,?,?)";
		this.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
		
	}

	@Override
	public void delBookById(String id) {
		
		String sql = "delete from books where id = ?";
		this.update(sql, id);
		
	}

	@Override
	public Book getBookById(String id) {
		
		String sql = "select id,title,author,price,sales,stock,img_path from books where id = ?";
		return this.getBean(sql, id);
	}

	@Override
	public void updateBook(Book book) {
		
		String sql = "update books set title=?, author=?, price=?, sales=?, stock=? where id=?";
		this.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getId());
	}

}
