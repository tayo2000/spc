package com.tayo2000.ssm.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tayo2000.ssm.mapper.FactoryMapper;
import com.tayo2000.ssm.po.Factory;
public class testFactoryMapper {
	private ApplicationContext ctx;
	private FactoryMapper mapper;
	
	@Before
	public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		mapper=(FactoryMapper)ctx.getBean("factoryMapper");
	}
	
	@After
	public void tearDown() throws Exception {
		((AbstractApplicationContext) ctx).close();
	}
	
	@Test
	public void testAdd() throws Exception{
		Factory f=new Factory();
		f.setfNo("A0001");
		f.setfName("AAAA");
		f.setfType("一级供应商");
		f.setfInfo("测试测试");
		mapper.add(f);
	}
	
	@Test
	public void testList() throws Exception{
		List<Factory> list=mapper.listAll();
		for(Factory f:list){
			System.out.println(f);
		}
	}
	
	
}
