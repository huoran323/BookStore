package com.hr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.bean.Book;
import com.hr.service.BookService;
import com.hr.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private BookService bookService = new BookServiceImpl();
	/**
	 * 查询所有的book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//调用service中的相应方法
		List<Book> allBooks = bookService.getAllBooks();
		//将books存放到域中
		request.setAttribute("books", allBooks);
		//跳转
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

	/**
	 * 添加图书
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取值
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		
		//调用service
		bookService.addBook(new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null));
		
		//跳转，重新查询，book_manager.jsp
//		getAllBooks(request, response);
		//两种方法即可，使用重定向调用上面的方法
		response.sendRedirect(request.getContextPath()+"/BookServlet?method=getAllBooks");
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取值
		String bookId = request.getParameter("bookId");
		
		//调用service
		bookService.delBookById(bookId);
		
		//跳转
		response.sendRedirect(request.getContextPath()+"/BookServlet?method=getAllBooks");
	}
}
