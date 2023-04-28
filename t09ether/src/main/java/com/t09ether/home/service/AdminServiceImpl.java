package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.AdminDAO;
import com.t09ether.home.dto.AdReportPagingVO;
import com.t09ether.home.dto.AdUserPagingVO;
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
}
