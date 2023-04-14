package com.t09ether.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/online")
public class OrderController {

	@GetMapping("/orderForm")
	public ModelAndView orderForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("online/orderForm");
		return mav;
	}
}
