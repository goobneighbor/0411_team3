package com.t09ether.home.dao;


import org.apache.ibatis.annotations.Param;

import com.t09ether.home.dto.OnlineDTO;
import com.t09ether.home.dto.OrderDTO;

public interface OrderDAO {
	public int orderInsert(OrderDTO dto);
	public int onlineInsert(OnlineDTO dto);
	public OrderDTO orderSelect(@Param ("pro_code")int pro_code, @Param ("userid")String userid);
}
