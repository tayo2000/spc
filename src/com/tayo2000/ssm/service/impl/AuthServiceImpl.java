package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tayo2000.ssm.mapper.AuthMapper;
import com.tayo2000.ssm.po.Auth;
import com.tayo2000.ssm.service.AuthService;

public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthMapper mapper;

	@Override
	public List<Auth> list() throws Exception {
		// TODO Auto-generated method stub
		return mapper.list();
	}


	@Override
	public int add(Auth auth) throws Exception {
		// TODO Auto-generated method stub
		return mapper.add(auth);
	}

	@Override
	public int update(Auth auth) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(auth);
	}

	@Override
	public int delete(String authId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(authId);
	}


	@Override
	public Auth listById(String id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.listById(id);
	}
	
	
}
