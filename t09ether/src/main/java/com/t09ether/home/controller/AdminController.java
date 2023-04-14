package com.t09ether.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/adminIn")
	public ModelAndView adminIn() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/productIn");
		return mav;
	}
}
