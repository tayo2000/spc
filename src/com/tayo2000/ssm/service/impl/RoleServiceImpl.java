package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tayo2000.ssm.mapper.RoleMapper;
import com.tayo2000.ssm.po.Role;
import com.tayo2000.ssm.service.RoleService;

public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleMapper mapper;
	
	@Override
	public List<Role> list() throws Exception {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public int add(Role role) throws Exception {
		// TODO Auto-generated method stub
		return mapper.add(role);
	}

	@Override
	public int delete(String roleName) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(roleName);
	}

	@Override
	public int update(Role role) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(role);
	}

}
