package com.t09ether.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.service.MyPageService;

@RestController
@RequestMapping("/mypage")
public class MyPageController {
	@Autowired
	MyPageService service;
	
	@GetMapping("/myPage")
	public ModelAndView myPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/myPage");
		
		return mav;		
	}
	
	@GetMapping("/myOrder")
	public ModelAndView myOrder() {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("mypage/myOrder");
	
	return mav;
	}
	
	@GetMapping("/myPost")
	public ModelAndView myPost() {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("mypage/myPost");
	
	return mav;
	}
	
	@GetMapping("/myPersInfo")
	public ModelAndView myPersInfo() {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("mypage/myPersInfo");
	
	return mav;
	}
	
	/*@Autowired
	온라인공동구매Service service;
	
	
	
	*/
	
	
}
