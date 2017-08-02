package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayo2000.ssm.mapper.ModuleMapper;
import com.tayo2000.ssm.po.Module;
import com.tayo2000.ssm.service.ModuleService;
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private ModuleMapper mapper;
	
	
	@Override
	public List<Module> list() throws Exception {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public int add(Module module) throws Exception {
		// TODO Auto-generated method stub
		return mapper.add(module);
	}

	@Override
	public int update(Module module) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(module);
	}


	@Override
	public Module listById(String moduleId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.listById(moduleId);
	}

	@Override
	public int delete(String moduleId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(moduleId);
	}

	@Override
	public boolean isExist(String moduleId) throws Exception {
		if(mapper.listById(moduleId)!=null) return true;
		else return false;
	}

}
