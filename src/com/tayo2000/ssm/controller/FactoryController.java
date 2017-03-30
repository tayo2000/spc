package com.tayo2000.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tayo2000.ssm.po.Factory;
import com.tayo2000.ssm.service.FactoryService;

@Controller
public class FactoryController {
	
	@Autowired
	private FactoryService factoryService;
	
	@RequestMapping("/factoryList")
	@ResponseBody
	public List<Factory> factoryList(HttpServletRequest request) throws Exception{
		List<Factory> list=factoryService.listAll();
		return list;
	}
	
	@RequestMapping("/factoryDelete")
	public String factoryDelete(String  fNo) throws Exception{
		factoryService.delete(fNo);
		return "factory/factoryList";
	}
	
	
	@RequestMapping("/factoryAdd")
	public String factoryAdd(Factory f) throws Exception{
		factoryService.add(f);
		return "factory/factoryList";
	}
	
	
	@RequestMapping("/factoryUpdate")
	public String factoryUpdate(Factory f) throws Exception{
		factoryService.update(f);
		return "factory/factoryList";
	}
	
}
