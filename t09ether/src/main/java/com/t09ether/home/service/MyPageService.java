package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.AdUserPagingVO;
import com.t09ether.home.dto.MyPageDTO;
import com.t09ether.home.dto.MyPostPagingVO;
import com.t09ether.home.dto.OffPartDTO;
import com.t09ether.home.dto.OrderDTO;

public interface MyPageService {
	public MyPageDTO loginOk(String userid, String userpwd);
	public MyPageDTO mpRegisterEdit(String userid);
	public MyPageDTO idChk(String userid);
	public int mpRegisterEditOk1(MyPageDTO dto);
	public int mpRegisterEditOk2(MyPageDTO dto);
	
	//온라인 공구내역 게시판 리스트 + 페이징
	public int totalRecord(AdUserPagingVO vo);
	public List<OrderDTO> pageSelect(AdUserPagingVO vo);
	
	//오프라인 공구 게시판 페이징
	public int mpTotalRecord(MyPostPagingVO vo);
	public List<OffPartDTO> offPageSelect(MyPostPagingVO vo);
	
	public OffPartDTO boardSelect(int no);
	
	//오프라인 구성원 리스트
	public List<OffPartDTO> offPartList(int no);
}

