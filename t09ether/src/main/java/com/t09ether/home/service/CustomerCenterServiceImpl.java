package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.CustomerCenterDAO;
import com.t09ether.home.dao.RegisterDAO;
import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.dto.CustomerCenterPagingVO;
import com.t09ether.home.dto.RegisterDTO;

@Service
public class CustomerCenterServiceImpl implements CustomerCenterService {
	@Inject
	CustomerCenterDAO dao;

	// 고객센터 게시판 전체 목록 보기
	@Override
	public List<CustomerCenterDTO> boardList() {
		return dao.boardList();
	}
	
	//고객센터 게시판 글 조회
	@Override
	public CustomerCenterDTO boardView(int cus_b_num) {
		return dao.boardView(cus_b_num);
	}

	@Override
	public int totalRecord(CustomerCenterPagingVO vo) {
		return dao.totalRecord(vo);
	}

	@Override
	public List<CustomerCenterDTO> pageSelect(CustomerCenterPagingVO vo) {
	
		return dao.pageSelect(vo);
	}

	@Override
	public int csBoardInsert(CustomerCenterDTO cdto) {
		return dao.csBoardInsert(cdto);
	}

	@Override
	public CustomerCenterDTO csBoardEditSelect(int cus_b_num) {
		return dao.csBoardEditSelect(cus_b_num);
	}

	@Override
	public int csBoardUpdate(CustomerCenterDTO cdto) {
		return dao.csBoardUpdate(cdto);
	}


}
