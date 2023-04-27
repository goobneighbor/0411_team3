package com.t09ether.home.dto;

public class OffPartDTO {
	private int off_j_no;
	private int off_no;
	private String userid;
	private String username;
	private String tel;
	public int getOff_j_no() {
		return off_j_no;
	}
	public void setOff_j_no(int off_j_no) {
		this.off_j_no = off_j_no;
	}
	public int getOff_no() {
		return off_no;
	}
	public void setOff_no(int off_no) {
		this.off_no = off_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "OffPartDTO [off_j_no=" + off_j_no + ", off_no=" + off_no + ", userid=" + userid + ", username="
				+ username + ", tel=" + tel + "]";
	}
	
	
}
