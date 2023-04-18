package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.dto.RegisterDTO;

public interface CustomerCenterDAO {
	// 고객센터 게시판 목록
	public List<CustomerCenterDTO> boardList();
	
	// 게시물 조회
	public CustomerCenterDTO boardView(int cus_b_num);
}
