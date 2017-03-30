package com.tayo2000.ssm.service;

import java.util.List;

import com.tayo2000.ssm.po.Product;
import com.tayo2000.ssm.po.ProductQuery;

public interface ProductService {
	
	public List<Product> findByFno(String fNo) throws Exception;

	public List<Product> findByCondition(ProductQuery productQuery)throws Exception;
	
	public int delete(Product product) throws Exception;
	public int deleteByCondition(ProductQuery productQuery)throws Exception;
	public int add(Product product) throws Exception;
	public int update(Product product) throws Exception;
	
	public int getTotalRecord(ProductQuery productQuery) throws Exception;
	public List<Product> listByPagination(ProductQuery productQuery) throws Exception;
}
