package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.OnlineReviewDTO;

public interface OnlineReviewService {
	public List<OnlineReviewDTO> selectReview(int pro_code);
	public int rateAvg(int pro_code);
	public List<String> userList(int pro_code);
}
