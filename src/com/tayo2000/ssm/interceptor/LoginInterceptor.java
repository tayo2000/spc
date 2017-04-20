package com.tayo2000.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tayo2000.ssm.po.User;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String pathUrl=request.getRequestURI();
		if(pathUrl.indexOf("userLogin.action")>0 || 
		   pathUrl.indexOf("verifyCodeImage.action")>0 ||
		   pathUrl.indexOf("login.action")>0)	return true;
		//判断session
		HttpSession session  = request.getSession();
		//从session中取出用户身份信息
		User user=(User) session.getAttribute("user");
		if(user==null || "".equals(user.getUsername()) ){
			//执行这里表示用户身份需要认证，跳转登陆页面
			response.sendRedirect("jsp/login.jsp");
			return false;
		}
		System.out.print("正在访问的是："+pathUrl);
		boolean flag=false;
		for(String authUrl: user.getUrlList()){
			if(pathUrl.contains(authUrl)) {flag=true;break;}
		}
		if(flag) {
			System.out.print("有权访问");
			response.sendRedirect("jsp/login.jsp");
			return false;
		}
		else{
			System.out.print("无权访问");
		}
		System.out.println();
		return true;
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
