package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.tayo2000.ssm.mapper.ModuleMapper;
import com.tayo2000.ssm.po.Module;
import com.tayo2000.ssm.service.ModuleService;

public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private ModuleMapper mMapper;
	
	
	@Override
	public List<Module> list() throws Exception {
		// TODO Auto-generated method stub
		return mMapper.list();
	}

	@Override
	public int delete(String moduleName) throws Exception {
		// TODO Auto-generated method stub
		return mMapper.delete(moduleName);
	}

	@Override
	public int add(Module module) throws Exception {
		// TODO Auto-generated method stub
		return mMapper.add(module);
	}

	@Override
	public int update(Module module) throws Exception {
		// TODO Auto-generated method stub
		return mMapper.update(module);
	}

}
