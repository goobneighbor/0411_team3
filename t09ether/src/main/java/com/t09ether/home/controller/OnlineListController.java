package com.t09ether.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/onlineGB")
	public ModelAndView onlineGB() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("online/onlineGB");
		return mav;
	}
}
