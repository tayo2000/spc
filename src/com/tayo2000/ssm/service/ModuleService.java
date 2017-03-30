package com.tayo2000.ssm.service;

import java.util.List;

import com.tayo2000.ssm.po.Module;

public interface ModuleService {
	public List<Module> list() throws Exception;
	public int delete(String moduleName)throws Exception;
	public int add(Module module) throws Exception;
	public int update(Module module) throws Exception;
}
