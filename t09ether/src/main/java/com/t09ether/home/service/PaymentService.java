package com.t09ether.home.service;

import org.apache.ibatis.annotations.Param;

import com.t09ether.home.dto.PaymentDTO;
import com.t09ether.home.dto.RefundDTO;

public interface PaymentService {
	public int payInsert(String imp_uid, String merchant_uid, int final_amount, int discount_amount,  int ord_no, int total_amount);
	public PaymentDTO paymentSelect(int ord_no);
	public int refundInsert(int ord_no, int amount, int total_amount);
	public int payDelete(String pay_no);
	public int ordUpdate(int ord_no, int on_no);
	public int prodetailUpdate(int on_no);
}
