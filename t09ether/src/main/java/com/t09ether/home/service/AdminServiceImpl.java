package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.AdminDAO;
import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.OrderDTO;
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

	@Override
	public List<RegisterDTO> userSelect() {
		return dao.userSelect();
	}

	@Override
	public List<OrderDTO> mgtPageSelect(AdminPagingVO vo) {
		return dao.mgtPageSelect(vo);
	}

	@Override
	public int ordMultiUpdate(int on_no) {
		//, List<Integer> status
		return dao.ordMultiUpdate(on_no);
	}

	@Override
	public int totalOrderRecord(AdminPagingVO vo) {
		return dao.totalOrderRecord(vo);
	}
}
