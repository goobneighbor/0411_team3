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
	
	//�������ΰ��� �Խ��Ǹ��
	@GetMapping("/offline")
	public ModelAndView offline() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("offline/offline_board");
		return mav;
	}
	
	//�۾���
	@GetMapping("/offlineWrite")
	public ModelAndView offlineWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("offline/offlineWrite");
		return mav;
	}
	
	//�۵��(DB)
	@PostMapping("/offlineInsert")	
	public ResponseEntity<String> boardWriteOk(OfflineDTO dto,HttpServletRequest request) {
		//dto.setIp(request.getRemoteAddr());//ip
		dto.setUserid((String)request.getSession().getAttribute("logId"));//�α����� ���̵� ���ϱ�
		//�۵�Ͻ����ϸ� ���ܹ߻�
		String htmlTag="<script>";
		try {
			int result = service.offlineInsert(dto);
			htmlTag += "location.href='offline_board';";
		}catch(Exception e) {
			e.printStackTrace();
			htmlTag += "alert('���� ��ϵ����ʾҽ��ϴ�.');";
			htmlTag += "history.back();";
		}
		htmlTag += "</script>";
		//���
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		//                        ����
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);	
		
	}
	
	
}
