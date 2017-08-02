package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayo2000.ssm.mapper.RoleMapper;
import com.tayo2000.ssm.po.Role;
import com.tayo2000.ssm.service.RoleService;
@Service("roleService")
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
	public int delete(String roleId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(roleId);
	}

	@Override
	public int update(Role role) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(role);
	}

	@Override
	public List<Role> listByUser(String username) throws Exception {
		// TODO Auto-generated method stub
		return mapper.listByUser(username);
	}

	@Override
	public List<Role> RevListByUser(String username) throws Exception {
		// TODO Auto-generated method stub
		return mapper.RevListByUser(username);
	}

}
