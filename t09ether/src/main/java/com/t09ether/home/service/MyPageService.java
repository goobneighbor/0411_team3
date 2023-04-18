package com.t09ether.home.service;

import com.t09ether.home.dto.MyPageDTO;

public interface MyPageService {
	public MyPageDTO loginOk(String userid, String userpwd);
	public MyPageDTO mpRegisterEdit(String userid);
	public MyPageDTO idChk(String userid);
}

