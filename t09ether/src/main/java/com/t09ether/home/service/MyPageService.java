package com.t09ether.home.service;

import com.t09ether.home.dto.MyPageDTO;

public interface MyPageService {
	public MyPageDTO loginOk(String userid, String userpwd);
	public MyPageDTO mpRegisterEdit(String userid);
	public MyPageDTO idChk(String userid);
	public int mpRegisterEditOk1(MyPageDTO dto);
	public int mpRegisterEditOk2(MyPageDTO dto);
}

