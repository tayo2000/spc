package com.tayo2000.ssm.po;
/**
 * 权限对象
 * @author Administrator
 */
public class Auth {
	private String authId;
	private String authName;
	private String authDesc;
	private String url;
	private String moduleId;
	
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public String getAuthDesc() {
		return authDesc;
	}
	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String toString(){
		StringBuffer sb=new StringBuffer("");
		sb.append(authId+"\t"+authName+"\t"+authDesc+"\t"+url+"\t"+moduleId);
		return sb.toString();
	}
}
