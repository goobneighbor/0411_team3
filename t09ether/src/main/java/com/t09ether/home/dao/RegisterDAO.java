package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.dto.ZipcodeDTO;

public interface RegisterDAO {
	//추상메소드
	public RegisterDTO loginOk(String userid, String userpwd);
	//아이디 중복검사
	public int idCheckCount(String userid);
	//도로명 검색
	public List<ZipcodeDTO> zipSearch(String doroname);
	//회원 가입
	public int registerInsert(RegisterDTO dto);
	//회원정보 수정 폼
	public RegisterDTO registerEdit(String userid);
	//회원정보 수정 db update
	public int registerEditOk(RegisterDTO dto);
	//이름과 이메일로 아이디 검색
	public String idSearch(String username, String email);
	//회원의 rank select
	public int rankSelect(String userid);

}