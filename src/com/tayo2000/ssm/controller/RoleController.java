package com.tayo2000.ssm.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tayo2000.ssm.po.Role;
import com.tayo2000.ssm.po.UserRole;
import com.tayo2000.ssm.service.RoleService;
import com.tayo2000.ssm.service.UserRoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping("/roleList")
	@ResponseBody
	public List<Role> roleList() throws Exception{
		List<Role> list=roleService.list();
		return list;
	}
	
	
	@RequestMapping("/roleDelete")
	public String roleDelete(String  roleId) throws Exception{
		roleService.delete(roleId);
		return "role/roleList";
	}
	
	@RequestMapping("/roleAdd")
	public String roleAdd(Role role) throws Exception{
		roleService.add(role);
		return "role/roleList";
	}
	
	@RequestMapping("/roleUpdate")
	public String roleUpdate(Role role) throws Exception{
		roleService.update(role);
		return "role/roleList";
	}
	
	@RequestMapping(value="/userRoleAdd")
	@ResponseBody
	public HashMap<String, String> userRoleAdd(String username,@RequestBody UserRole[] userRoleList) throws Exception{
		userRoleService.deleteByUserName(username);
		for(int i=0;i<userRoleList.length;i++)	userRoleService.add(userRoleList[i]);
		HashMap<String,String> result=new HashMap<String,String>();
		result.put("success", "ok");
		return result;
	}
	
	@RequestMapping("/roleSelectedList")
	@ResponseBody
	public List<Role> roleSelectedList(String username) throws Exception{
		List<Role> list=roleService.listByUser(username);
		return list;
	}
	
	@RequestMapping("/roleUnSelectedList")
	@ResponseBody
	public List<Role> roleUnSelectedList(String username) throws Exception{
		List<Role> list=roleService.RevListByUser(username);
		return list;
	}
}
