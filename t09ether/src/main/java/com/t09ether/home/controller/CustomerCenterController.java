package com.t09ether.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dao.RegisterDAO;
import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.dto.RegisterDTO;
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
		
		
		// 게시판 글 리스트 전체 목록 보여주기
		List<CustomerCenterDTO> list = service.boardList();
		
		//System.out.println("list출력:"+list.toString());
		mav.addObject("list",list);
		mav.setViewName("customer/customerBoard");
		
		
		return mav;
	}

	@GetMapping("/faqlist")
	public ModelAndView boardView(int cus_b_num, CustomerCenterDTO ccdto) {
		
		ModelAndView mav = new ModelAndView();
		
		ccdto = service.boardView(cus_b_num);
		mav.addObject("CustomerCenterDTO",ccdto);
		mav.setViewName("customer/faqlist");


		return mav;
		
	}
}
