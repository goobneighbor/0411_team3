package com.t09ether.home.dao;


import com.t09ether.home.dto.OnlineDTO;
import com.t09ether.home.dto.OrderDTO;

public interface OrderDAO {
	public int orderInsert(OrderDTO dto);
	public int onlineInsert(OnlineDTO dto);
	public OrderDTO orderSelect(int pro_code, String userid);
}
