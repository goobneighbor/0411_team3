package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.t09ether.home.dao.MyPageDAO;
import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.MyPageDTO;
import com.t09ether.home.dto.OffPartDTO;
import com.t09ether.home.dto.OrderDTO;

@Service
public class MyPageServiceImpl implements MyPageService {
	@Inject
	MyPageDAO dao;

	@Override
	public MyPageDTO loginOk(String userid, String userpwd) {
		return dao.loginOk(userid, userpwd);
	}

	@Override
	public MyPageDTO mpRegisterEdit(String userid) {
		return dao.mpRegisterEdit(userid);
	}

	@Override
	public MyPageDTO idChk(String userid) {
		return dao.idChk(userid);
	}

	@Override
	public int mpRegisterEditOk1(MyPageDTO dto) {
		return dao.mpRegisterEditOk1(dto);
	}

	@Override
	public int mpRegisterEditOk2(MyPageDTO dto) {
		return dao.mpRegisterEditOk2(dto);
	}
	
	
	//온라인 공구내역 게시판 리스트 + 페이징
	@Override
	public int totalRecord(AdminPagingVO vo) {
		return dao.totalRecord(vo);
	}

	@Override
	public List<OrderDTO> pageSelect(AdminPagingVO vo, int totalPage,String searchKey, String searchWord, String userid, int nowPage, int onePageRecord, int lastPageRecord) {
		return dao.pageSelect(vo, totalPage,searchKey, searchWord, userid, nowPage, onePageRecord, lastPageRecord);
	}
	
	//오프라인 공구 게시판 페이징
	@Override
	public List<OffPartDTO> offPageSelect(AdminPagingVO vo) {
		return dao.offPageSelect(vo);
	}

	@Override
	public OffPartDTO boardSelect(int no) {
		return dao.boardSelect(no);
	}

	@Override
	public int totalOrdRecord(AdminPagingVO vo) {
		return dao.totalOrdRecord(vo);
	}

	

}
