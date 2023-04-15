package com.t09ether.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.MyPageDTO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.service.MyPageService;
import com.t09ether.home.service.RegisterService;

@RestController
@RequestMapping("/mypage")
public class MyPageController {
	@Autowired
	MyPageService service;
	
	@GetMapping("/myPage")
	public ModelAndView myPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/myPage");
		
		return mav;		
	}
	
	@GetMapping("/myOrder")
	public ModelAndView myOrder() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/myOrder");
		
		return mav;
	}
	
	@GetMapping("/myPost")
	public ModelAndView myPost() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/myPost");
		
		return mav;
	}
	
	@GetMapping("/myPersInfo")
	public ModelAndView myPersInfo() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/myPersInfo");
		
		return mav;
	}
	
	@GetMapping("/myPersInfo_IdChk")
		public ModelAndView myPersInfo_IdChk() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/myPersInfo_IdChk");
		
		return mav;
	}
	
	@PostMapping("loginOk")
	public ModelAndView loginOk(String userid, String userpwd, HttpServletRequest request, HttpSession session) {
		MyPageDTO dto = service.loginOk(userid, userpwd);
		
		ModelAndView mav = new ModelAndView();
		if(dto!=null) { //성공
			session.setAttribute("logId", dto.getUserid());
			session.setAttribute("logName", dto.getUsername());
			session.setAttribute("logStatus", "Y");
			
			//나오는지 확인 후 삭제해야 합니다! 잘나오는데 왜 안돼.................................
			System.out.println("logId: "+dto.getUserid());
			System.out.println("logName: "+dto.getUsername());
			String tempo = (String)session.getAttribute("logStatus");
			System.out.println("logStatus: "+tempo);
			
			mav.setViewName("redirect:myPersInfo");
			
		}else { //실패
			mav.setViewName("redirect:myPersInfo_IdChk");
		}
		return mav;
	}
	
	
	/*@Autowired
	�¶��ΰ�������Service service;
	
	*/
	
}
