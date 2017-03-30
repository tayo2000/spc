package com.tayo2000.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tayo2000.ssm.po.Pager;
import com.tayo2000.ssm.po.RealTimeValue;
import com.tayo2000.ssm.po.RealTimeValueQuery;
import com.tayo2000.ssm.service.RealTimeValueService;

@Controller
public class RealTimeValueController {
	@Autowired
	private RealTimeValueService rtvService;
	
	@RequestMapping("/rtvList")
	@ResponseBody
	public Map<String, Object> rtvList(HttpServletRequest request,RealTimeValue rtv) throws Exception{
//		RealTimeValue rtv=new RealTimeValue();
//		rtv.setpNo(pNo);
//		rtv.setQfNo(qfNo);
		
		RealTimeValueQuery rtvQuery=new RealTimeValueQuery();
		rtvQuery.setRtv(rtv);
		int totalCount=rtvService.getTotalRecord(rtvQuery);
				
		Pager<RealTimeValue> pager=new Pager<RealTimeValue>();
		int pageIndex=Integer.parseInt(request.getParameter("page")==null?"1":request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("rows")==null?"10":request.getParameter("rows"));
		pager.setStartPos((pageIndex-1)*pageSize);
		pager.setPageSize(pageSize);
		pager.setTotalCount(totalCount);
		
		rtvQuery.setPager(pager);
		List<RealTimeValue> rtvList=rtvService.listByPagination(rtvQuery);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", totalCount);
		jsonMap.put("rows", rtvList);
		return jsonMap;
	}
	
	@RequestMapping("/rtvListLastest")
	@ResponseBody
	public List<RealTimeValue> rtvListLastest(HttpServletRequest request,String fNo) throws Exception{
		List<RealTimeValue> rtvList=rtvService.listLastest(fNo);
		return rtvList;
	}
	
	@RequestMapping("/rtvCharts")
	@ResponseBody
	public ArrayList<Float> rtvCharts(HttpServletRequest request,String startPos,String pNo,String qfNo)throws Exception {
		RealTimeValue rtv=new RealTimeValue();
		rtv.setpNo(pNo);
		rtv.setQfNo(qfNo);
		int pageSize=100;
		int pageIndex=Integer.parseInt(startPos);
		Pager<RealTimeValue> pager=new Pager<RealTimeValue>();
		pager.setStartPos((pageIndex-1)*pageSize);
		pager.setPageSize(pageSize);
		
		RealTimeValueQuery rtvQuery=new RealTimeValueQuery();
		rtvQuery.setRtv(rtv);
		rtvQuery.setPager(pager);
		List<RealTimeValue> rtvList=rtvService.listByPagination(rtvQuery);
		ArrayList<Float> xList=new ArrayList<Float>();
		for(RealTimeValue x : rtvList)
			xList.add(x.getRealValue());
//		Map<String, Object> jsonMap = new HashMap<String, Object>();
//		jsonMap.put("data", xList);
		return xList;
	}
}
