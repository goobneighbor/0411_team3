package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.CustomerCenterDAO;
import com.t09ether.home.dto.CustomerCenterDTO;

@Service
public class CustomerCenterServiceImpl implements CustomerCenterService {
	@Inject
	CustomerCenterDAO dao;

	// 게시판 전체 목록 보기
	@Override
	public List<CustomerCenterDTO> boardList() {
		return dao.boardList();
	}

	

}
