package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.AdminDAO;
import com.t09ether.home.dto.AdReportPagingVO;
import com.t09ether.home.dto.AdUserPagingVO;
import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.dto.CustomerCenterPagingVO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.dto.ReportDTO;

@Service
public class AdminServiceImpl implements AdminService {
	@Inject
	AdminDAO dao;
	
	@Override
	public int totalRecord(AdUserPagingVO vo) {
		return dao.totalRecord(vo);
	}

	@Override
	public List<RegisterDTO> pageSelect(AdUserPagingVO vo) {
		return dao.pageSelect(vo);
	}
	
	//신고관리 게시판 리스트
	@Override
	public int rpTotalRecord(AdReportPagingVO vo) {
		return dao.rpTotalRecord(vo);
	}
	
	@Override
	public List<ReportDTO> reportPageSelect(AdReportPagingVO vo) {
		return dao.reportPageSelect(vo);
	}

	@Override
	public List<RegisterDTO> userSelect() {
		return dao.userSelect();
	}

	@Override
	public int csTotalRecord(CustomerCenterPagingVO vo) {
		return dao.csTotalRecord(vo);
	}

	@Override
	public List<CustomerCenterDTO> csPageSelect(CustomerCenterPagingVO vo) {
		return dao.csPageSelect(vo);
	}

	@Override
	public int csBoardInsert(CustomerCenterDTO cdto) {
		// TODO Auto-generated method stub
		return dao.csBoardInsert(cdto);
	}

	@Override
	public CustomerCenterDTO csBoardEditSelect(int cus_b_num) {
		// TODO Auto-generated method stub
		return dao.csBoardEditSelect(cus_b_num);
	}

	@Override
	public int csBoardUpdate(CustomerCenterDTO cdto) {
		// TODO Auto-generated method stub
		return dao.csBoardUpdate(cdto);
	}

	@Override
	public CustomerCenterDTO csBoardSelect(int cus_b_num) {
		// TODO Auto-generated method stub
		return dao.csBoardSelect(cus_b_num);
	}

	@Override
	public int csBoardDelete(CustomerCenterDTO cdto) {
		// TODO Auto-generated method stub
		return dao.csBoardDelete(cdto);
	}


}
