package com.t09ether.home.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dao.RegisterDAO;
import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.dto.CustomerCenterPagingVO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.service.CustomerCenterService;
import com.t09ether.home.service.CustomerCenterServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerCenterController {
	
	@Autowired
	CustomerCenterService service;
	
	@GetMapping("/customerBoard")
	public ModelAndView customerBoard(CustomerCenterPagingVO vo) {
		ModelAndView mav = new ModelAndView();
		
		//userid = session.getAttribute(null);
		//String rank = service.bringRank(userid);
		//System.out.println("rank: "+ rank);
		
		// 게시판 글 리스트 전체 목록 보여주기
		
		//페이징
		vo.setTotalRecord(service.totalRecord(vo));
		mav.addObject("list",service.pageSelect(vo));
		mav.addObject("vo",vo);
		mav.setViewName("customer/customerBoard");
		
		return mav;
	}
	
	@GetMapping("/csBoardWrite")
	public ModelAndView csBoardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customer/csBoardWrite");
		
		return mav;
	}
	
	@PostMapping("/csBoardWriteOk")
	public ResponseEntity<String> csBoardInsert(CustomerCenterDTO cdto, HttpServletRequest request) {
		cdto.setUserid((String)request.getSession().getAttribute("logId"));
		
		String htmlTag = "<script>";
		
		// 예외발생시 처리
		try {
			int result = service.csBoardInsert(cdto);
			//service.csBoardInsert(cdto);
			htmlTag += "location.href='/home/customer/customerBoard';";
		
		}catch(Exception e) {
			htmlTag += "alert('Q&A 문의글을 등록하는데 실패했습니다');";
			htmlTag += "history.back();";
			e.printStackTrace();
		}
		htmlTag += "</script>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);
		
	}
	
	@GetMapping("/csBoardEdit")
	public ModelAndView boardEdit(CustomerCenterDTO cdto, int cus_b_num, CustomerCenterPagingVO vo) {
		cdto = service.csBoardEditSelect(cus_b_num);
		
		//"   "    '     ' 내용에 따옴표가 있으면
		String subject = cdto.getSubject().replaceAll("\"", "&quot;");	// "  \"
		subject.replaceAll("'", "&#39;");
		//System.out.println(subject);
		cdto.setSubject(subject);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cdto", cdto);
		mav.addObject("vo", vo);
		
		mav.setViewName("customer/csBoardEdit");
		
		return mav;
		
	}

	@GetMapping("/faqlist")
	public ModelAndView boardView(int cus_b_num, CustomerCenterDTO ccdto, CustomerCenterPagingVO vo) {
		
		ModelAndView mav = new ModelAndView();
		
		ccdto = service.boardView(cus_b_num);
		mav.addObject("CustomerCenterDTO",ccdto);
		mav.addObject("vo",vo);
		mav.setViewName("customer/faqlist");

		return mav;
		
	}
}
