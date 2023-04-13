package com.t09ether.home.dto;

public class OnlineDTO {
	private int on_no;
	private int pro_code;
	private int on_count;
	private String find_addr;
	private int hit;
	
	@Override
	public String toString() {
		return "OnlineDTO [on_no=" + on_no + ", pro_code=" + pro_code + ", on_count=" + on_count + ", find_addr="
				+ find_addr + ", hit=" + hit + ", wirtedate=" + wirtedate + "]";
	}
	
	private String wirtedate;
	public int getOn_no() {
		return on_no;
	}
	public void setOn_no(int on_no) {
		this.on_no = on_no;
	}
	public int getPro_code() {
		return pro_code;
	}
	public void setPro_code(int pro_code) {
		this.pro_code = pro_code;
	}
	public int getOn_count() {
		return on_count;
	}
	public void setOn_count(int on_count) {
		this.on_count = on_count;
	}
	public String getFind_addr() {
		return find_addr;
	}
	public void setFind_addr(String find_addr) {
		this.find_addr = find_addr;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getWirtedate() {
		return wirtedate;
	}
	public void setWirtedate(String wirtedate) {
		this.wirtedate = wirtedate;
	}
	
}
