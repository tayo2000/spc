package com.tayo2000.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tayo2000.ssm.po.Auth;
import com.tayo2000.ssm.service.AuthService;

@Controller
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@RequestMapping("/authList")
	@ResponseBody
	public List<Auth> authList() throws Exception{
		List<Auth> list=authService.list();
		return list;
	}
	
	
	@RequestMapping("/authDelete")
	public String authDelete(String  authId) throws Exception{
		authService.delete(authId);
		return "auth/authList";
	}
	
	@RequestMapping("/authAdd")
	public String authAdd(Auth auth) throws Exception{
		authService.add(auth);
		return "auth/authList";
	}
	
	@RequestMapping("/authUpdate")
	public String authUpdate(Auth auth) throws Exception{
		authService.update(auth);
		return "auth/authList";
	}
}
