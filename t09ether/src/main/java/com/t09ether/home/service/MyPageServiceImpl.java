package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.t09ether.home.dao.MyPageDAO;

import com.t09ether.home.dto.AdminOrderPagingVO;
import com.t09ether.home.dto.AdminPagingVO;

import com.t09ether.home.dto.AdUserPagingVO;

import com.t09ether.home.dto.MyPageDTO;
import com.t09ether.home.dto.MyPostPagingVO;
import com.t09ether.home.dto.OffPartDTO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.ReportDTO;

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

	public List<OrderDTO> pageSelect(AdminPagingVO vo) {
		return dao.pageSelect(vo);
	}
	public List<OrderDTO> pageSelect(AdUserPagingVO vo, int totalPage,String searchKey, String searchWord, String userid, int nowPage, int onePageRecord, int lastPageRecord) {
		return dao.pageSelect(vo, totalPage,searchKey, searchWord, userid, nowPage, onePageRecord, lastPageRecord);
	}
	
	//오프라인 공구 게시판 페이징
	@Override
	public int mpTotalRecord(MyPostPagingVO vo) {
		return dao.mpTotalRecord(vo);
	}

	@Override
	public List<OffPartDTO> offPageSelect(MyPostPagingVO vo, int totalPage, String searchKey, String searchWord, String userid, int nowPage, int onePageRecord, int lastPageRecord) {
		return dao.offPageSelect(vo, totalPage, searchKey, searchWord, userid, nowPage, onePageRecord, lastPageRecord);
	}

	@Override
	public OffPartDTO boardSelect(int no) {
		return dao.boardSelect(no);
	}

	@Override
	public int totalOrdRecord(AdminPagingVO vo) {
		return dao.totalOrdRecord(vo);
	}

	@Override
	public int totalOrdSucRecord(AdminOrderPagingVO vo2) {
		return dao.totalOrdSucRecord(vo2);
	}

	@Override
	public List<OrderDTO> pageOrdSelect(AdminPagingVO vo) {
		return dao.pageOrdSelect(vo);
	}

	@Override
	public List<OrderDTO> pageOrdSucSelect(AdminOrderPagingVO vo2) {
		return dao.pageOrdSucSelect(vo2);
	}

	@Override
	public int myOrderSucUpdate(int on_no) {
		return dao.myOrderSucUpdate(on_no);
	}

	@Override
	public int reportInsert(ReportDTO dto) {
		return dao.reportInsert(dto);
	}

	@Override
	public int reportRegisterUpdate(String target_id) {
		return dao.reportRegisterUpdate(target_id);
	}

	@Override
	public int orderStatusUpdate(int ord_no) {
		return dao.orderStatusUpdate(ord_no);
	}


	@Override
	public int expUpdate(String userid) {
		return dao.expUpdate(userid);
	}

	public List<OffPartDTO> offPartList(int no) {
		return dao.offPartList(no);
	}

	@Override
	public int totalRecord(AdminPagingVO vo) {
		return dao.totalRecord(vo);
	}

	@Override
	public int expSelect(String userid) {
		return dao.expSelect(userid);
	}

	@Override
	public int rankUpdate(String userid) {
		return dao.rankUpdate(userid);
	}

	
	
	
}
