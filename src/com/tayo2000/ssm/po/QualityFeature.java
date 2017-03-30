package com.tayo2000.ssm.po;

public class QualityFeature {
	private String qfNo;
	private String qfName;
	
	private String fNo;
	private String pNo;
	private float usl; //上限
	private float lsl; //下限
	private float sl;  //均值
	
	private String unit; //特性的计量单位

	
	public String getfNo() {
		return fNo;
	}

	public void setfNo(String fNo) {
		this.fNo = fNo;
	}

	public String getQfNo() {
		return qfNo;
	}

	public void setQfNo(String qfNo) {
		this.qfNo = qfNo;
	}

	public String getQfName() {
		return qfName;
	}

	public void setQfName(String qfName) {
		this.qfName = qfName;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}


	public float getUsl() {
		return usl;
	}

	public void setUsl(float usl) {
		this.usl = usl;
	}

	public float getLsl() {
		return lsl;
	}

	public void setLsl(float lsl) {
		this.lsl = lsl;
	}

	public float getSl() {
		return sl;
	}

	public void setSl(float sl) {
		this.sl = sl;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer("");
		sb.append(pNo+"\t"+qfNo+"\t"+qfName+"\t"+usl+"\t"+lsl+"\t"+sl+"\t"+unit);
		return sb.toString();
	}
}
