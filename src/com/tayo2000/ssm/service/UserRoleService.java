package com.tayo2000.ssm.service;

import java.util.List;

import com.tayo2000.ssm.po.UserRole;

public interface UserRoleService {
	public List<UserRole> list()  throws Exception;
	public int add(UserRole ur) throws Exception;
	public int delete(UserRole ur) throws Exception;
}
