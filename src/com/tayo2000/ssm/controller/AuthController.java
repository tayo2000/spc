package com.tayo2000.ssm.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tayo2000.ssm.po.Auth;
import com.tayo2000.ssm.po.AuthRole;
import com.tayo2000.ssm.po.Module;
import com.tayo2000.ssm.service.AuthRoleService;
import com.tayo2000.ssm.service.AuthService;
import com.tayo2000.ssm.service.ModuleService;

@Controller
public class AuthController {
	private static HashMap<String,String> actionMap=new HashMap<String,String>();
	static {
		actionMap.put("Add", "添加");
		actionMap.put("Delete", "删除");
		actionMap.put("Update", "更新");
		actionMap.put("List", "列出");
		actionMap.put("Search", "查找");
	}
	@Autowired
	private AuthService authService;

	@Autowired
	private ModuleService moduleService;
	
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
	
	@RequestMapping("/authRoleAdd")
	@ResponseBody
	public String authRoleAdd(AuthRole[] authRoleList) throws Exception{
	
		return "ok";
	}
	
	@RequestMapping("/authUpdate")
	public String authUpdate(Auth auth) throws Exception{
		authService.update(auth);
		return "auth/authList";
	}
	
	
	@RequestMapping("/authMng")
	@ResponseBody
	public String authMng(HttpServletRequest request) throws Exception{
	    Enumeration<String> en=request.getParameterNames();
	    while(en.hasMoreElements()){
	    	String[] info=en.nextElement().split("_");
	    	String moduleId=info[0];
	    	String action=info[1];
	    	String authId=moduleId+action;
	    	if(authService.listById(authId)==null) {
	    		Auth au=new Auth();
		    	au.setModuleId(moduleId);
		    	au.setAuthId(authId);
		    	au.setUrl("/"+moduleId+action+".action");
		    	Module m=moduleService.listById(moduleId);
		    	String actionName=actionMap.get(action);
		    	String desc=actionName+m.getModuleName();
		    	au.setAuthDesc(desc);
		    	au.setAuthName(desc);
		    	authService.add(au);
	    	}
	    }
	    return "ok";
	}
}
