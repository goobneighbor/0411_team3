package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.AdReportPagingVO;
import com.t09ether.home.dto.AdUserPagingVO;
import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.dto.CustomerCenterPagingVO;
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
	
	/*고객센터 게시판*/
	//전체 레코드 수
	public int csTotalRecord(CustomerCenterPagingVO vo);
	//게시물 목록 보기
	public List<CustomerCenterDTO> csPageSelect(CustomerCenterPagingVO vo);
	// 고객센터 게시글 쓰기
	public int csBoardInsert(CustomerCenterDTO cdto);
	// 고객센터 faqlist에서 글수정
	public CustomerCenterDTO csBoardEditSelect(int cus_b_num);
	// 고객센터 글 수정한것 업데이트
	public int csBoardUpdate(CustomerCenterDTO cdto);
	//글 보기
	public CustomerCenterDTO csBoardSelect(int cus_b_num);
	//글 삭제하기
	public int csBoardDelete(CustomerCenterDTO cdto);
	
	//public List<CustomerCenterDTO> todoReplyList(CustomerCenterDTO dto);
	
}
