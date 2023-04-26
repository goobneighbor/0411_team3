package com.t09ether.home.service;

import com.t09ether.home.dto.PaymentDTO;
import com.t09ether.home.dto.RefundDTO;

public interface PaymentService {
	public int payInsert(String imp_uid, String merchant_uid, int final_amount, int discount_amount,  int ord_no, int total_amount);
	public PaymentDTO paymentSelect(int ord_no);
	public int redundInsert(RefundDTO dto);
}
