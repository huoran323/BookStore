package com.hr.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.util.JDBCUtils;

/**
 * Servlet Filter implementation class TransactionFilter
 */
public class TransactionFilter extends HttpFilter implements Filter {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		Connection connection = JDBCUtils.getConnection();
		try {
			//开启事务
			connection.setAutoCommit(false);
			//放行
			chain.doFilter(request, response);
			//无异常，提交事务
			connection.commit();
		} catch (Exception e) {
			
			//有异常，回滚
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/pages/error/transaction_error.jsp");
		} finally {
			//释放connection
			JDBCUtils.releaseConnection();
		}
		
		
	}
}
