package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tayo2000.ssm.mapper.ProductMapper;
import com.tayo2000.ssm.po.Product;
import com.tayo2000.ssm.po.ProductQuery;
import com.tayo2000.ssm.service.ProductService;

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper pMapper;
	
	@Override
	public List<Product> findByCondition(ProductQuery productQuery) throws Exception {
		// TODO Auto-generated method stub
		return pMapper.findByCondition(productQuery);
	}

	@Override
	public int deleteByCondition(ProductQuery productQuery) throws Exception {
		// TODO Auto-generated method stub
		return pMapper.deleteByCondition(productQuery);
	}

	@Override
	public int add(Product product) throws Exception {
		// TODO Auto-generated method stub
		return pMapper.add(product);
	}

	@Override
	public int update(Product product) throws Exception {
		// TODO Auto-generated method stub
		return pMapper.update(product);
	}


	@Override
	public List<Product> listByPagination(ProductQuery productQuery) throws Exception {
		// TODO Auto-generated method stub
		return pMapper.listByPagination(productQuery);
	}

	@Override
	public List<Product> findByFno(String fNo) throws Exception {
		// TODO Auto-generated method stub
		return pMapper.findByFno(fNo);
	}

	@Override
	public int delete(Product product) throws Exception {
		return pMapper.delete(product);
	}

	@Override
	public int getTotalRecord(ProductQuery productQuery) throws Exception {
		// TODO Auto-generated method stub
		return pMapper.getTotalRecord(productQuery);
	}

}
