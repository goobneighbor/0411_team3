package com.t09ether.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/online")
public class OnlineListController {
	
	@GetMapping("/onlineHome")
	public ModelAndView online() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("online/onlineList");
		return mav;
	}
	
	@GetMapping("/productDetail")
	public ModelAndView productDetail() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("online/productDetail");
		return mav;
	}
	@GetMapping("/onlineJoinForm") 
 	public ModelAndView onlineJoin() {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("online/onlineJoinForm"); 
		return mav; 
		}
	@GetMapping("/kakaomap")
	public ModelAndView googlemap() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("online/kakaomap");
		return mav;
	}
}
