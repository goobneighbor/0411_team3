package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.OrderDTO;
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

}
