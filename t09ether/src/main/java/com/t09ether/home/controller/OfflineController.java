package com.t09ether.home.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
	
	//게시판목록
	@GetMapping("/offline")
	public ModelAndView offline(OfflinePagingVO vo) {
		ModelAndView mav = new ModelAndView();				
		vo.setTotalRecord(service.totalRecord(vo)); //총레코드수
		System.out.println("totalRecord="+vo.getTotalRecord() );
		List<OfflineDTO> list = new ArrayList<OfflineDTO>();
		list = service.offList(vo);
		System.out.println("list->"+list.toArray());
		mav.addObject("list", service.offList(vo));		
		mav.addObject("vo", vo);
		mav.setViewName("offline/offline_board");
		return mav;
	}
	
	//글작성폼으로이동
	@GetMapping("/offlineWrite")
	public ModelAndView offlineWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("offline/offlineWrite");
		return mav;
	}
	
	//글등록(DB)
	@PostMapping("/offlineInsert")	
	public ResponseEntity<String> offlineInsert(OfflineDTO dto,HttpServletRequest request) {
		//dto.setIp(request.getRemoteAddr());//ip
		dto.setUserid((String)request.getSession().getAttribute("logId"));//로그인한 아이디 구하기
		dto.setCurrent_num(1);
		dto.setOff_hit(1);				
		
		String htmlTag="<script>";
		try {
			int result = service.offlineInsert(dto);
			htmlTag += "location.href='offline';";
		}catch(Exception e) {
			e.printStackTrace();
			htmlTag += "alert('글이등록되지않았습니다.');";
			htmlTag += "history.back();";
		}
		htmlTag += "</script>";
		//결과
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		System.out.println(dto.toString());
		System.out.println("여기까진 실행됨.....");
		//                        내용
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);	
		
	}
	
	//글내용보기
	@GetMapping("/offlineView")
	public ModelAndView boardView(int no, OfflinePagingVO vo) {
		//조회수증가
		//service.boardHitCount(no);
		OfflineDTO dto = service.offlineSelect(no);
		
		ModelAndView mav = new ModelAndView();		
		
		//mav.addObject("dto", dto); //선택한레코드
		mav.addObject("vo", vo); // 페이지번호, 검색어, 검색키
		
		mav.setViewName("offline/offlineView");
		return mav;
	}
	
}
