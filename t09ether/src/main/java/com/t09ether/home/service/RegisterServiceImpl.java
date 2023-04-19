package com.t09ether.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.RegisterDAO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.dto.ZipcodeDTO;

@Service
public class RegisterServiceImpl implements RegisterService {
	//객체생성
	//	@AutoWired,  @Inject : interface를 객체로 생성
	@Inject
	RegisterDAO dao;
	
	@Override
	public RegisterDTO loginOk(String userid, String userpwd) {
		return dao.loginOk(userid, userpwd);
	}

	@Override
	public int idCheckCount(String userid) {
		return dao.idCheckCount(userid);
	}

	@Override
	public List<ZipcodeDTO> zipSearch(String doroname) {
		return dao.zipSearch(doroname);
	}

	@Override
	public int registerInsert(RegisterDTO dto) {
		return dao.registerInsert(dto);
	}

	@Override
	public RegisterDTO registerEdit(String userid) {
		return dao.registerEdit(userid);
	}

	@Override
	public int registerEditOk(RegisterDTO dto) {
		return dao.registerEditOk(dto);
	}

	@Override
	public String idSearch(String username, String email) {
		return dao.idSearch(username, email);
	}

	@Override
	public RegisterDTO rSelect(String userid) {
		return dao.rSelect(userid);
	}
}