package com.t09ether.home.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.RegisterDTO;

public interface AdminDAO {
	public int totalRecord(AdminPagingVO vo);
	public int totalOrderRecord(AdminPagingVO vo);
	public List<RegisterDTO> pageSelect(AdminPagingVO vo);
	public List<RegisterDTO> userSelect();
	public List<OrderDTO> mgtPageSelect(@Param("vo")AdminPagingVO vo,@Param("totalPage") int totalPage, @Param("searchKey") String searchKey, @Param("searchWord") String searchWord,  @Param("userid")String userid, @Param("nowPage") int nowPage, @Param("onePageRecord") int onePageRecord, @Param("lastPageRecord") int lastPageRecord);
	public int ordMultiUpdate(int on_no); //@Param("on_noList")List<Integer> on_noList, @Param("status")List<Integer> status
}
