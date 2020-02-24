package com.hr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.bean.Book;
import com.hr.bean.Page;
import com.hr.service.BookService;
import com.hr.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bookService = new BookServiceImpl();
       
	/**
	 * 客户端的分页查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBooksByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageNo = request.getParameter("pageNo");
		Page<Book> page = bookService.getBookByPage(pageNo);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/client/book_client.jsp").forward(request, response);
	}

	/**
	 * 带价格区间的分页查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBooksByPageAndPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageNo = request.getParameter("pageNo");
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		
		Page<Book> page = bookService.getBookByPageAndPrice(pageNo, min, max);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/client/book_client.jsp").forward(request, response);
	}
}
