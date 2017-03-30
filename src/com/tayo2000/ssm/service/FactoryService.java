package com.tayo2000.ssm.service;

import java.util.List;

import com.tayo2000.ssm.po.Factory;

public interface FactoryService {
	public List<Factory> listAll() throws Exception;
	public Factory find(String fNo) throws Exception;
	public int delete(String fNo)throws Exception;
	public int add(Factory factory) throws Exception;
	public int update(Factory factory) throws Exception;
}
