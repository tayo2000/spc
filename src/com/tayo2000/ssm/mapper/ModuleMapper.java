package com.tayo2000.ssm.mapper;
import java.util.List;
import com.tayo2000.ssm.po.Module;

public interface ModuleMapper {
	public List<Module> list() throws Exception;
	public Module listById(String moduleId) throws Exception;
	public int delete(String moduleId)throws Exception;
	public int add(Module module) throws Exception;
	public int update(Module module) throws Exception;
}
