package com.tayo2000.ssm.po;

public class AuthRole {
	private int authRoleId;
	private String authId;
	private String roleId;
	
	public int getAuthRoleId() {
		return authRoleId;
	}
	public void setAuthRoleId(int roleAuthId) {
		this.authRoleId = roleAuthId;
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer("");
		sb.append(authRoleId+"\t"+authId+"\t"+roleId);
		return sb.toString();
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
