package com.tayo2000.ssm.test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tayo2000.ssm.po.User;
import com.tayo2000.ssm.service.UserService;
import com.tayo2000.ssm.utils.Tool;
public class testUserMapper {
	private ApplicationContext ctx;
	private UserService service;
	
	@Before
	public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext(new String[]{"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-transaction.xml"});
		service=(UserService)ctx.getBean("userService");
	}
	
	@After
	public void tearDown() throws Exception {
		((AbstractApplicationContext) ctx).close();
	}
	
	@Test
	public void testLogin() throws Exception{
		String username="tayo2000";
		String password=Tool.md5("123456");
		User user=service.find(username);
		if(user==null){
			System.out.println("对不起，该用户不存在！");
			return;
		} 
		if(!password.equals(user.getPassword())){
			System.out.println("对不起，您输入的密码不正确！");
			System.out.println(password);
			System.out.println(user.getPassword());
			return;
		}
		user.setLoginCount(user.getLoginCount()+1);
		user.setLoginState(1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setLoginTime(sdf.format(new Date()));
		service.updateState(user);
		System.out.println(user);
	}
	
	@Test
	public void testUpdatePassword() throws Exception{
		String username="tayo2000";
		String password="123456";
		service.updatePassword(username, password);
	}
	
	@Test
	public void testAdd() throws Exception{
		User user=new User();
		user.setUsername("tayo2010");
		MessageDigest md5=MessageDigest.getInstance("MD5");
		md5.update("123456".getBytes());
		user.setPassword(new BigInteger(1,md5.digest()).toString(16));
		user.setRole("admin");
		user.setEmail("tayo2000@163.com");
		service.add(user);
	}
	
	@Test
	public void testUpdate() throws Exception{
		
	}
	
	@Test
	public void testListAll() throws Exception{
		List<User> list=service.listAll();
		for(User user :list){
			System.out.println(user);
		}
	}
	
	@Test
	public void testIsExist() throws Exception{
		String username="tayo2010";
		boolean x=service.isExist(username);
		System.out.println(x);
	}
	
	@Test
	public void testDelete() throws Exception{
		String username="tayo2010";
		service.delete(username);
	}
}
