package com.tayo2000.ssm.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tayo2000.ssm.po.Auth;
import com.tayo2000.ssm.po.AuthRole;
import com.tayo2000.ssm.po.Module;
import com.tayo2000.ssm.po.Pager;
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
	private AuthRoleService authRoleService;

	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("/authList")
	@ResponseBody
	public Map<String, Object> authList(HttpServletRequest request) throws Exception{
		Pager<Auth> pager=new Pager<Auth>();
		int totalCount=authService.getTotalRecord();
		int pageIndex=Integer.parseInt(request.getParameter("page")==null?"1":request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("rows")==null?"10":request.getParameter("rows"));
		pager.setStartPos((pageIndex-1)*pageSize);
		pager.setPageSize(pageSize);
		pager.setTotalCount(totalCount);
		List<Auth> list=authService.listByPagination(pager);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", totalCount);
		jsonMap.put("rows", list);
		return jsonMap;
//		List<Auth> list=authService.list();
//		return list;
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
	
	@RequestMapping(value="/authRoleAdd")
	@ResponseBody
	public HashMap<String, String> authRoleAdd(String roleId,@RequestBody AuthRole[] authRoles) throws Exception{
		authRoleService.deleteByRoleId(roleId);
		for(int i=0;i<authRoles.length;i++)	authRoleService.add(authRoles[i]);
		HashMap<String,String> result=new HashMap<String,String>();
		result.put("success", "ok");
		return result;
	}
	
	@RequestMapping("/authSelectedList")
	@ResponseBody
	public List<Auth> authSelectedList(String roleId) throws Exception{
		List<Auth> list=authService.listByRoleId(roleId);
		return list;
	}
	
	@RequestMapping("/authUnSelectedList")
	@ResponseBody
	public List<Auth> authUnSelectedList(String roleId) throws Exception{
		List<Auth> list=authService.RevListByRoleId(roleId);
		return list;
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
	    return "ok" ;
	}
}
