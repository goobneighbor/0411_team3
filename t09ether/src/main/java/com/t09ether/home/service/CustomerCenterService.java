package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.CustomerCenterDTO;

public interface CustomerCenterService {
	// 고객센터 글목록
	public List<CustomerCenterDTO> boardList();
	// 고객센터 글 상세조회
	public CustomerCenterDTO boardView(int cus_b_num);

}
