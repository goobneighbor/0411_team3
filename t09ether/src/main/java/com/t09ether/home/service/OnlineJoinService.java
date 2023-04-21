package com.t09ether.home.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.t09ether.home.dto.OnlineDTO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.ProductDTO;

public interface OnlineJoinService {
	//나눔장소목록선택
	public List<OrderDTO> locationListSelect(int pro_code);
	//나눔목록지도
	public List<OrderDTO> getList(int pro_code, String searchWrd);
	public List<OrderDTO> getSearchList(int pro_code, String searchWrd);
	public ProductDTO proInfor(int on_no);
	public int userRank(String userid);
}
