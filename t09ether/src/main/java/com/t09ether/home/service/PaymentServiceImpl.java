package com.t09ether.home.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.PaymentDAO;
import com.t09ether.home.dto.PaymentDTO;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Inject
	PaymentDAO dao;
	
	@Override
	public int payInsert(String imp_uid, int final_amount, int discount_amount, int ord_no, int total_amount) {
		return dao.payInsert(imp_uid, final_amount, discount_amount, ord_no, total_amount);
	}

}
