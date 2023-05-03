package com.t09ether.home.dto;

public class DataVO {
	private String month;
	private int cnt;
	private int pro_code;
	
	@Override
	public String toString() {
		return "DataVO [month=" + month + ", cnt=" + cnt + ", pro_code=" + pro_code + "]";
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
	public int getPro_code() {
		return pro_code;
	}
	public void setPro_code(int pro_code) {
		this.pro_code = pro_code;
	}
}
