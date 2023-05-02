package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.AdminOrderPagingVO;
import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.ProductDTO;
import com.t09ether.home.dto.RegisterDTO;

public interface AdminDAO {
	public int totalRecord(AdminPagingVO vo);
	public int totalOrdRecord(AdminPagingVO vo);
	public int totalOrderRecord(AdminPagingVO vo);
	public List<RegisterDTO> pageSelect(AdminPagingVO vo);
	public List<RegisterDTO> userSelect();
	public List<OrderDTO> totalOrdSelect(AdminPagingVO vo);
	public List<OrderDTO> mgtPageSelect(AdminPagingVO vo);
	public int ordMultiUpdate(int on_no); //@Param("on_noList")List<Integer> on_noList, @Param("status")List<Integer> status

	//온라인 상품 관리
	public int totalProductRecord(AdminPagingVO vo);
	public List<RegisterDTO> pageProductSelect(AdminPagingVO vo);
	public int productInsert(ProductDTO dto);
	public int productDel(List<Integer> list);
	public ProductDTO proInfor(int pro_code);
	public int productUpdate(ProductDTO dto);
	
	//회원정보 임시정지
	public int totalStopRecord(AdminOrderPagingVO vo2);
	public List<RegisterDTO> pageStopSelect(AdminOrderPagingVO vo2);
	public int tempStopInsert(List<String> list);
	public int tempStopDel(List<String> list);
	
	//신고관리
	public int totalReportRecord(AdminPagingVO vo);
	public List<RegisterDTO> pageReportSelect(AdminPagingVO vo);
	public int reportDel(List<Integer> list);
	public List<String> targetSelect(List<Integer> list);
	public int targetUpdate(String userid);
}
