package com.t09ether.home.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.OrderDAO;
import com.t09ether.home.dto.orderDTO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Inject
	OrderDAO dao;
	
	@Override
	public int orderInsert(orderDTO dto) {
		return dao.orderInsert(dto);
	}

}
