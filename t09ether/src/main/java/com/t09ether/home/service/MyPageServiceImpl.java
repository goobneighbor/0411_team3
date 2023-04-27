package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.MyPageDAO;
import com.t09ether.home.dto.AdUserPagingVO;
import com.t09ether.home.dto.MyPageDTO;
import com.t09ether.home.dto.MyPostPagingVO;
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
	public int totalRecord(AdUserPagingVO vo) {
		return dao.totalRecord(vo);
	}

	@Override
	public List<OrderDTO> pageSelect(AdUserPagingVO vo) {
		return dao.pageSelect(vo);
	}
	
	//오프라인 공구 게시판 페이징
	@Override
	public int mpTotalRecord(MyPostPagingVO vo) {
		return dao.mpTotalRecord(vo);
	}

	@Override
	public List<OffPartDTO> offPageSelect(MyPostPagingVO vo) {
		return dao.offPageSelect(vo);
	}

	@Override
	public OffPartDTO boardSelect(int no) {
		return dao.boardSelect(no);
	}

	@Override
	public List<OffPartDTO> offPartList(int no) {
		return dao.offPartList(no);
	}
	
}
