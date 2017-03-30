package com.tayo2000.ssm.po;

public class Role {
	private int roleId;
	private String roleName;
	private String roleDesc;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String toString(){
		StringBuffer sb=new StringBuffer("");
		sb.append(roleId+"\t"+roleName+"\t"+roleDesc);
		return sb.toString();
	}
	
}
