package com.tayo2000.ssm.po;

public class Module {
	private int moduleId;
	private String moduleName;
	private String moduleDesc;
	
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleDesc() {
		return moduleDesc;
	}
	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}
	public String toString(){
		StringBuffer sb=new StringBuffer("");
		sb.append(moduleId+"\t"+moduleName+"\t"+moduleDesc);
		return sb.toString();
	}
}
