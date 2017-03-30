package com.tayo2000.ssm.po;

public class Factory {
	private String fNo;
	private String fName;
	private String fInfo;
	private String fType;
	
	public String getfType() {
		return fType;
	}
	public void setfType(String fType) {
		this.fType = fType;
	}
	public String getfNo() {
		return fNo;
	}
	public void setfNo(String fNo) {
		this.fNo = fNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfInfo() {
		return fInfo;
	}
	public void setfInfo(String fInfo) {
		this.fInfo = fInfo;
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer("");
		sb.append(fNo+"\t"+fName+"\t"+fType+"\t"+fInfo);
		return sb.toString();
	}
}
