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
	public List<OfflineDTO> offList(OfflinePagingVO vo) {
		return dao.offList(vo);
	}

	@Override
	public OfflineDTO offlineSelect(int off_no) {
		return dao.offlineSelect(off_no);
	}

	@Override
	public void offlineHitCount(int off_no) {
		dao.offlineHitCount(off_no);
	}

	@Override
	public OfflineDTO offlineEditSelect(int off_no) {
		return dao.offlineEditSelect(off_no);
	}

	@Override
	public int offlineUpdate(OfflineDTO dto) {
		return dao.offlineUpdate(dto);
	}

	@Override
	public int offlineDelete(OfflineDTO dto) {
		return dao.offlineDelete(dto);
	}

	

	

}
