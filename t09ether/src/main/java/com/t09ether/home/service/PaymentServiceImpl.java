package com.t09ether.home.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.PaymentDAO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.PaymentDTO;
import com.t09ether.home.dto.RefundDTO;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Inject
	PaymentDAO dao;
	
	@Override
	public int payInsert(String imp_uid, String merchant_uid,int final_amount, int discount_amount, int ord_no, int total_amount) {
		return dao.payInsert(imp_uid, merchant_uid, final_amount, discount_amount, ord_no, total_amount);
	}

	@Override
	public PaymentDTO paymentSelect(int ord_no) {
		return dao.paymentSelect(ord_no);
	}

	@Override
	public int refundInsert(int ord_no, int amount, int total_amount) {
		return dao.refundInsert(ord_no, amount, total_amount);
	}

	@Override
	public int payDelete(String pay_no) {
		return dao.payDelete(pay_no);
	}

	@Override
	public int ordUpdate(int ord_no, int on_no) {
		return dao.ordUpdate(ord_no, on_no);
	}

	@Override
	public int prodetailUpdate(int on_no) {
		return dao.prodetailUpdate(on_no);
	}

	@Override
	public String leaderSelect(int on_on) {
		return dao.leaderSelect(on_on);
	}

	@Override
	public String selfSelect(int ord_on) {
		return dao.selfSelect(ord_on);
	}

	@Override
	public int ordUpdateJoin(int ord_no) {
		
		return dao.ordUpdateJoin(ord_no);
	}

	@Override
	public List<OrderDTO> selectInfor(int on_on) {
		return dao.selectInfor(on_on);
	}

	@Override
	public ArrayList<Integer> ordNoSelect(int on_no) {
		return dao.ordNoSelect(on_no);
	}

	@Override
	public String payNoSelect(int ord_no) {
		return dao.payNoSelect(ord_no);
	}

	@Override
	public int restCountSelect(int on_no) {
		return dao.restCountSelect(on_no);
	}

	@Override
	public int restCountUpdate(int newRest, int on_no) {
		return dao.restCountUpdate(newRest, on_no);
	}


}
