package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.AdReportPagingVO;
import com.t09ether.home.dto.AdUserPagingVO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.dto.ReportDTO;

public interface AdminDAO {

	//회원 관리 게시판 리스트
	public int totalRecord(AdUserPagingVO vo);
	public List<RegisterDTO> pageSelect(AdUserPagingVO vo);
	
	//신고관리 게시판 리스트
	public int rpTotalRecord(AdReportPagingVO vo);
	public List<ReportDTO> reportPageSelect(AdReportPagingVO vo);

	public List<RegisterDTO> userSelect();
}
