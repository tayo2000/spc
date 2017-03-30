package com.tayo2000.ssm.po;

public class QualityFeatureQuery {
	
	private QualityFeature qf;
	private Pager<QualityFeature> pager;
	
	public QualityFeature getQf() {
		return qf;
	}
	public void setQf(QualityFeature qf) {
		this.qf = qf;
	}
	public Pager<QualityFeature> getPager() {
		return pager;
	}
	public void setPager(Pager<QualityFeature> pager) {
		this.pager = pager;
	}
	
	
}
