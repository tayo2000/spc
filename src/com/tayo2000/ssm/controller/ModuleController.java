package com.tayo2000.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	
	@RequestMapping("/moduleList2")
	@ResponseBody
	public List<HashMap<String,String>> moduleList2() throws Exception{
		List<Module> list=moduleService.list();
		List<HashMap<String,String>> list2=new ArrayList<HashMap<String,String>>();
		for(Module m: list){
			HashMap<String, String> hm=new HashMap<String, String>();
			hm.put("moduleId", m.getModuleId());
			hm.put("moduleName",m.getModuleName());
			hm.put("ckbAdd", m.getModuleId()+"Add");
			hm.put("ckbDelete",  m.getModuleId()+"Delete");
			hm.put("ckbUpdate",  m.getModuleId()+"Update");
			hm.put("ckbList", m.getModuleId()+"List");
			list2.add(hm);
		}
		return list2;
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
