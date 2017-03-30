package com.tayo2000.ssm.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tayo2000.ssm.mapper.RealTimeValueMapper;
import com.tayo2000.ssm.po.Pager;
import com.tayo2000.ssm.po.RealTimeValue;
import com.tayo2000.ssm.po.RealTimeValueQuery;

public class testRealTimeValueMapper {

	ApplicationContext ctx;
	RealTimeValueMapper mapper;
	
	@Before
	public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		mapper=(RealTimeValueMapper)ctx.getBean("realTimeValueMapper");
	}

	@After
	public void tearDown() throws Exception {
		((AbstractApplicationContext) ctx).close();
	}

	@Test
	public void testList() throws Exception{
		RealTimeValue rtv=new RealTimeValue();
		rtv.setpNo("f1310304");
		rtv.setQfNo("qf0004");
		
		RealTimeValueQuery rtvQuery=new RealTimeValueQuery();
		rtvQuery.setRtv(rtv);
		
		List<RealTimeValue> rtvList=mapper.list(rtvQuery);
		for(RealTimeValue rtv1:rtvList)
			System.out.println(rtv1);
	}
	
	@Test
	public void testListLastest() throws Exception{
		List<RealTimeValue> rtvList=mapper.listLastest("A0001");
		for(RealTimeValue rtv:rtvList)
			System.out.println(rtv);
	}
	
	@Test
	public void testGetTotalCount() throws Exception{
		RealTimeValue rtv=new RealTimeValue();
		rtv.setpNo("f1310304");
		rtv.setQfNo("qf0004");
		
		RealTimeValueQuery rtvQuery=new RealTimeValueQuery();
		rtvQuery.setRtv(rtv);
		
		int num=mapper.getTotalRecord(rtvQuery);
		System.out.println(num);
	}
	
	@Test
	public void testListByPagination()throws Exception{
		int pageIndex =4;
		int pageSize=20;
		
		Pager<RealTimeValue> pager=new Pager<RealTimeValue>();
		pager.setPageSize(pageSize);
		pager.setStartPos((pageIndex-1)*pageSize);
		
		RealTimeValue rtv=new RealTimeValue();
		rtv.setpNo("f1310304");
		rtv.setQfNo("qf0004");
		
		RealTimeValueQuery rtvQuery=new RealTimeValueQuery();
		rtvQuery.setRtv(rtv);
		rtvQuery.setPager(pager);
		
		List<RealTimeValue> rtvList=mapper.listByPagination(rtvQuery);
		for(RealTimeValue rtv1:rtvList)
			System.out.println(rtv1);
	}
}
