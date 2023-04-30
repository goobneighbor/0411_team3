package com.t09ether.home.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.RegisterDTO;
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
	
	@GetMapping("/adUser")
	public ModelAndView adUser(AdminPagingVO vo) {
		
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
	
	@GetMapping("/myOrderorigin")
	public ModelAndView myOrderorigin(AdminPagingVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String userid = (String)session.getAttribute("logId");
		vo.setTotalRecord(service.totalOrderRecord(vo));
		//System.out.println(vo.toString());
		
		List<OrderDTO> list = service.mgtPageSelect(vo,vo.getTotalPage(), vo.getSearchKey(), vo.getSearchWord(), userid, vo.getNowPage(), vo.getLastPageRecord(), vo.getOnePageRecord());
		//System.out.println(list);
		
		mav.addObject("vo", vo);
		mav.addObject("list", list);		
		mav.setViewName("admin/myOrderorigin");
		return mav;
	}
	
	@PostMapping("/ordMultiUp")
	public ModelAndView boardMultiDel(OrderDTO dto, AdminPagingVO vo) {
	    ModelAndView mav = new ModelAndView();
	    System.out.println(dto.getOn_no());
	    mav.addObject("nowPage", vo.getNowPage());
	    if (vo.getSearchWord() != null && !vo.getSearchWord().equals("")) {
	        mav.addObject("searchKey", vo.getSearchKey());
	        mav.addObject("searchWord", vo.getSearchWord());
	    }

	    try {
	        if (dto.getStatus() < 4) {
	            int result = service.ordMultiUpdate(dto.getOn_no()); //주문 상태 업데이트
	            if(result>0) {
		            mav.addObject("errorMsg", "주문상태 업데이트 성공");
		            mav.setViewName("admin/adOrdStatus");
	            }else {
	            	mav.addObject("errorMsg", "주문상태 업데이트 실패");
		            mav.setViewName("admin/adOrdStatus");
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	        mav.addObject("errorMsg", "주문상태 업데이트 실패");
	        mav.setViewName("admin/adOrdStatus");
	    }

	    return mav;
	}
	
}
