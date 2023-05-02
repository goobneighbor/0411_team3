package com.t09ether.home.dto;

public class DataVO {
	private String month;
	private int cnt;
	
	@Override
	public String toString() {
		return "DataVO [month=" + month + ", cnt=" + cnt + "]";
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
