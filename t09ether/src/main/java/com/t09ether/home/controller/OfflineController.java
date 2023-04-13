package com.t09ether.home.controller;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.service.OfflineService;

@RestController
public class OfflineController {
	@Autowired
	OfflineService service;
	
	//오프라인공구 게시판목록
	@GetMapping("/offline")
	public ModelAndView offline() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("offline/offline_board");
		return mav;
	}
	
	//글쓰기
	@GetMapping("/offlineWrite")
	public ModelAndView offlineWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("offline/offlineWrite");
		return mav;
	}
	
	//글등록(DB)
	@PostMapping("/offlineInsert")	
	public ResponseEntity<String> boardWriteOk(OfflineDTO dto,HttpServletRequest request) {
		//dto.setIp(request.getRemoteAddr());//ip
		dto.setUserid((String)request.getSession().getAttribute("logId"));//로그인한 아이디 구하기
		//글등록실패하면 예외발생
		String htmlTag="<script>";
		try {
			int result = service.offlineInsert(dto);
			htmlTag += "location.href='offline_board';";
		}catch(Exception e) {
			e.printStackTrace();
			htmlTag += "alert('글이 등록되지않았습니다.');";
			htmlTag += "history.back();";
		}
		htmlTag += "</script>";
		//결과
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		//                        내용
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);	
		
	}
	
	
}
