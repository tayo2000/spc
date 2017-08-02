package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayo2000.ssm.mapper.UserRoleMapper;
import com.tayo2000.ssm.po.UserRole;
import com.tayo2000.ssm.service.UserRoleService;
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleMapper mapper;
	
	@Override
	public List<UserRole> list() throws Exception {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public int add(UserRole ur) throws Exception {
		// TODO Auto-generated method stub
		return mapper.add(ur);
	}

	@Override
	public int delete(UserRole ur) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(ur);
	}

	@Override
	public int deleteByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deleteByUserName(username);
	}

}
