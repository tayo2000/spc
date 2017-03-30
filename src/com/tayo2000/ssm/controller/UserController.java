package com.tayo2000.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tayo2000.ssm.po.User;
import com.tayo2000.ssm.service.UserService;
import com.tayo2000.ssm.utils.Tool;

@Controller
public class UserController {
	@Autowired
	private  UserService userService;

	@RequestMapping("/userLogin")
	public String userLogin(@Validated User user,BindingResult bindResult,HttpSession session,RedirectAttributes attrs) throws Exception{
		attrs.addFlashAttribute("user", user);
		FieldError usernameError=bindResult.getFieldError("username");
		FieldError passwordError=bindResult.getFieldError("password");
		FieldError verifycodeError=bindResult.getFieldError("verifycode");
	
		if(usernameError!=null ) 	attrs.addFlashAttribute("usernameMsg",usernameError.getDefaultMessage());
		if(passwordError!=null) 	attrs.addFlashAttribute("passwordMsg",passwordError.getDefaultMessage());
		if(verifycodeError!=null) 	attrs.addFlashAttribute("verifycodeMsg",verifycodeError.getDefaultMessage());
		if(usernameError!=null || passwordError!=null|| verifycodeError!=null) 	return "redirect:login.action";
		String verifycode=user.getVerifycode();
		if(verifycode==null || !verifycode.equalsIgnoreCase(session.getAttribute("verifycode").toString())) {
			attrs.addFlashAttribute("verifycodeMsg","验证码不正确");
			return "redirect:login.action";
		}
		String username=user.getUsername();
		String password=Tool.md5(user.getPassword());
		user=userService.find(username);
		if(user==null){
			attrs.addFlashAttribute("usernameMsg","用户名不存在");
			return "redirect:login.action";
		}
		if(!password.equals(user.getPassword())){
			attrs.addFlashAttribute("passwordMsg","密码不正确");
			return "redirect:login.action";
		}
		session.setAttribute("username", username);
		session.setAttribute("role", user.getRole());
		session.setAttribute("fNo", user.getfNo());
		if(user.getLoginState()!=1){
			user.setLoginState(1);
			user.setLoginCount(user.getLoginCount()+1);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			user.setLoginTime(sdf.format(new Date()));
			userService.updateState(user);
		}
		return  "redirect:/jsp/index.jsp";
	}
		
	@RequestMapping("/login")
	public String login(Model model,@ModelAttribute("user") User user,@ModelAttribute("usernameMsg") String usernameMsg
								,@ModelAttribute("passwordMsg") String passwordMsg
								,@ModelAttribute("verifycodeMsg") String verifycodeMsg){
		model.addAttribute("usernameMsg", usernameMsg);
		model.addAttribute("passwordMsg", passwordMsg);
		model.addAttribute("verifycodeMsg", verifycodeMsg);
		return "login";
	}
	
	@RequestMapping("/userLogout")
	public String userLogout(HttpSession session) throws Exception{
		String username=(String) session.getAttribute("username");
		if(username!=null && username!=""){
			User user=userService.find(username);
			if(user!=null) {
				user.setLoginState(0);
				userService.updateState(user);
			}
		}
		session.invalidate();
		return "redirect:/jsp/login.jsp";
	}
	
	@RequestMapping("/userList")
	@ResponseBody
	public List<User> userList(HttpSession session) throws Exception{
		return userService.listAll();
	}
	
	@RequestMapping("/userAdd")
	public String userAdd(User user)throws Exception{
		userService.add(user);
		return "user/userList";
	}
	
	@RequestMapping("/userInfoUpdate")
	public String userInfoUpdate(User user)throws Exception{
		userService.updateInfo(user);
		return "user/userList";
	}
	
	@RequestMapping("/userPasswordUpdate")
	public String userPasswordUpdate(String username,String password1,String password2)throws Exception{
		userService.updatePassword(username, password1);
		return "user/userList";
	}
	
	@RequestMapping("/userDelete")
	public String userDelete(String username)throws Exception{
		userService.delete(username);
		return "user/userList";
	}
	
}
