package com.tayo2000.ssm.service;

import java.util.List;

import com.tayo2000.ssm.po.RealTimeValue;
import com.tayo2000.ssm.po.RealTimeValueQuery;

public interface RealTimeValueService {
	public List<RealTimeValue> list(RealTimeValueQuery rtvQuery)throws Exception;
	public int getTotalRecord(RealTimeValueQuery rtvQuery) throws Exception;
	public List<RealTimeValue> listByPagination(RealTimeValueQuery rtvQuery) throws Exception;
	public List<RealTimeValue> listLastest(String fNo)throws Exception; 
}
