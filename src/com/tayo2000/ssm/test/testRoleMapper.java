package com.tayo2000.ssm.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tayo2000.ssm.po.Role;
import com.tayo2000.ssm.service.RoleService;

public class testRoleMapper {
	private ApplicationContext ctx;
	private RoleService service;
	@Before
	public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext(new String[]{"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-transaction.xml"});
		service=(RoleService)ctx.getBean("roleService");
	}

	@After
	public void tearDown() throws Exception {
		((AbstractApplicationContext) ctx).close();
	}
	
	@Test
	public void testList() throws Exception {
		List<Role> list=service.list();
		for(Role r : list){
			System.out.println(r);
		}
	}
	@Test
	public void testDelete() throws Exception{
		service.delete("user");
		List<Role> list=service.list();
		for(Role r : list){
			System.out.println(r);
		}
	}
	@Test
	public void testUpdate() throws Exception{
		Role role=new Role();
		role.setRoleName("user");
		role.setRoleDesc("用户模块");
		service.update(role);
		List<Role> list=service.list();
		for(Role r : list){
			System.out.println(r);
		}
	}
	@Test
	public void testAdd() throws Exception{
		Role role=new Role();
		role.setRoleName("user");
		role.setRoleDesc("用户模块");
		service.add(role);
		List<Role> list=service.list();
		for(Role r : list){
			System.out.println(r);
		}
	}
}
