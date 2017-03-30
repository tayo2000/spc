package com.tayo2000.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tayo2000.ssm.po.Pager;
import com.tayo2000.ssm.po.Product;
import com.tayo2000.ssm.po.ProductQuery;
import com.tayo2000.ssm.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/productList")
	@ResponseBody
	public Map<String, Object> productList(String fNo,HttpServletRequest request) throws Exception{
		int pageIndex=Integer.parseInt(request.getParameter("page")==null?"1":request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("rows")==null?"10":request.getParameter("rows"));
		
		Product p=new Product();
		p.setfNo(fNo);
		ProductQuery pQuery=new ProductQuery();
		pQuery.setProduct(p);
		int totalCount=productService.getTotalRecord(pQuery);
		
		Pager<Product> pager=new Pager<Product>();
		pager.setStartPos((pageIndex-1)*pageSize);
		pager.setPageSize(pageSize);
		pager.setTotalCount(totalCount);
		
		pQuery.setPager(pager);
		List<Product> productList=productService.listByPagination(pQuery);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", totalCount);
		jsonMap.put("rows", productList);
		return jsonMap;
	}
	
	@RequestMapping("/productListForCombo")
	@ResponseBody
	public List<Product> productListForCombo(String fNo) throws Exception{
		List<Product>  list= productService.findByFno(fNo);
		return list;
	}

	@RequestMapping("/productDelete")
	public String productDelete(String pNo,String fNo) throws Exception{
		Product p=new Product();
		p.setpNo(pNo);
		p.setfNo(fNo);
		productService.delete(p);
		return "product/productList";
	}
	
	@RequestMapping("/productAdd")
	public String productAdd(Product product) throws Exception{
		productService.add(product);
		return "product/productList";
	}
	
	@RequestMapping("/productEdit")
	public ModelAndView productEdit(String pNo,String fNo)throws Exception{
		ProductQuery pQuery=new ProductQuery();
		Product p=new Product();
		p.setpNo(pNo);
		p.setfNo(fNo);
		pQuery.setProduct(p);
		Product product=productService.findByCondition(pQuery).get(0);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("product",product);
		modelAndView.setViewName("product/productEdit");
		return modelAndView;
	}
	
	@RequestMapping("/productUpdate")
	public String productUpdate(Product product) throws Exception{
		productService.update(product);
		return "product/productList";
	}
	
}
