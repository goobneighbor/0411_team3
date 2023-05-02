package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.AdminOrderPagingVO;
import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.ProductDTO;
import com.t09ether.home.dto.RegisterDTO;

public interface AdminService {
	public int totalRecord(AdminPagingVO vo);
	public int totalOrderRecord(AdminPagingVO vo);
	public int totalOrdRecord(AdminPagingVO vo);
	public List<RegisterDTO> pageSelect(AdminPagingVO vo);
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
	
	public int totalStopRecord(AdminOrderPagingVO vo2);
	public List<RegisterDTO> pageStopSelect(AdminOrderPagingVO vo2);
	public int tempStopInsert(List<String> list);
	public int tempStopDel(List<String> list);
	
	public int totalReportRecord(AdminPagingVO vo);
	public List<RegisterDTO> pageReportSelect(AdminPagingVO vo);
}
