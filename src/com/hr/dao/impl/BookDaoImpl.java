package com.hr.dao.impl;

import java.util.List;

import com.hr.bean.Book;
import com.hr.bean.Page;
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

	@Override
	public Page<Book> getBooksByPage(Page<Book> page) {
		
		// 获取totalRecord
		String sql = "select count(*) from books";
		//通过+""，装换为string，再装换为int
		int count = Integer.parseInt(this.getSingleValue(sql)+"");
		//将totalRecord赋值
		page.setTotalRecord(count);
		
		String sql1 = "select id,title,author,price,sales,stock,img_path from books where 1=1 limit ? , ?";
		List<Book> list = this.getBeanList(sql1, (page.getPageNo()-1)*Page.PAGE_SIZE ,Page.PAGE_SIZE);
		page.setList(list);
		
		return page;
	}

	@Override
	public Page<Book> getBooksByPageAndPrice(Page<Book> page, double min, double max) {
		
		// 获取totalRecord
		String sql = "select count(*) from books where 1=1 and price between ? and ?";
		//通过+""，装换为string，再装换为int
		int count = Integer.parseInt(this.getSingleValue(sql, min, max)+"");
		//将totalRecord赋值
		page.setTotalRecord(count);
		
		String sql1 = "select id,title,author,price,sales,stock,img_path from books where 1=1 and price between ? and ? limit ? , ?";
		List<Book> list = this.getBeanList(sql1, min, max, (page.getPageNo()-1)*Page.PAGE_SIZE ,Page.PAGE_SIZE);
		page.setList(list);
		
		return page;
	}

}
