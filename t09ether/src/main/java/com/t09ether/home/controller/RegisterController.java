package com.t09ether.home.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.service.RegisterService;

@Controller
public class RegisterController {

	
	@Autowired
	RegisterService service;
	
	// 로그인 폼으로 이동
	@GetMapping("/loginForm")
	public String login() {
		return "register/loginForm";
	}
	
	// DB로그인
	
	@PostMapping("loginOk")
	public ModelAndView loginOk(String userid, String userpwd, HttpServletRequest request, HttpSession session) {
		RegisterDTO dto = service.loginOk(userid, userpwd);
		
		ModelAndView mav = new ModelAndView();

		if(dto!=null && dto.getReport()<6) { //성공
			int rank = service.rankSelect(dto.getUserid());
			session.setAttribute("logId", dto.getUserid());
			session.setAttribute("logName", dto.getUsername());
			session.setAttribute("logStatus", "Y");
			session.setAttribute("logRank", rank);
			
			//나오는지 확인 후 삭제해야 합니다! 잘나오는데 왜 안돼.................................
			//System.out.println("logId: "+dto.getUserid());
			//System.out.println("logName: "+dto.getUsername());
			//String tempo = (String)session.getAttribute("logStatus");
			//System.out.println("logStatus: "+tempo);
			//System.out.println("register rank: "+dto.getRank());
			
			mav.setViewName("redirect:/");
			
		}else if(dto==null) { //실패
			mav.addObject("msg", "존재하지 않는 아이디거나, 비밀번호 오류입니다.");
			mav.setViewName("register/loginAlert");
		}else if(dto.getReport()>=6) {
			mav.addObject("msg", "신고 누적으로 인해 계정이 일시 정지되었습니다.");
			mav.setViewName("register/acBlockAlert");
		}
		return mav;
	}
	
	@RequestMapping("/kakaoLogin") 
		public String home(@RequestParam(value="code", required = false)String code) throws Exception {
			System.out.println("#####"+code);
			return "/";
		}
	
	
	//로그아웃 -세션제거
		@RequestMapping("/logout")
		public ModelAndView logout(HttpSession session) {
			session.invalidate();
			ModelAndView mav= new ModelAndView();
			mav.setViewName("redirect:/");
			return mav;
		}

		//회원가입 폼
		@GetMapping("/join")
		public String join() {
			return "register/join";	
		}
		
		//아이디 중복검사
		@GetMapping("/idCheck")
		public String idCheck(String userid, Model model) {
			//조회
			int result = service.idCheckCount(userid);
			
			//뷰에서 사용하기 위해 모델 세팅
			model.addAttribute("userid",userid);
			model.addAttribute("result",result);
			return "register/idCheck";
		}

		// 회원 가입하고 처리하기
		@RequestMapping(value="/joinOk", method=RequestMethod.POST)
		public ModelAndView joinOk(RegisterDTO dto) {
			System.out.println(dto.toString());
			
			ModelAndView mav = new ModelAndView();
			//회원 가입
			int result = service.registerInsert(dto);
			
			//회원가입 성공 시 - 로그인폼으로 보내기
			if(result==1) {
				mav.setViewName("redirect:loginForm");
				
			//회원가입 실패 시 - 다시쓰게하기
			}else {
				mav.addObject("msg", "회원등록하는데 실패했습니다.");
				mav.setViewName("register/joinOkResult");
			}
			return mav;
			
		}
		
		//회원정보 수정 폼 - session 로그인 아이디에 해당하는 회원정보를 select하여 뷰페이지로 이동
		@GetMapping("/joinEdit")
		public ModelAndView joinEdit(HttpSession session) { //request->session, session
			RegisterDTO dto = service.registerEdit((String)session.getAttribute("logId"));
			
			ModelAndView mav = new ModelAndView();
			
			mav.addObject("dto", dto);
			mav.setViewName("/register/joinEdit");
			
			return mav;
		}	
		//회원정보 수정 DB - form의 내용과 session의 로그인 아이디 회원정보를 수정한다.
		@PostMapping("/joinEditOk")
		public ModelAndView joinEditOk(RegisterDTO dto, HttpSession session) {
			dto.setUserid((String)session.getAttribute("logId"));
			
			int cnt = service.registerEditOk(dto);
			ModelAndView mav = new ModelAndView();
			
			if(cnt>0) {//수정 성공 시 ->db에서 수정된 내용을 보여주고
				mav.setViewName("redirect:joinEdit");
			}else {//수정 실패 시 -> 이전페이지 (알림)
				mav.addObject("msg", "회원정보를 수정하는데 실패했습니다.");
				mav.setViewName("register/joinOkResult");
			}
			return mav;
		}
		
}	
