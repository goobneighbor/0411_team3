package com.t09ether.home.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.OfflineReviewDAO;
import com.t09ether.home.dto.OfflineReviewDTO;
@Service
public class OfflineReviewServiceImpl implements OfflineReviewService {
	@Inject
	OfflineReviewDAO dao;
	
	@Override
	public int offlineReviewInsert(OfflineReviewDTO dto) {
		return dao.offlineReviewInsert(dto);
	}

}
