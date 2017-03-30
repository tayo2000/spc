package com.tayo2000.ssm.mapper;
import java.util.List;

import com.tayo2000.ssm.po.RealTimeValue;
import com.tayo2000.ssm.po.RealTimeValueQuery;

public interface RealTimeValueMapper {
	public List<RealTimeValue> list(RealTimeValueQuery rtvQuery)throws Exception;
	public int getTotalRecord(RealTimeValueQuery rtvQuery) throws Exception;
	public List<RealTimeValue> listByPagination(RealTimeValueQuery rtvQuery) throws Exception;
	public List<RealTimeValue> listLastest(String  fNo)throws Exception; 
}
