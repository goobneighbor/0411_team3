package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.OnlineDTO;
import com.t09ether.home.dto.OrderDTO;

public interface OrderService {
	public int orderInsert(OrderDTO dto);
	public int onlineInsert(OnlineDTO dto);
	public OrderDTO orderSelect(int pro_code, int on_no, String userid);

}
