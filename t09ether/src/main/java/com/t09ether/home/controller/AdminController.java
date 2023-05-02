package com.t09ether.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.AdReportPagingVO;
import com.t09ether.home.dto.AdUserPagingVO;
import com.t09ether.home.dto.CustomerCenterDTO;
import com.t09ether.home.dto.CustomerCenterPagingVO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.dto.ReplyDTO;
import com.t09ether.home.dto.ReportDTO;
import com.t09ether.home.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@GetMapping("/adminMain")
	public ModelAndView adminMain(RegisterDTO dto) {
		ModelAndView mav = new ModelAndView();
		List<RegisterDTO> list = service.userSelect();
		
		mav.addObject("list", list);
		mav.setViewName("admin/adminMain");
		return mav;
	}
	
	@GetMapping("/faqlistAdmin")
	public ModelAndView faqlist(int cus_b_num, CustomerCenterDTO ccdto, CustomerCenterPagingVO vo) {
		
		ModelAndView mav = new ModelAndView();
		
		ccdto = service.csBoardSelect(cus_b_num);
		mav.addObject("CustomerCenterDTO",ccdto);
		mav.addObject("vo",vo);
		mav.setViewName("admin/faqlistAdmin");

		return mav;
		
	}
	
	@GetMapping("/adUser")
	public ModelAndView adUser(AdUserPagingVO vo) {
		
		ModelAndView mav = new ModelAndView();
		
		vo.setTotalRecord(service.totalRecord(vo));
		//System.out.println(vo.toString());
		
		List<RegisterDTO> list = service.pageSelect(vo);
		//System.out.println(list);
		
		mav.addObject("vo",vo);
		mav.addObject("list", list);
		mav.setViewName("admin/adUser");
		return mav;
	}
	
	@GetMapping("/adReport")
	public ModelAndView adReport(AdReportPagingVO vo) {
		
		ModelAndView mav = new ModelAndView();
		
		vo.setTotalRecord(service.rpTotalRecord(vo));
		//System.out.println(vo.toString());
		
		List<ReportDTO> list = service.reportPageSelect(vo);
		//System.out.println(list);
		
		mav.addObject("vo",vo);
		mav.addObject("list", list);
		mav.setViewName("admin/adReport");
		return mav;
	}
	
	
	@GetMapping("/adStat")
	public ModelAndView adStat() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adStat");
		return mav;
	}
	
	@GetMapping("/adQna")
	public ModelAndView adQna(CustomerCenterPagingVO vo) {
		ModelAndView mav = new ModelAndView();
		
		vo.setTotalRecord(service.csTotalRecord(vo));
		
		List<CustomerCenterDTO> list = service.csPageSelect(vo);
		
		mav.addObject("vo",vo);
		mav.addObject("list",list);
		mav.setViewName("admin/adQna");
		return mav;
	}
	
	@GetMapping("/adProduct")
	public ModelAndView adProduct() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adProduct");
		return mav;
	}
	
	@GetMapping("/adBoard")
	public ModelAndView adBoard() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adBoard");
		return mav;
	}
	
	
}
