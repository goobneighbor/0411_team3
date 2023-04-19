package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.OnlineJoinDAO;
import com.t09ether.home.dto.OrderDTO;

@Service
public class OnlineJoinServiceImpl implements OnlineJoinService {
	@Inject
	OnlineJoinDAO dao;

	@Override
	public List<OrderDTO> locationListSelect(int pro_code) {
		return dao.locationListSelect(pro_code);
	}

	@Override
	public List<OrderDTO> getList(String searchWrd) {
		return dao.getList(searchWrd);
	}

	
}
