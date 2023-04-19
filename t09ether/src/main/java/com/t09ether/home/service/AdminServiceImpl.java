package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.AdminDAO;
import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.RegisterDTO;

@Service
public class AdminServiceImpl implements AdminService {
	@Inject
	AdminDAO dao;

	@Override
	public int totalRecord(AdminPagingVO vo) {
		return dao.totalRecord(vo);
	}

	@Override
	public List<RegisterDTO> pageSelect(AdminPagingVO vo) {
		return dao.pageSelect(vo);
	}
}
