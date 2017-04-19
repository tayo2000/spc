package com.tayo2000.ssm.po;

public class UserRole {
	private int userroleId;
	private String userName;
	private int roleId;
	public int getUserroleId() {
		return userroleId;
	}
	public void setUserroleId(int userroleId) {
		this.userroleId = userroleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName =userName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String toString(){
		StringBuffer sb=new StringBuffer("");
		sb.append(userroleId+"\t"+userName+"\t"+roleId);
		return sb.toString();
	}
}
