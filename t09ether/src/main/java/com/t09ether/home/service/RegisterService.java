package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.dto.ZipcodeDTO;

public interface RegisterService {
	//추상 메소드
	public RegisterDTO loginOk(String userid, String userpwd);
	public int idCheckCount(String userid);
	public List<ZipcodeDTO> zipSearch(String doroname);
	public int registerInsert(RegisterDTO dto);
	public RegisterDTO registerEdit(String userid);
	public int registerEditOk(RegisterDTO dto);
	public String idSearch(String username, String email);
}
