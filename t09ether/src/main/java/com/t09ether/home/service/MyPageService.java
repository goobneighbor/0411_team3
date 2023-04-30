package com.t09ether.home.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.t09ether.home.dto.AdminOrderPagingVO;
import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.MyPageDTO;
import com.t09ether.home.dto.OffPartDTO;
import com.t09ether.home.dto.OrderDTO;

public interface MyPageService {
	public MyPageDTO loginOk(String userid, String userpwd);
	public MyPageDTO mpRegisterEdit(String userid);
	public MyPageDTO idChk(String userid);
	public int mpRegisterEditOk1(MyPageDTO dto);
	public int mpRegisterEditOk2(MyPageDTO dto);
	
	//온라인 공구내역 게시판 리스트 + 페이징
	public int totalRecord(AdminPagingVO vo);
	public int totalOrdRecord(AdminPagingVO vo, String searchKey, String searchWord, String userid);
	public int totalOrdSucRecord(AdminOrderPagingVO vo2, String searchKey2, String searchWord2, String userid);
	public List<OrderDTO> pageSelect(AdminPagingVO vo, int totalPage, String searchKey, String searchWord, String userid,int nowPage, int onePageRecord,int lastPageRecord);
	
	
	public List<OrderDTO> pageOrdSelect(AdminPagingVO vo, int totalPage, String searchKey, String searchWord, String userid, int nowPage, int onePageRecord, int lastPageRecord);
	public List<OrderDTO> pageOrdSucSelect(AdminOrderPagingVO vo2, int totalPage2, String searchKey2, String searchWord2, String userid, int nowPage2, int onePageRecord2, int lastPageRecord2);
	
	//오프라인 공구 게시판 페이징
	public List<OffPartDTO> offPageSelect(AdminPagingVO vo);
	
	public OffPartDTO boardSelect(int no);
}

