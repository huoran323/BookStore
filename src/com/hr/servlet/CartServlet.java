package com.hr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.bean.Book;
import com.hr.bean.Cart;
import com.hr.service.BookService;
import com.hr.service.impl.BookServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();
	/**
	 * 加入购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addBookToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//获取bookId
		String bookId = request.getParameter("bookId");
		//通过bookId获取book（BookService）
		Book book = bookService.getBookById(bookId);
		//调用Cart中的addBookToCart
		//Cart存放session域中
		Cart cart = (Cart)session.getAttribute("cart");
		if (cart == null) {
			//第一次进来的时候，cart没有，需要重新new
			cart = new Cart();
			//存放到session域中
			session.setAttribute("cart", cart);
		}
		cart.addBookToCart(book);
		//将title存放到session域中,用来显示
		session.setAttribute("title", book.getTitle());
		//跳转
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
