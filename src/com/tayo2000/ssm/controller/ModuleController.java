package com.tayo2000.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tayo2000.ssm.po.Module;
import com.tayo2000.ssm.service.ModuleService;

@Controller
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("/moduleList")
	@ResponseBody
	public List<Module> moduleList() throws Exception{
		List<Module> list=moduleService.list();
		return list;
	}
	
	
	@RequestMapping("/moduleDelete")
	public String moduleDelete(String  moduleId) throws Exception{
		moduleService.delete(moduleId);
		return "module/moduleList";
	}
	
	
	@RequestMapping("/moduleAdd")
	public String moduleAdd(Module module) throws Exception{
		moduleService.add(module);
		return "module/moduleList";
	}
	
	
	@RequestMapping("/moduleUpdate")
	public String moduleUpdate(Module module) throws Exception{
		moduleService.update(module);
		return "module/moduleList";
	}
}
