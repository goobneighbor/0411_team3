package com.t09ether.home.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.OnlineDTO;
import com.t09ether.home.dto.ProductDTO;
import com.t09ether.home.service.OnlineListService;



@RestController
@RequestMapping("/online")
public class OnlineListController {
	@Autowired
	OnlineListService service;
	
	

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
