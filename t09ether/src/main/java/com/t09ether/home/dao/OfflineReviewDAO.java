package com.t09ether.home.dao;

import com.t09ether.home.dto.OfflineReviewDTO;

public interface OfflineReviewDAO {
	//리뷰등록
	public int offlineReviewInsert(OfflineReviewDTO dto);
}
