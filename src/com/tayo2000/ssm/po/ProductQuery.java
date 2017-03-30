package com.tayo2000.ssm.po;

public class ProductQuery {
	private Product product;
	private Pager<Product> pager;
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Pager<Product> getPager() {
		return pager;
	}

	public void setPager(Pager<Product> pager) {
		this.pager = pager;
	}
	
	
	
}
