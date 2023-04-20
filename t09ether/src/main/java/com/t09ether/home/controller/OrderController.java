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
	
	@GetMapping("/orderForm")
	public ModelAndView orderForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("online/orderForm");
		return mav;
	}
	
}
