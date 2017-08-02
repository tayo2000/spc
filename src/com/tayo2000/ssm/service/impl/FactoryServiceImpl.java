package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayo2000.ssm.mapper.FactoryMapper;
import com.tayo2000.ssm.po.Factory;
import com.tayo2000.ssm.service.FactoryService;
@Service("factoryService")
public class FactoryServiceImpl implements FactoryService {

	@Autowired
	private FactoryMapper fMapper;
	
	@Override
	public Factory find(String fNo) throws Exception {
		// TODO Auto-generated method stub
		return fMapper.find(fNo);
	}

	@Override
	public int delete(String fNo) throws Exception {
		// TODO Auto-generated method stub
		return fMapper.delete(fNo);
	}

	@Override
	public int add(Factory factory) throws Exception {
		// TODO Auto-generated method stub
		return fMapper.add(factory);
	}

	@Override
	public int update(Factory factory) throws Exception {
		// TODO Auto-generated method stub
		return fMapper.update(factory);
	}

	@Override
	public List<Factory> listAll() throws Exception {
		// TODO Auto-generated method stub
		return fMapper.listAll();
	}

}
