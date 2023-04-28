package com.t09ether.home.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.OnlineReviewDTO;
import com.t09ether.home.dto.ProductDTO;
import com.t09ether.home.service.OnlineJoinService;
import com.t09ether.home.service.OnlineReviewService;

@RestController
@RequestMapping("/online")
public class OnlineReviewController {

	@Autowired
	OnlineReviewService service;
	
	@Autowired
	OnlineJoinService joinservice;
	
	@GetMapping("/onlineReview")
	public ModelAndView onlineReview(int pro_code) {
		ModelAndView mav = new ModelAndView();
		ProductDTO dto = joinservice.proInfor(pro_code);
		
		Map rating = new HashMap();
		rating.put(0, "☆☆☆☆☆");
		rating.put(1, "★☆☆☆☆");
		rating.put(2, "★★☆☆☆");
		rating.put(3, "★★★☆☆");
		rating.put(4, "★★★★☆");
		rating.put(5, "★★★★★");
		
		List<OnlineReviewDTO> list = service.selectReview(pro_code);
		
	
		//리뷰수 평균
		//double rateAvg = service.rateAvg(pro_code);
		//rateAvg =  rateAvg/5*100;
		
		//물품을 구매한 userid select
		List<String> userList = service.userList(pro_code);
		
		mav.addObject("userList",userList);
		//mav.addObject("rateAvg", rateAvg);
		mav.addObject("list", list);
		mav.addObject("rating", rating);
		mav.addObject("dto", dto);
		mav.setViewName("online/onlineReview");
		
		return mav;
		
	}
}
