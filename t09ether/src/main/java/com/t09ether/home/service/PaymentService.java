package com.t09ether.home.service;


public interface PaymentService {
	public int payInsert(String imp_uid, int final_amount, int discount_amount,  int ord_no, int total_amount);
}
