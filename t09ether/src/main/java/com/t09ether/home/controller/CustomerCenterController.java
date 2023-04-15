package com.t09ether.home.controller;

import java.lang.System.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.service.CustomerCenterService;
import com.t09ether.home.service.CustomerCenterServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerCenterController {
	
	@Autowired
	CustomerCenterService service;
	
	@GetMapping("/customerBoard")
	public ModelAndView customerBoard() {
		ModelAndView mav = new ModelAndView();
		
		List<CustomerCenterDTO> list = service.boardList();
		System.out.println("list출력:"+list.toString());
		mav.addObject("list",list);
		mav.setViewName("customer/customerBoard");
		
		return mav;
	}

	
	
	
	
}
