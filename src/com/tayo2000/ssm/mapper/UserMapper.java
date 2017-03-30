package com.tayo2000.ssm.mapper;
import java.util.List;
import com.tayo2000.ssm.po.User;

public interface UserMapper {
	public List<User> listAll() throws Exception;
	public User find(String username) throws Exception;
	public int delete(String username)throws Exception;
	public int add(User user) throws Exception;
	public int updateInfo(User user) throws Exception;
	public int updateState(User user) throws Exception;
	public int updatePassword(User user) throws Exception;
	
}
