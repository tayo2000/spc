package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayo2000.ssm.mapper.RealTimeValueMapper;
import com.tayo2000.ssm.po.RealTimeValue;
import com.tayo2000.ssm.po.RealTimeValueQuery;
import com.tayo2000.ssm.service.RealTimeValueService;
@Service("rtvService")
public class RealTimeValueServiceImpl implements RealTimeValueService {
	@Autowired
	RealTimeValueMapper rtvMapper;
	@Override
	public List<RealTimeValue> list(RealTimeValueQuery rtvQuery) throws Exception {
		// TODO Auto-generated method stub
		return rtvMapper.list(rtvQuery);
	}
	@Override
	public int getTotalRecord(RealTimeValueQuery rtvQuery) throws Exception {
		// TODO Auto-generated method stub
		return rtvMapper.getTotalRecord(rtvQuery);
	}
	@Override
	public List<RealTimeValue> listByPagination(RealTimeValueQuery rtvQuery) throws Exception {
		// TODO Auto-generated method stub
		return rtvMapper.listByPagination(rtvQuery);
	}
	@Override
	public List<RealTimeValue> listLastest(String fNo) throws Exception {
		// TODO Auto-generated method stub
		return rtvMapper.listLastest(fNo);
	}


}
