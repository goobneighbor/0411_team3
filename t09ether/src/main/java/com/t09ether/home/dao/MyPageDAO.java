package com.t09ether.home.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.MyPageDTO;
import com.t09ether.home.dto.OffPartDTO;
import com.t09ether.home.dto.OrderDTO;

public interface MyPageDAO {
	public MyPageDTO loginOk(String userid, String userpwd);
	public MyPageDTO mpRegisterEdit(String userid);
	public MyPageDTO idChk(String userid);
	public int mpRegisterEditOk1(MyPageDTO dto);
	public int mpRegisterEditOk2(MyPageDTO dto);
	
	//온라인 공구내역 게시판 리스트 + 페이징
	public int totalRecord(AdminPagingVO vo);
	public List<OrderDTO> pageSelect(@Param("vo")AdminPagingVO vo,@Param("totalPage") int totalPage, @Param("searchKey") String searchKey, @Param("searchWord") String searchWord,  @Param("userid")String userid, @Param("nowPage") int nowPage, @Param("onePageRecord") int onePageRecord, @Param("lastPageRecord") int lastPageRecord);
	
	//오프라인 공구 게시판 페이징
	public List<OffPartDTO> offPageSelect(AdminPagingVO vo);
	
	public OffPartDTO boardSelect(int no);
}
