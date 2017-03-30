package com.tayo2000.ssm.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tayo2000.ssm.po.Product;
import com.tayo2000.ssm.po.ProductQuery;
import com.tayo2000.ssm.po.QualityFeature;
import com.tayo2000.ssm.service.QualityFeatureService;

@Controller
public class FeatureController {
	
	@Autowired
	private QualityFeatureService featureService;
	
	@RequestMapping("/featureList2")
	public ModelAndView featureList2(String fNo,String pNo) throws Exception{
		Product p=new Product();
		p.setfNo(fNo);
		p.setpNo(pNo);
		List<QualityFeature> qList=featureService.findByProduct(p);
		
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("feature/featureList");
		modelAndView.addObject("fNo", fNo);
		modelAndView.addObject("pNo", pNo);
		modelAndView.addObject("qList", qList);
		return modelAndView;
	}
	
	@RequestMapping("/featureList")
	@ResponseBody
	public List<QualityFeature> featureList(String fNo,String pNo,HttpServletRequest request) throws Exception{
		ProductQuery pQuery=new ProductQuery();
		Product p=new Product();
		p.setfNo(fNo);
		p.setpNo(pNo);
		pQuery.setProduct(p);
		List<QualityFeature> qfList=featureService.list(pQuery);
		return qfList;
	}
	
	@RequestMapping("/featureDelete")
	public String featureDelete(QualityFeature qf) throws Exception{
		featureService.delete(qf);
		return "feature/featureList";
	}
	
	
	@RequestMapping("/featureAdd")
	public String featureAdd(QualityFeature qf) throws Exception{
		featureService.add(qf);
		return "feature/featureList";
	}
	
	
	@RequestMapping("/featureUpdate")
	public String featureUpdate(QualityFeature qf) throws Exception{
		featureService.update(qf);
		return "feature/featureList";
	}
	
}
