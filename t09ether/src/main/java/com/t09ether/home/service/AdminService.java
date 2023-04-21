package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.RegisterDTO;

public interface AdminService {
	public int totalRecord(AdminPagingVO vo);
	public List<RegisterDTO> pageSelect(AdminPagingVO vo);

}
