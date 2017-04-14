package com.tayo2000.ssm.mapper;

import java.util.List;

import com.tayo2000.ssm.po.AuthRole;

public interface AuthRoleMapper {
	public List<AuthRole> list()  throws Exception;
	public List<AuthRole> listByRoleId(String roleId) throws Exception;
	public int add(AuthRole ar) throws Exception;
	public int delete(AuthRole ar) throws Exception;
}
