package com.t09ether.home.service;

import java.util.List;


import com.t09ether.home.dto.AdReportPagingVO;
import com.t09ether.home.dto.AdUserPagingVO;
import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.dto.ReportDTO;

public interface AdminService {
	public int totalRecord(AdUserPagingVO vo);
	public List<RegisterDTO> pageSelect(AdUserPagingVO vo);
	
	//신고관리 게시판 리스트
	public int rpTotalRecord(AdReportPagingVO vo);
	public List<ReportDTO> reportPageSelect(AdReportPagingVO vo);

	public int totalOrderRecord(AdminPagingVO vo);
	public List<RegisterDTO> userSelect();
	public List<OrderDTO> mgtPageSelect(AdminPagingVO vo);
	public int ordMultiUpdate(int on_no); //List<Integer> on_noList, List<Integer> status

}
