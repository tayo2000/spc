package com.tayo2000.ssm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	@Override
	public void init(FilterConfig filterChain) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        String url=request.getRequestURI();
			if(url.indexOf("login.jsp")>0)	{
				filterChain.doFilter(servletRequest, servletResponse);
				return;
			}
			HttpSession session = request.getSession();
	        // 获得用户请求的URI
	        String contextPath = request.getContextPath();
	        String username = (String) session.getAttribute("username");
	        if (username == null || "".equals(username)) {
	            response.sendRedirect(contextPath+"/jsp/login.jsp");
	            return;
	        }
	        filterChain.doFilter(servletRequest, servletResponse);
	}



}
