package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayo2000.ssm.mapper.UserMapper;
import com.tayo2000.ssm.po.User;
import com.tayo2000.ssm.service.UserService;
import com.tayo2000.ssm.utils.Tool;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public List<User> listAll() throws Exception {
		// TODO Auto-generated method stub
		return mapper.listAll();
	}

	@Override
	public User find(String username) throws Exception {
		// TODO Auto-generated method stub
		return mapper.find(username);
	}

	@Override
	public boolean isExist(String username) throws Exception {
		// TODO Auto-generated method stub
		return mapper.find(username)==null ? false: true;
	}

	@Override
	public int delete(String username) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(username);
	}

	@Override
	public int add(User user) throws Exception {
		user.setPassword(Tool.md5(user.getPassword()));
		return mapper.add(user);
	}

	@Override
	public int updateInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		return mapper.updateInfo(user);
	}
	
	@Override
	public int updateState(User user) throws Exception {
		// TODO Auto-generated method stub
		return mapper.updateState(user);
	}

	@Override
	public int updatePassword(String username, String newPassword) throws Exception {
		User user=mapper.find(username);
		if(user==null || "".equals(newPassword)) return 0;
		user.setPassword(Tool.md5(newPassword));
		return mapper.updatePassword(user);
	}
}
