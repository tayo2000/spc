package com.tayo2000.ssm.po;

public class RealTimeValueQuery {
	private RealTimeValue rtv;
	private Pager<RealTimeValue> pager;
	public RealTimeValue getRtv() {
		return rtv;
	}
	public void setRtv(RealTimeValue rtv) {
		this.rtv = rtv;
	}
	public Pager<RealTimeValue> getPager() {
		return pager;
	}
	public void setPager(Pager<RealTimeValue> pager) {
		this.pager = pager;
	}
	
}
