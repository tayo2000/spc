package com.tayo2000.ssm.mapper;

import java.util.List;

import com.tayo2000.ssm.po.Role;

public interface RoleMapper {
	public List<Role> list() throws Exception;
	public int add(Role role)throws Exception;
	public int delete(String roleId) throws Exception;
	public int update(Role role) throws Exception;
}
