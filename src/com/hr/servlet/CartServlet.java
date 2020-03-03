package com.hr.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
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
		//验证库存
		Integer stock = book.getStock();//获取库存
		int count = cart.getMap().get(book.getId()+"").getCount(); //获取购买的数量
		if (count > stock) {
			//库存不足
			session.setAttribute("msg", "库存不足，只剩"+stock+"件商品！");
			//将购买商品的数量，设置为最大库存
			cart.getMap().get(book.getId()+"").setCount(stock);
		} else {
			//将title存放到session域中,用来显示
			session.setAttribute("title", book.getTitle());
		}
		//获取Referer:跳转 请求头中的Referer属性保存的是上一次的请求 , 防止添加购物车后页码回到第一页
		String url = request.getHeader("Referer");
		//跳转
		response.sendRedirect(url);
	}
	
	/**
	 * 删除购物项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String bookId = request.getParameter("bookId");
		Cart cart = (Cart)session.getAttribute("cart");
		if (cart != null) {
			cart.delCartItem(bookId);
		}
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}

	/**
	 * 清空购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void emptyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if (cart != null) {
			cart.emptyCart();
		}
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}
	
	/**
	 * 修改购物项的数量
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateCartItemCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		String bookId = request.getParameter("bookId");
		String count = request.getParameter("count");
		Cart cart = (Cart)session.getAttribute("cart");
		if (cart != null) {
			cart.updateCartItemCount(bookId, count);
		}
//		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
		
		//携带数据响应（回调函数）
		int totalCount = cart.getTotalCount();
		double totalAmount = cart.getTotalAmount();
		double amount = cart.getMap().get(bookId).getAmount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", totalCount);
		map.put("totalAmount", totalAmount);
		map.put("amount", amount);
		//将数据封装成json
		Gson gson = new Gson();
		String json = gson.toJson(map);
		//响应
		response.getWriter().write(json);
	}
}
