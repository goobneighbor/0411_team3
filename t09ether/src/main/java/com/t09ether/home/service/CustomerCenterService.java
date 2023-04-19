package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.dto.CustomerCenterPagingVO;

public interface CustomerCenterService {
	// 고객센터 글목록
	public List<CustomerCenterDTO> boardList();
	// 고객센터 글 상세조회
	public CustomerCenterDTO boardView(int cus_b_num);
	// 총 레코드 수
	public int totalRecord(CustomerCenterPagingVO vo);
	// 해당페이지 선택
	public List<CustomerCenterDTO> pageSelect(CustomerCenterPagingVO vo);

}
