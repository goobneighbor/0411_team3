package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.dto.CustomerCenterPagingVO;
import com.t09ether.home.dto.RegisterDTO;

public interface CustomerCenterDAO {
	// 고객센터 게시판 목록
	public List<CustomerCenterDTO> boardList();
	// 게시물 조회
	public CustomerCenterDTO boardView(int cus_b_num);
	// 총 레코드 수
	public int totalRecord(CustomerCenterPagingVO vo);
	// 해당페이지 선택
	public List<CustomerCenterDTO> pageSelect(CustomerCenterPagingVO vo);
	// 문의게시판에 글쓰기
	public int csBoardInsert(CustomerCenterDTO cdto);
	
	public CustomerCenterDTO csBoardEditSelect(int cus_b_num);
	
	public int csBoardUpdate(CustomerCenterDTO cdto);
	
}
