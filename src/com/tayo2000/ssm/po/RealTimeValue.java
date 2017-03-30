package com.tayo2000.ssm.po;

public class RealTimeValue {
	private String fNo;
	private String pNo;
	private String qfNo;
	private String pName;
	private String qfName;
	private String realTime;
	private float realValue;
	private float usl;
	private float sl;
	private float lsl;
	private String checkInfo;
	
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getQfNo() {
		return qfNo;
	}
	public void setQfNo(String qfNo) {
		this.qfNo = qfNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getQfName() {
		return qfName;
	}
	public void setQfName(String qfName) {
		this.qfName = qfName;
	}
	public String getRealTime() {
		return realTime;
	}
	public void setRealTime(String realTime) {
		this.realTime = realTime;
	}
	public float getRealValue() {
		return realValue;
	}
	public void setRealValue(float realValue) {
		this.realValue = realValue;
	}
	public float getUsl() {
		return usl;
	}
	public void setUsl(float usl) {
		this.usl = usl;
	}
	public float getSl() {
		return sl;
	}
	public void setSl(float sl) {
		this.sl = sl;
	}
	public float getLsl() {
		return lsl;
	}
	public void setLsl(float lsl) {
		this.lsl = lsl;
	}
	
	public String getfNo() {
		return fNo;
	}
	public void setfNo(String fNo) {
		this.fNo = fNo;
	}
	public String getCheckInfo() {
		return checkInfo;
	}
	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}
	public String toString(){
		return this.pNo+"\t"+this.qfNo+"\t"+this.realValue+"\t"+this.usl+"\t"+this.sl+"\t"+this.lsl;
	}
	
}
