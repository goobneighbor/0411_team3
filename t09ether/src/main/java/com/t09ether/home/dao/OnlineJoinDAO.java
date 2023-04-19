package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.OrderDTO;

public interface OnlineJoinDAO {
	
	//나눔장소목록선택
		public List<OrderDTO> locationListSelect(int pro_code);
		
	//나눔목록지도
		public List<OrderDTO> getList(String searchWrd);
		
}
