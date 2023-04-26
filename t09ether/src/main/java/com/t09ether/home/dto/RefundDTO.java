package com.t09ether.home.dto;

public class RefundDTO {
	private int refund_no;
	private int ord_no;
	private int refund_amount;
	private int refund_count;
	private int refund_date;
	
	@Override
	public String toString() {
		return "RefundDTO [refund_no=" + refund_no + ", ord_no=" + ord_no + ", refund_amount=" + refund_amount
				+ ", refund_count=" + refund_count + ", refund_date=" + refund_date + "]";
	}
	
	public int getRefund_no() {
		return refund_no;
	}
	public void setRefund_no(int refund_no) {
		this.refund_no = refund_no;
	}
	public int getOrd_no() {
		return ord_no;
	}
	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}
	public int getRefund_amount() {
		return refund_amount;
	}
	public void setRefund_amount(int refund_amount) {
		this.refund_amount = refund_amount;
	}
	public int getRefund_count() {
		return refund_count;
	}
	public void setRefund_count(int refund_count) {
		this.refund_count = refund_count;
	}
	public int getRefund_date() {
		return refund_date;
	}
	public void setRefund_date(int refund_date) {
		this.refund_date = refund_date;
	}
	
	
	
}
