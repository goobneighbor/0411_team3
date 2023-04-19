package com.t09ether.home.dto;

public class OrderDTO {
	private int ord_no;
	private int pro_code;
	private String userid;
	private int ord_count; //내가주문한상품수
	private String shareaddr;
	private int status;
	
//////////////////////////////////	
	private int on_count;//상품총주문개수
	private int rest_count; //남은상품개수
	
	public int getOn_count() {
		return on_count;
	}

	public void setOn_count(int on_count) {
		this.on_count = on_count;
		
		//남은상품개수구하기(공구시작하기)
		rest_count= on_count - ord_count;
	}

	public int getRest_count() {
		return rest_count;
		
	
	}

	public void setRest_count(int rest_count) {
		this.rest_count = rest_count;
		
		//남은상품개수구하기(참여하기)
		rest_count -= ord_count;
	}

	
	/////////////////////////////////
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
