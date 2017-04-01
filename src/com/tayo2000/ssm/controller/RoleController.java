package com.tayo2000.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tayo2000.ssm.po.Role;
import com.tayo2000.ssm.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	
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
}
