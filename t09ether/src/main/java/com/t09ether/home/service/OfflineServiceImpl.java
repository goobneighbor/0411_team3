package com.t09ether.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t09ether.home.dao.OfflineDAO;
import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.dto.OfflinePagingVO;
@Service
public class OfflineServiceImpl implements OfflineService {
	@Autowired
	OfflineDAO dao;
	
	@Override
	public int offlineInsert(OfflineDTO dto) {
		return dao.offlineInsert(dto);
	}

	@Override
	public int totalRecord(OfflinePagingVO vo) {
		return dao.totalRecord(vo);
	}

	@Override
	public List<OfflineDTO> pageSelect(OfflinePagingVO vo) {
		return dao.pageSelect(vo);
	}

}
