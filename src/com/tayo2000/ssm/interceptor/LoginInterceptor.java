package com.tayo2000.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url=request.getRequestURI();
		if(url.indexOf("userLogin.action")>0 || 
		   url.indexOf("verifyCodeImage.action")>0 ||
		   url.indexOf("login.action")>0)	return true;
		//判断session
		HttpSession session  = request.getSession();
		//从session中取出用户身份信息
		String username = (String) session.getAttribute("username");
		if(username!= null)	return true;
		//执行这里表示用户身份需要认证，跳转登陆页面
		//request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		response.sendRedirect("jsp/login.jsp");
		return false;

	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
