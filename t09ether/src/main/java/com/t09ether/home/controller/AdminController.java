package com.t09ether.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@GetMapping("/adminMain")
	public ModelAndView adminMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adminMain");
		return mav;
	}
	
	@GetMapping("/adUser")
	public ModelAndView adUser() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adUser");
		return mav;
	}
	
	@GetMapping("/adReport")
	public ModelAndView adReport() {
		ModelAndView mav = new ModelAndView();
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
	public ModelAndView adQna() {
		ModelAndView mav = new ModelAndView();
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
