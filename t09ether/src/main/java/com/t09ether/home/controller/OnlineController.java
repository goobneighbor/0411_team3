package com.t09ether.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.ProductDTO;
import com.t09ether.home.dto.SearchVO;
import com.t09ether.home.service.OnlineJoinService;



@RestController
@RequestMapping("/online")
public class OnlineController {
	@Autowired
	OnlineJoinService service;
	

	@GetMapping("/onlineJoinForm") 
 	public ModelAndView onlineJoin(int on_no, int rest_count) {
		ModelAndView mav = new ModelAndView(); 
		OrderDTO dto = new OrderDTO();
		dto.setOn_no(on_no);
		dto.setRest_count(rest_count);
		mav.addObject("dto", dto);
		mav.setViewName("online/onlineJoinForm"); 
		return mav; 
	}
	
	@GetMapping(value="/kakaomap", produces="application/text;charset=utf-8")
	public ModelAndView kakaomap(SearchVO vo, OrderDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		//검색어
		mav.addObject("vo",vo);
		mav.addObject("dto", dto);
		mav.setViewName("online/kakaomap");
		return mav;
	}
	//지도 나눔장소 리스트
	@GetMapping("/kakaomapList")
	public List<OrderDTO> list(int pro_code, String searchWrd) {
	   System.out.println(searchWrd);
	    return service.getList(pro_code, searchWrd);
	}
	
	//상품에 해당하는 나눔장소 전체 리스트
	@GetMapping("/locationList")
	public List<OrderDTO> locationList(int pro_code) {
		System.out.println(service.locationListSelect(pro_code).toString());
		return service.locationListSelect(pro_code);
	}
	
	//상품+검색어에 해당하는 리스트
	@GetMapping("/searchList")
	public List<OrderDTO> searchList(int pro_code, String searchWrd){
		System.out.println(searchWrd + pro_code);
		return service.getSearchList(pro_code, searchWrd);
	}
	
	@PostMapping("/orderForm")
	public ModelAndView orderForm(OrderDTO dto, ProductDTO pdto, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println(" :-"+dto);
		System.out.println(" :-"+pdto);
		pdto = service.proInfor(dto.getOn_no());
		dto.setUserid((String)request.getSession().getAttribute("logId"));
		System.out.println(" :-"+dto.getUserid());
		dto.setRank(service.userRank(dto.getUserid()));
		System.out.println(" :"+dto);
		System.out.println(" :"+pdto);
		mav.addObject("dto", dto);
		mav.addObject("pdto",pdto);
		mav.setViewName("/online/orderForm");
		return mav;
		
	}
}
