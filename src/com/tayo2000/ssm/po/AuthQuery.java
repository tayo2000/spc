package com.tayo2000.ssm.po;

public class AuthQuery {
	private Auth auth;
	private Pager<Auth> pager;
	
	public Auth getAuth() {
		return auth;
	}
	public void setAuth(Auth auth) {
		this.auth = auth;
	}
	public Pager<Auth> getPager() {
		return pager;
	}
	public void setPager(Pager<Auth> pager) {
		this.pager = pager;
	}
	
}
