package com.t09ether.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t09ether.home.dao.OfflineDAO;
import com.t09ether.home.dto.OfflineDTO;
@Service
public class OfflineServiceImpl implements OfflineService {
	@Autowired
	OfflineDAO dao;
	
	@Override
	public int offlineInsert(OfflineDTO dto) {
		return dao.offlineInsert(dto);
	}

}
