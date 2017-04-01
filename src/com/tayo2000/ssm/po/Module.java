package com.tayo2000.ssm.po;

public class Module {
	private String moduleId;
	private String moduleName;
	private String moduleDesc;
	
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
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
