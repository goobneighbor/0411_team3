package com.t09ether.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.AdminOrderPagingVO;
import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.MyPageDTO;
import com.t09ether.home.dto.OffPartDTO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.service.MyPageService;

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
	public ModelAndView myOrder(AdminPagingVO vo, AdminOrderPagingVO vo2,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String userid = (String)session.getAttribute("logId");
		vo.setTotalRecord(service.totalOrdRecord(vo,vo.getSearchKey(), vo.getSearchWord(),userid));
		vo2.setTotalRecord(service.totalOrdSucRecord(vo2, vo2.getSearchKey2(), vo2.getSearchWord2(), userid));
		//System.out.println(vo.toString());
		
		List<OrderDTO> list = service.pageOrdSelect(vo, vo.getTotalPage(), vo.getSearchKey(), vo.getSearchWord(), userid, vo.getNowPage(), vo.getLastPageRecord(), vo.getOnePageRecord());
		List<OrderDTO> list2 = service.pageOrdSucSelect(vo2, vo2.getTotalPage2(), vo2.getSearchKey2(), vo2.getSearchWord2(), userid, vo2.getNowPage2(), vo2.getLastPageRecord2(), vo2.getOnePageRecord2());
		//System.out.println(list);
		
		mav.addObject("vo", vo);
		mav.addObject("vo2", vo2);
		mav.addObject("list", list);
		mav.addObject("list2",list2);
		mav.setViewName("mypage/myOrder");
		return mav;
	}
	
	
	@GetMapping("/myPost")
	public ModelAndView myPost(AdminPagingVO vo) {
		ModelAndView mav = new ModelAndView();
		
		vo.setTotalRecord(service.totalRecord(vo));
		//System.out.println(vo.toString());
		
		List<OffPartDTO> list = service.offPageSelect(vo);
		//System.out.println(list);
		
		mav.addObject("vo", vo);
		mav.addObject("list", list);	
		mav.setViewName("mypage/myPost");
		return mav;
	}
	
	@GetMapping("/myPostView")
	public ModelAndView myPostView(int no, AdminPagingVO vo) {
		
		OffPartDTO dto = service.boardSelect(no);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("dto", dto);
		mav.addObject("vo", vo);
		mav.setViewName("mypage/myPostView");
		
		return mav;
	}
	
	@GetMapping("/myPersInfo")
	public ModelAndView myPersInfo() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/myPersInfo");
		
		return mav;
	}
	
	@GetMapping("/myPersInfo_IdChk")
		public ModelAndView myPersInfo_IdChk(HttpSession session) {
		String userid = (String)session.getAttribute("logId");
		String username = (String)session.getAttribute("logName");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userid", userid);
		mav.addObject("username", username);
		mav.setViewName("mypage/myPersInfo_IdChk");
		
		return mav;
	}
	
	@PostMapping("psInfoEdit")
	public ModelAndView psInfoEdit(String userid, String userpwd, HttpServletRequest request, HttpSession session) {
		MyPageDTO dto = service.loginOk(userid, userpwd);
		
		ModelAndView mav = new ModelAndView();
		if(dto!=null) { //성공
			
			dto = service.mpRegisterEdit((String)session.getAttribute("logId"));
			mav.addObject("dto", dto);
			
			mav.setViewName("mypage/myPersInfo");
			
		}else { //실패
			mav.addObject("msg", "비밀번호를 확인해주세요.");
			mav.setViewName("mypage/psInfoEditResult");
		}
		return mav;
	}
	
	@PostMapping("/psInfoEditOk1")
	public ModelAndView psInfoEditOk1(MyPageDTO dto, HttpSession session) {
		
		dto.setUserid((String)session.getAttribute("logId"));
		
		int cnt = service.mpRegisterEditOk1(dto);
		
		ModelAndView mav = new ModelAndView();
		if(cnt>0) {
			mav.addObject("msg","회원 정보를 수정하였습니다.");
			mav.setViewName("mypage/psInfoResultS");
		}else {
			mav.addObject("msg","회원 정보 수정에 실패하였습니다.");
			mav.setViewName("mypage/psInfoResult");
		}
		
		return mav;
	}
	
	
	@PostMapping("/psInfoEditOk2")
	public ModelAndView psInfoEditOk2(MyPageDTO dto, HttpSession session) {
		
		dto.setUserid((String)session.getAttribute("logId"));
		
		int cnt = service.mpRegisterEditOk2(dto);
		
		ModelAndView mav = new ModelAndView();
		if(cnt>0) {
			mav.addObject("msg","회원 정보를 수정하였습니다.");
			mav.setViewName("mypage/psInfoResultS");
		}else {
			mav.addObject("msg","회원 정보 수정에 실패하였습니다.");
			mav.setViewName("mypage/psInfoResult");
		}
		
		return mav;
	}
	
	
	
	/*@Autowired
	�¶��ΰ�������Service service;
	
	*/
	
}
