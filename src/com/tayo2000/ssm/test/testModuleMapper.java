package com.tayo2000.ssm.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tayo2000.ssm.po.Module;
import com.tayo2000.ssm.service.ModuleService;

public class testModuleMapper {
	private ApplicationContext ctx;
	private ModuleService service;
	@Before
	public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext(new String[]{"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-transaction.xml"});
		service=(ModuleService)ctx.getBean("moduleService");
	}

	@After
	public void tearDown() throws Exception {
		((AbstractApplicationContext) ctx).close();
	}
	
	@Test
	public void testList() throws Exception {
		List<Module> list=service.list();
		for(Module m : list){
			System.out.println(m);
		}
	}
	
	@Test
	public void testDelete() throws Exception{
		String moduleId="user";
		Module m=service.listById(moduleId);
		if(m!=null) service.delete(m.getModuleId());
	
	}
	@Test
	public void testUpdate() throws Exception{
		Module module=new Module();
		module.setModuleName("user");
		module.setModuleDesc("用户模块");
		service.update(module);
		List<Module> list=service.list();
		for(Module m : list){
			System.out.println(m);
		}
	}
	@Test
	public void testAdd() throws Exception{
		Module module=new Module();
		module.setModuleName("user");
		module.setModuleDesc("用户模块");
		service.add(module);
		List<Module> list=service.list();
		for(Module m : list){
			System.out.println(m);
		}
	}
}
