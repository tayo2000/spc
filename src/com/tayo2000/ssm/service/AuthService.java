package com.tayo2000.ssm.service;

import java.util.List;

import com.tayo2000.ssm.po.Auth;

public interface AuthService {
	public List<Auth> list() throws Exception;
	public int delete(String authId)throws Exception;
	public int add(Auth auth) throws Exception;
	public int update(Auth auth) throws Exception;
}
