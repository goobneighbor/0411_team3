package com.t09ether.home.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.t09ether.home.dto.AdminOrderPagingVO;
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
	public int totalOrdRecord(@Param("vo")AdminPagingVO vo, @Param("searchKey") String searchKey, @Param("searchWord") String searchWord,  @Param("userid")String userid);
	public int totalOrdSucRecord(@Param("vo2")AdminOrderPagingVO vo2, @Param("searchKey2") String searchKey2, @Param("searchWord2") String searchWord2,  @Param("userid")String userid);
	public List<OrderDTO> pageSelect(@Param("vo")AdminPagingVO vo,@Param("totalPage") int totalPage, @Param("searchKey") String searchKey, @Param("searchWord") String searchWord,  @Param("userid")String userid, @Param("nowPage") int nowPage, @Param("onePageRecord") int onePageRecord, @Param("lastPageRecord") int lastPageRecord);
	
	public List<OrderDTO> pageOrdSelect(@Param("vo")AdminPagingVO vo,@Param("totalPage") int totalPage, @Param("searchKey") String searchKey, @Param("searchWord") String searchWord,  @Param("userid")String userid, @Param("nowPage") int nowPage, @Param("onePageRecord") int onePageRecord, @Param("lastPageRecord") int lastPageRecord);
	public List<OrderDTO> pageOrdSucSelect(@Param("vo2")AdminOrderPagingVO vo2,@Param("totalPage2") int totalPage2, @Param("searchKey2") String searchKey2, @Param("searchWord2") String searchWord2,  @Param("userid")String userid, @Param("nowPage2") int nowPage2, @Param("onePageRecord2") int onePageRecord2, @Param("lastPageRecord2") int lastPageRecord2);
	
	//오프라인 공구 게시판 페이징
	public List<OffPartDTO> offPageSelect(AdminPagingVO vo);
	
	public OffPartDTO boardSelect(int no);
}
