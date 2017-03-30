package com.tayo2000.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tayo2000.ssm.mapper.QualityFeatureMapper;
import com.tayo2000.ssm.po.Product;
import com.tayo2000.ssm.po.ProductQuery;
import com.tayo2000.ssm.po.QualityFeature;
import com.tayo2000.ssm.service.QualityFeatureService;

public class QualityFeatureServiceImpl implements QualityFeatureService {
	
	@Autowired
	QualityFeatureMapper featureMapper;
	
	@Override
	public int delete(QualityFeature qf) throws Exception {
		// TODO Auto-generated method stub
		return featureMapper.delete(qf);
	}

	@Override
	public int add(QualityFeature qf) throws Exception {
		// TODO Auto-generated method stub
		return featureMapper.add(qf);
	}

	@Override
	public int update(QualityFeature qf) throws Exception {
		// TODO Auto-generated method stub
		return featureMapper.update(qf);
	}

	@Override
	public List<QualityFeature> findByProduct(Product p) throws Exception {
		// TODO Auto-generated method stub
		return featureMapper.findByProduct(p);
	}

	@Override
	public List<QualityFeature> list(ProductQuery pQuery) throws Exception {
		// TODO Auto-generated method stub
		return featureMapper.list(pQuery);
	}

}
