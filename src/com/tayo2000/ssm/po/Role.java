package com.tayo2000.ssm.po;

public class Role {
	private String roleId;
	private String roleName;
	private String roleDesc;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
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
