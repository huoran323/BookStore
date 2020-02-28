package com.hr.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class CharSetFilter
 */
public class CharSetFilter extends HttpFilter implements Filter {
      
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String code = this.getFilterConfig().getInitParameter("code");
		//处理字符集
//		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding(code); //通过获取初始化参数，获取字符集
		response.setContentType("text/html;charset=UTF-8");
		
		chain.doFilter(request, response);
	}

}
