package com.tayo2000.ssm.mapper;

import java.util.List;

import com.tayo2000.ssm.po.UserRole;

public interface UserRoleMapper {
	public List<UserRole> list()  throws Exception;
	public int add(UserRole ur) throws Exception;
	public int delete(UserRole ur) throws Exception;
	public int deleteByUserName(String username) throws Exception;
}
