package com.tayo2000.ssm.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tayo2000.ssm.mapper.QualityFeatureMapper;
public class testQualityFeatureMapper {
	private ApplicationContext ctx;
	private QualityFeatureMapper mapper;
	
	@Before
	public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		mapper=(QualityFeatureMapper)ctx.getBean("qualityFeatureMapper");
	}
	
	@After
	public void tearDown() throws Exception {
		((AbstractApplicationContext) ctx).close();
	}
	
	@Test
	public void testAdd() throws Exception{
	}
	
	
}
