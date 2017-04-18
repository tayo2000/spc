package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tayo2000.ssm.mapper.AuthRoleMapper;
import com.tayo2000.ssm.po.AuthRole;
import com.tayo2000.ssm.service.AuthRoleService;

public class AuthRoleServiceImpl implements AuthRoleService {
	@Autowired
	private AuthRoleMapper mapper;
	@Override
	public List<AuthRole> list() throws Exception {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public int add(AuthRole ar) throws Exception {
		// TODO Auto-generated method stub
		return mapper.add(ar);
	}

	@Override
	public int delete(AuthRole ar) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(ar);
	}

	@Override
	public List<AuthRole> listByRoleId(String roleId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.listByRoleId(roleId);
	}

	@Override
	public int isExist(AuthRole ar) throws Exception {
		// TODO Auto-generated method stub
		return mapper.isExist(ar);
	}

	@Override
	public int deleteByRoleId(String roleId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deleteByRoleId(roleId);
	}

}
