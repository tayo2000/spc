package com.tayo2000.ssm.po;

public class UserRole {
	int userroleId;
	int userId;
	int roleId;
	public int getUserroleId() {
		return userroleId;
	}
	public void setUserroleId(int userroleId) {
		this.userroleId = userroleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String toString(){
		StringBuffer sb=new StringBuffer("");
		sb.append(userroleId+"\t"+userId+"\t"+roleId);
		return sb.toString();
	}
}
