package com.t09ether.home.dao;

import org.apache.ibatis.annotations.Param;

import com.t09ether.home.dto.PaymentDTO;
import com.t09ether.home.dto.RefundDTO;

public interface PaymentDAO {
	public int payInsert(@Param("imp_uid")String imp_uid, @Param("merchant_uid") String merchant_uid, @Param("final_amount")int final_amount, @Param("discount_amount") int discount_amount, @Param("ord_no") int ord_no, @Param("total_amount") int total_amount);
	public PaymentDTO paymentSelect(int ord_no);
	public int redundInsert(RefundDTO dto);
}
