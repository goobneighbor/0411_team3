package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.RegisterDTO;

public interface AdminDAO {
	public int totalRecord(AdminPagingVO vo);
	public List<RegisterDTO> pageSelect(AdminPagingVO vo);
}
