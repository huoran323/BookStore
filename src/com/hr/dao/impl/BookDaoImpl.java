package com.hr.dao.impl;

import java.util.List;

import com.hr.bean.Book;
import com.hr.dao.BaseDao;
import com.hr.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getAllBooks() {
		
		String sql = "select id,title,author,price,stock,img_path from books";
		return this.getBeanList(sql);
	}

}
