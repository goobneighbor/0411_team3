package com.t09ether.home.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.OnlineDTO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService service;
	

//	@PostMapping("/paytestInfo")
//	public ResponseEntity<String> payTest(OrderDTO dto, OnlineDTO odto, HttpSession session) {
//		ResponseEntity<String> entity = null;
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "text/html; charset=utf-8");
//		System.out.println((String)session.getAttribute("logId"));
//		dto.setUserid((String)session.getAttribute("logId"));
//		odto.setUserid((String)session.getAttribute("logId"));
//		//dto.setRest_count(dto.getRest_count()- dto.getOrd_count()); -> update문 메소드
//		System.out.println(dto.toString());
//		System.out.println(odto.toString());
//		
//		//상품등록 실패하면 예외발생
//		try {
//			service.orderInsert(dto);
//			service.onlineInsert(odto);
//			//service.orderSelect(dto.getPro_code());
//			String htmlTag = "<script>location.href='/home/online/payRes';</script>";
//			entity = new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			String htmlTag = "<script>"; 
//			htmlTag += "alert('상품이 등록되지 않았습니다.');";
//			htmlTag += "history.back();";
//			htmlTag += "</script>";
//			entity = new ResponseEntity<String>(htmlTag, headers, HttpStatus.BAD_REQUEST);
//		}
//		return entity; 
//		
//	}

	
	@PostMapping("/paytestInfo")
	public ModelAndView payTest(OrderDTO dto, OnlineDTO odto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//ResponseEntity<String> entity = null;
		//HttpHeaders headers = new HttpHeaders();
		//headers.add("Content-Type", "text/html; charset=utf-8");

		System.out.println((String)session.getAttribute("logId"));
		dto.setUserid((String)session.getAttribute("logId"));
		odto.setUserid((String)session.getAttribute("logId"));
		//dto.setRest_count(dto.getRest_count()- dto.getOrd_count()); -> update문 메소드
		System.out.println(dto.toString());
		System.out.println(odto.toString());
		int pro_code = dto.getPro_code();
		String userid = dto.getUserid();
		
		
		//상품등록 실패하면 예외발생
		try {
			service.onlineInsert(odto);
			int on_no = odto.getOn_no() - 1;
			System.out.println(on_no);
			dto.setOn_no(on_no);
			service.orderInsert(dto);
			
			OrderDTO sdto = service.orderSelect(pro_code, on_no, userid);
			mav.addObject("sdto", sdto);
			mav.setViewName("online/payRes");
			//service.orderSelect(dto.getPro_code());
			//String htmlTag = "<script>location.href='/home/online/payRes';</script>";
			//entity = new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			//String htmlTag = "<script>"; 
			//htmlTag += "alert('상품이 등록되지 않았습니다.');";
			//htmlTag += "history.back();";
			//htmlTag += "</script>";
			//entity = new ResponseEntity<String>(htmlTag, headers, HttpStatus.BAD_REQUEST);
		}
		return mav; 
		
	}
}
