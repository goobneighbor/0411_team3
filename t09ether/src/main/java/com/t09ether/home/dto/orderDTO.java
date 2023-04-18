package com.t09ether.home.dto;

public class orderDTO {
	private int ord_no;
	private int pro_code;
	private String userid;
	private int ord_count;
	private String shareaddr;
	private int status;
	
	
	@Override
	public String toString() {
		return "orderDTO [ord_no=" + ord_no + ", pro_code=" + pro_code + ", userid=" + userid + ", ord_count="
				+ ord_count + ", shareaddr=" + shareaddr + ", status=" + status + "]";
	}
	
	public int getOrd_no() {
		return ord_no;
	}
	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}
	public int getPro_code() {
		return pro_code;
	}
	public void setPro_code(int pro_code) {
		this.pro_code = pro_code;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getOrd_count() {
		return ord_count;
	}
	public void setOrd_count(int ord_count) {
		this.ord_count = ord_count;
	}
	public String getShareaddr() {
		return shareaddr;
	}
	public void setShareaddr(String shareaddr) {
		this.shareaddr = shareaddr;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
