package com.tayo2000.ssm.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tayo2000.ssm.po.UserRole;
import com.tayo2000.ssm.service.UserRoleService;

public class testUserRoleMapper {

	private ApplicationContext ctx;
	private UserRoleService service;
	
	@Before
	public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext(new String[]{"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-transaction.xml"});
		service=(UserRoleService)ctx.getBean("userRoleService");
	}
	
	@After
	public void tearDown() throws Exception {
		((AbstractApplicationContext) ctx).close();
	}

	@Test
	public void testAdd() {
		
	}
	
	
	@Test
	public void testDelete() {
	
	}
	
	@Test
	public void testList() throws Exception {
		List<UserRole> urList=service.list();
		for(UserRole ur : urList){
			System.out.println(ur);
		}
	}
}
