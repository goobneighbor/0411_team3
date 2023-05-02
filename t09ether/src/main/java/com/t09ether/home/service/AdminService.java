package com.t09ether.home.service;

import java.util.List;


import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.ProductDTO;

import com.t09ether.home.dto.AdReportPagingVO;
import com.t09ether.home.dto.AdUserPagingVO;
import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.dto.CustomerCenterPagingVO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.dto.ReportDTO;

public interface AdminService {

	public int totalRecord(AdminPagingVO vo);
	public int totalOrderRecord(AdminPagingVO vo);
	public int totalOrdRecord(AdminPagingVO vo);
	public List<RegisterDTO> pageSelect(AdminPagingVO vo);

	public int totalRecord(AdUserPagingVO vo);
	public List<RegisterDTO> pageSelect(AdUserPagingVO vo);
	
	//신고관리 게시판 리스트
	public int rpTotalRecord(AdReportPagingVO vo);
	public List<ReportDTO> reportPageSelect(AdReportPagingVO vo);

	public List<RegisterDTO> userSelect();
	public List<OrderDTO> totalOrdSelect(AdminPagingVO vo);
	public List<OrderDTO> mgtPageSelect(AdminPagingVO vo);
	public int ordMultiUpdate(int on_no); //List<Integer> on_noList, List<Integer> status

	public int totalProductRecord(AdminPagingVO vo);
	public List<RegisterDTO> pageProductSelect(AdminPagingVO vo);
	public int productInsert(ProductDTO dto);
	public int productDel(List<Integer> list);
	public ProductDTO proInfor(int pro_code);
	public int productUpdate(ProductDTO dto);
	
	//고객센터 게시판 리스트
	public int csTotalRecord(CustomerCenterPagingVO vo);
	public List<CustomerCenterDTO> csPageSelect(CustomerCenterPagingVO vo);
	public int csBoardInsert(CustomerCenterDTO cdto);
	// 고객센터 faqlist에서 글수정
	public CustomerCenterDTO csBoardEditSelect(int cus_b_num);
	// 고객센터 글 수정한것 업데이트
	public int csBoardUpdate(CustomerCenterDTO cdto);
	//글 보기
	public CustomerCenterDTO csBoardSelect(int cus_b_num);
	//글 삭제하기
	public int csBoardDelete(CustomerCenterDTO cdto);


}
