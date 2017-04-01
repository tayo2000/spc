package com.tayo2000.ssm.service;
import java.util.List;
import com.tayo2000.ssm.po.Role;

public interface RoleService {
	public List<Role> list() throws Exception;
	public int add(Role role)throws Exception;
	public int delete(String roleId) throws Exception;
	public int update(Role role) throws Exception;
}
