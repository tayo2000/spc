package com.tayo2000.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tayo2000.ssm.utils.VerifyCodeUtils;

@Controller
public class VerifyCodeController {
	@RequestMapping("/verifyCodeImage")
	public void verifyCodeImage(HttpServletRequest request,HttpServletResponse response) throws Exception{
			response.setHeader("Pragma", "No-cache"); 
	        response.setHeader("Cache-Control", "no-cache"); 
	        response.setDateHeader("Expires", 0); 
	        response.setContentType("image/jpeg"); 
	        //生成随机字串 
	        String verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
	        //存入会话session 
	        HttpSession session = request.getSession(true); 
	        //删除以前的
	        session.removeAttribute("verifycode");
	        session.setAttribute("verifycode", verifyCode.toLowerCase()); 
	        //生成图片 
	        int w = 80, h = 30; 
	        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode); 
	}
	
}
