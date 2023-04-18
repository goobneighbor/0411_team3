package com.t09ether.home.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.MyPageDAO;
import com.t09ether.home.dto.MyPageDTO;

@Service
public class MyPageServiceImpl implements MyPageService {
	@Inject
	MyPageDAO dao;

	@Override
	public MyPageDTO loginOk(String userid, String userpwd) {
		return dao.loginOk(userid, userpwd);
	}

	@Override
	public MyPageDTO mpRegisterEdit(String userid) {
		return dao.mpRegisterEdit(userid);
	}

	@Override
	public MyPageDTO idChk(String userid) {
		return dao.idChk(userid);
	}

}
