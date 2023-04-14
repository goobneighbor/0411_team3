package com.t09ether.home.controller;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.t09ether.home.dto.OfflinePagingVO;
import com.t09ether.home.service.OfflineService;

@RestController
public class OfflineController {
	@Autowired
	OfflineService service;
	
	//�������ΰ��� �Խ��Ǹ��
	@GetMapping("/offline")
	public ModelAndView offline(OfflinePagingVO vo) {
		ModelAndView mav = new ModelAndView();		
		
		vo.setTotalRecord(service.totalRecord(vo));//�ѷ��ڵ�� ���� 
		System.out.println(vo.getTotalRecord());
		mav.addObject("offDTO", service.offList(vo));
		mav.addObject("vo", vo);//���������� ������ ���� ����
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
		//dto.setUserid((String)request.getSession().getAttribute("logId"));//�α����� ���̵� ���ϱ�
		dto.setCurrent_num(1);//�����ο� 1�� �ʱ�ȭ
		dto.setOff_hit(1);
		//�׽�Ʈ�� userid. location ����
		dto.setUserid("TestID");
		dto.setLocation("TestLocation");
		Date date = new Date();
		DateFormat sdFormat = new SimpleDateFormat("yy/MM/dd");				
		String writedate = sdFormat.format(date);		
		
		//�۵�Ͻ����ϸ� ���ܹ߻�
		String htmlTag="<script>";
		try {
			int result = service.offlineInsert(dto);
			htmlTag += "location.href='/home/offline/offline_board';";
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
		System.out.println(dto.toString());
		//                        ����
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);	
		
	}
	@GetMapping("/boardView")
	public ModelAndView boardView() {
		//��ȸ������
		//service.boardHitCount(no);
		//BoardDTO dto = service.boardSelect(no);
		
		ModelAndView mav = new ModelAndView();		
		
		//mav.addObject("dto", dto); //������ ���ڵ�
		//mav.addObject("vo", vo); // ��������ȣ, �˻���, �˻�Ű
		
		mav.setViewName("board/boardView");
		return mav;
	}
	
}
