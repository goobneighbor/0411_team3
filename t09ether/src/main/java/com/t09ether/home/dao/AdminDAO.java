package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.AdReportPagingVO;
import com.t09ether.home.dto.AdUserPagingVO;

import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.DataVO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.dto.ReportDTO;

public interface AdminDAO {

	//회원 관리 게시판 리스트
	public int totalRecord(AdUserPagingVO vo);
	public List<RegisterDTO> pageSelect(AdUserPagingVO vo);
	
	//신고관리 게시판 리스트
	public int rpTotalRecord(AdReportPagingVO vo);
	public List<ReportDTO> reportPageSelect(AdReportPagingVO vo);


	public int totalOrderRecord(AdminPagingVO vo);
	public List<RegisterDTO> userSelect();
	public List<OrderDTO> mgtPageSelect(AdminPagingVO vo);
	public int ordMultiUpdate(int on_no); //@Param("on_noList")List<Integer> on_noList, @Param("status")List<Integer> status
	
	//통계
	public List<DataVO> getList();
}
