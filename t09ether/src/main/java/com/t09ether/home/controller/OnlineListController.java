package com.t09ether.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class OnlineListController {
	
	@GetMapping("online/onlineHome")
	public ModelAndView online() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("online/onlineList");
		return mav;
	}
}
