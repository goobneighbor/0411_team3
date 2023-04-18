package com.t09ether.home.dao;

import com.t09ether.home.dto.MyPageDTO;

public interface MyPageDAO {
	public MyPageDTO loginOk(String userid, String userpwd);
	public MyPageDTO mpRegisterEdit(String userid);
	public MyPageDTO idChk(String userid);
}
