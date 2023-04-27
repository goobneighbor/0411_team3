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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.OfflineCommentDTO;
import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.dto.OfflinePagingVO;
import com.t09ether.home.dto.OfflineParticipantDTO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.service.OfflineCommentService;
import com.t09ether.home.service.OfflineService;

@RestController
public class OfflineController {
	@Autowired
	OfflineService service;
	@Autowired
	OfflineCommentService commentService;
	//게시판목록
	@GetMapping("/offline")
	public ModelAndView offline(OfflinePagingVO vo) {		
		ModelAndView mav = new ModelAndView();			
		//총레코드수
		vo.setTotalRecord(service.totalRecord(vo));
		
		List<OfflineDTO> list = new ArrayList<OfflineDTO>();
		list = service.offList(vo);
		
		//해당페이지 레코드 선택하기
		mav.addObject("list", list);		
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
	public ResponseEntity<String> offlineInsert(@RequestParam("off_subject")String off_subject,
												@RequestParam("off_content")String off_content,
												@RequestParam("location")String location,
												@RequestParam("group_num")int group_num,
												@RequestParam("deaddate")String deaddate,
												@RequestParam("app_time")String app_time,
												HttpServletRequest request) {
		
		//dto.setIp(request.getRemoteAddr());//ip
		String userid = (String)request.getSession().getAttribute("logId");
		OfflineDTO dto = new OfflineDTO();
		
		dto.setUserid((userid));//로그인한 아이디 구하기
		dto.setOff_subject(off_subject);
		dto.setOff_content(off_content);
		dto.setLocation(location);
		dto.setGroup_num(group_num);
		dto.setCurrent_num(1);
		dto.setDeaddate(deaddate);
		dto.setApp_time(app_time);
		dto.setOff_hit(1);			
		
		
		String htmlTag="<script>";
		try {
			int result = service.offlineInsert(dto);//DB등록
			htmlTag += "location.href='offline';";
		}catch(Exception e) {
			e.printStackTrace();
			htmlTag += "alert('글이등록되지않았습니다.');";
			htmlTag += "history.back();";
		}
		htmlTag += "</script>";
		
		
		//글등록성공하면 자동으로 off_participant에 추가
		OfflineParticipantDTO opDTO = new OfflineParticipantDTO();		
		//userid를 이용해 참가하는 회원의 정보를 가져와
		RegisterDTO rDTO = service.getParticipant(userid);  
		//DB의 offline_participant테이블에 insert한다
		opDTO.setOff_no(dto.getOff_no());
		opDTO.setUserid(userid);
		opDTO.setUsername(rDTO.getUsername());
		opDTO.setTel(rDTO.getTel());
		
		service.participantInsert(opDTO);
		System.out.println("원글번호(dto.off_no)="+dto.getOff_no());
		System.out.println("글작성자->offline_participant에 등록완료");
		System.out.println("작성자정보 : "+opDTO.toString());
		//결과
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		System.out.println(dto.toString());		
		
		
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);	
		
	}
	
	//글내용보기
	@GetMapping("/offlineView")
	public ModelAndView boardView(int off_no, OfflinePagingVO vo) {
		//조회수증가
		service.offlineHitCount(off_no);
		//해당글(off_no)담기
		OfflineDTO dto = service.offlineSelect(off_no);
		dto.setCurrent_num(service.currentNumCount(off_no));
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
	
	
	//오프라인 공구 참여 
	// 마감X-> 오프라인공구 상세페이지로
	// 마감O -> 마감 페이지로
	@PostMapping("/offlineJoin")
	public ModelAndView offlineJoin(int off_no, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		OfflineDTO dto = service.offlineSelect(off_no);	
		String userid = (String)request.getSession().getAttribute("logId");
		
		List<OfflineParticipantDTO> list=service.participantList(off_no);
		OfflineParticipantDTO opDTO = new OfflineParticipantDTO();
		//userid를 이용해 참가하는 회원의 정보를 가져오기
		RegisterDTO rDTO = service.getParticipant(userid);
		opDTO.setOff_no(off_no);
		opDTO.setUserid(userid);
		opDTO.setUsername(rDTO.getUsername());
		opDTO.setTel(rDTO.getTel());
		System.out.println("opDTO->"+opDTO.toString());
		
		List<String> idList = service.getIds(off_no);
		if(idList.contains(userid)) {//이미 참여한 사람이면 따로 등록 X
			System.out.println("이미 등록된 회원");
		}else { //등록되어있지 않은 사람인 경우
			//DB의 offline_participant테이블에 insert한다
			service.participantInsert(opDTO);
		}
		dto.setCurrent_num(service.currentNumCount(off_no));
		System.out.println(off_no+"번 공동구매 참여인원 : "+dto.getCurrent_num()+"명");
		RegisterDTO firstDTO = service.getParticipant(dto.getUserid());//방장의 정보
		
		mav.addObject("firstDTO", firstDTO);//방장정보
		mav.addObject("list", list);// 공구참여자정보 List<OfflineParticipantDTO>
		mav.addObject("dto", dto); //원글정보
		mav.setViewName("/offline/offlineDetail");
		
		return mav;
	}
	
	
	
	//오프라인공구마감(방장이 마감하기 클릭)
	@GetMapping("/offlineClose")
	public ModelAndView offlineClose(int off_no) {
		ModelAndView mav = new ModelAndView();
		OfflineDTO dto = service.offlineSelect(off_no);
		List<OfflineParticipantDTO> list=service.participantList(off_no);
		
		service.offlineClose(off_no);//status변경(마감)
		mav.addObject("list", list);
		mav.addObject("dto", dto);
		mav.setViewName("/offline/offlineClose");
		return mav;
	}
	
	//일정조율페이지로 넘어가기(댓글)
	@GetMapping("/offlineComment")
	public ModelAndView offlineComment(int off_no) {
		ModelAndView mav = new ModelAndView();
		OfflineDTO dto = service.offlineSelect(off_no);	
		
		mav.addObject("dto", dto);//원글정보
		mav.setViewName("/offline/offlineComment");
		return mav;
	}
	
	//============================리뷰========================//
	//참가자리뷰페이지 넘어가기(
	//참여자 한명에 대한 리뷰버튼 클릭 => 해당 참여자에 대한 리뷰 등록할 수 있는 글쓰기 폼으로 이동	
	@PostMapping("/offlineReview")
	public ModelAndView offlineReview(String userid, int off_no, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		// userid : 리뷰당하는(?) 사람의 아이디(DB-칭찬대상)
		// writer : 리뷰작성하는 사람의 아이디
		String writer = (String)request.getSession().getAttribute("logId");
		System.out.println("칭찬대상->"+userid);
		System.out.println("리뷰작성자->"+writer);
		mav.addObject("userid", userid);
		mav.addObject("writer", writer);
		mav.setViewName("/offline/offlineReviewWrite");
		return mav;
	}
	//============================리뷰========================//
	
	
	//*******************댓글******************//	
	//댓글목록보여주기
	@ResponseBody
	@GetMapping("/commentList")
	public List<OfflineCommentDTO> commentList(int off_no){
		List<OfflineCommentDTO> list = commentService.commentListSelect(off_no);
		
		return list;
	}
	
	//댓글등록하기
	@PostMapping("/commentSend")
	public String commentSend(OfflineCommentDTO dto, HttpServletRequest request) {
		dto.setUserid((String)request.getSession().getAttribute("logId"));
		System.out.println(dto.toString());
		int result=commentService.commentInsert(dto);
		return result+"";
	}
	
	
	//댓글수정하기
	@PostMapping("/commentEdit")
	public String commentEdit(OfflineCommentDTO dto, HttpSession session) {
		dto.setUserid((String)session.getAttribute("logId"));
		int result = commentService.commentUpdate(dto);
		return String.valueOf(result);
	}
	//댓글삭제하기
	@GetMapping("/commentDelete")
	public String commentDelete(int comment_no, HttpSession session) {
		String userid = (String)session.getAttribute("logId");
		return String.valueOf(commentService.commentDelete(comment_no, userid));
	}
	
	
	
	
}
