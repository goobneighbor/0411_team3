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
	
	//오프라인공구 게시판목록
	@GetMapping("/offline")
	public ModelAndView offline(OfflinePagingVO vo) {
		ModelAndView mav = new ModelAndView();		
		
		vo.setTotalRecord(service.totalRecord(vo));//총레코드수 세팅 
		System.out.println(vo.getTotalRecord());
		mav.addObject("offDTO", service.offList(vo));
		mav.addObject("vo", vo);//뷰페이지로 페이지 정보 세팅
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
		//dto.setUserid((String)request.getSession().getAttribute("logId"));//로그인한 아이디 구하기
		dto.setCurrent_num(1);//현재인원 1명 초기화
		dto.setOff_hit(1);
		//테스트용 userid. location 세팅
		dto.setUserid("TestID");
		dto.setLocation("TestLocation");
		Date date = new Date();
		DateFormat sdFormat = new SimpleDateFormat("yy/MM/dd");				
		String writedate = sdFormat.format(date);		
		
		//글등록실패하면 예외발생
		String htmlTag="<script>";
		try {
			int result = service.offlineInsert(dto);
			htmlTag += "location.href='/home/offline/offline_board';";
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
		System.out.println(dto.toString());
		//                        내용
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);	
		
	}
	@GetMapping("/boardView")
	public ModelAndView boardView() {
		//조회수증가
		//service.boardHitCount(no);
		//BoardDTO dto = service.boardSelect(no);
		
		ModelAndView mav = new ModelAndView();		
		
		//mav.addObject("dto", dto); //선택한 레코드
		//mav.addObject("vo", vo); // 페이지번호, 검색어, 검색키
		
		mav.setViewName("board/boardView");
		return mav;
	}
	
}
