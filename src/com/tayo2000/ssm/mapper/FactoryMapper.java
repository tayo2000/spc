package com.tayo2000.ssm.mapper;
import java.util.List;

import com.tayo2000.ssm.po.Factory;

public interface FactoryMapper {
	public List<Factory> listAll() throws Exception;
	public Factory find(String fNo) throws Exception;
	public int delete(String fNo)throws Exception;
	public int add(Factory factory) throws Exception;
	public int update(Factory factory) throws Exception;
}
