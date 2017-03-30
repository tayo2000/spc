package com.tayo2000.ssm.service;

import java.util.List;

import com.tayo2000.ssm.po.Product;
import com.tayo2000.ssm.po.ProductQuery;
import com.tayo2000.ssm.po.QualityFeature;

public interface QualityFeatureService {
	public List<QualityFeature> findByProduct(Product p) throws Exception;
	public List<QualityFeature> list(ProductQuery pQuery) throws Exception;
	public int delete(QualityFeature qf) throws Exception;
	public int add(QualityFeature qf) throws Exception;
	public int update(QualityFeature qf) throws Exception;
}
