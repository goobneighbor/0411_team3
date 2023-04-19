package com.t09ether.home.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.t09ether.home.dto.OfflineParticipantDTO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.service.OfflineService;

@RestController
public class OfflineController {
	@Autowired
	OfflineService service;
	
	//게시판목록
	@GetMapping("/offline")
	public ModelAndView offline(OfflinePagingVO vo) {		
		ModelAndView mav = new ModelAndView();			
		//총레코드수
		vo.setTotalRecord(service.totalRecord(vo));
		
		List<OfflineDTO> list = new ArrayList<OfflineDTO>();
		list = service.offList(vo);
		
		//해당페이지 레코드 선택하기
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
	public ModelAndView boardView(int off_no, OfflinePagingVO vo) {
		//조회수증가
		service.offlineHitCount(off_no);
		OfflineDTO dto = service.offlineSelect(off_no);
		
		ModelAndView mav = new ModelAndView();		
		
		mav.addObject("dto", dto); //선택한레코드
		mav.addObject("vo", vo); // 페이지번호, 검색어, 검색키
		
		mav.setViewName("offline/offlineView");
		return mav;
	}
	//수정폼으로 이동
	@GetMapping("/offlineEdit")
	public ModelAndView boardEdit(int off_no, OfflinePagingVO vo) {
		OfflineDTO dto = service.offlineEditSelect(off_no);
			
		String subject = dto.getOff_subject().replaceAll("\"", "&quot;");
		subject.replaceAll("'", "&#39;");
		System.out.println(subject);
		dto.setOff_subject(subject);
		ModelAndView mav = new ModelAndView();
			
		mav.addObject("dto", dto);
		mav.addObject("vo", vo);
			
		mav.setViewName("offline/offlineEdit");
			
		return mav;
		}	
	
	//글수정(DB등록)
	@PostMapping("/offlineEditOk")
	public ResponseEntity<String> offlineEditOk(OfflineDTO dto, OfflinePagingVO vo, HttpSession session) {
		
		// no(레코드번호), 로그인 아이디가 같을 때 업데이트
		dto.setUserid((String)session.getAttribute("logId"));
		System.out.println(dto.getUserid());
		String bodyTag= "<script>";
		try {
			service.offlineUpdate(dto);
			bodyTag += "location.href='offlineView?off_no=" + dto.getOff_no()+ "&nowPage=" + vo.getNowPage();
			if(vo.getSearchWord()!= null) {
				bodyTag += "&searchKey=" + vo.getSearchKey() + "&searchWord=" + vo.getSearchWord();
			}
			bodyTag += "';";
			System.out.println(bodyTag);
		}catch(Exception e) {			
			//수정실패			
			bodyTag +="alert('게시판 글수정 실패하였습니다');";
			bodyTag +="history.back();";
			System.out.println(bodyTag);
			e.printStackTrace();
		}
		bodyTag += "</script>";
		System.out.println(bodyTag);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		ResponseEntity<String> entity = new ResponseEntity<String>(bodyTag,headers,HttpStatus.OK);
		
		return entity;
	}	
	//삭제
	@GetMapping("/offlineDel")
	public ModelAndView offlineDel(OfflineDTO dto, OfflinePagingVO vo, HttpSession session) {
		dto.setUserid((String)session.getAttribute("logId"));
			
		int result = service.offlineDelete(dto);
			
		ModelAndView mav = new ModelAndView();
			
		mav.addObject("nowPage", vo.getNowPage());
			if(vo.getSearchWord()!=null) {
				mav.addObject("searchKey", vo.getSearchKey());
				mav.addObject("searchWord", vo.getSearchWord());
			}
			if(result>0) {//삭제시 리스트로 이동
				mav.setViewName("redirect:offline");
				System.out.println("삭제 성공...!");
			}else {//삭제실패시 글내용보기로 이동
				mav.addObject("off_no", dto.getOff_no());
				mav.setViewName("redirect:offlineView");
			}
			return mav;
		}
	
	//오프라인공구 참가 -> 참여자 한명의 정보(RegisterDTO)를 OfflineParticipantDTO에 담기
	@PostMapping("/offlineJoin")
	public ModelAndView offlineJoin(OfflineDTO dto, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String userid = ((String)request.getSession().getAttribute("logId")); //로그인한 아이디구하기
		System.out.println("userid->"+userid);
		
		
		
		mav.addObject("dto", dto);//원글정보
		//mav.addObject("list", list);//참여자정보
		mav.setViewName("offline/offlineDetail");
		return mav;
	}
	
}
