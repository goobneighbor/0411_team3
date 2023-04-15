package com.t09ether.home.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.MyPageDAO;
import com.t09ether.home.dao.RegisterDAO;
import com.t09ether.home.dto.MyPageDTO;
import com.t09ether.home.dto.RegisterDTO;

@Service
public class MyPageServiceImpl implements MyPageService {
	@Inject
	MyPageDAO dao;

	@Override
	public MyPageDTO loginOk(String userid, String userpwd) {
		return dao.loginOk(userid, userpwd);
	}

}
