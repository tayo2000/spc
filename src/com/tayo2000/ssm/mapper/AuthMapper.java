package com.tayo2000.ssm.mapper;

import java.util.List;

import com.tayo2000.ssm.po.Auth;

public interface AuthMapper {
	public List<Auth> list() throws Exception;
	public List<Auth> listByRoleId(String roleId ) throws Exception;
	public List<Auth> RevListByRoleId(String roleId ) throws Exception;
	public int delete(String authId)throws Exception;
	public int add(Auth auth) throws Exception;
	public int update(Auth auth) throws Exception;
	public Auth listById(String id) throws Exception;
}
