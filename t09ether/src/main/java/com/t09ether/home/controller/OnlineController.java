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
 	public ModelAndView onlineJoin(int on_no, int rest_count, int pro_code) {
		ModelAndView mav = new ModelAndView(); 
		OrderDTO dto = new OrderDTO();
		dto.setOn_no(on_no);
		dto.setRest_count(rest_count);
		dto.setPro_code(pro_code);
		mav.addObject("dto", dto);
		mav.addObject("pdto", dto);
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
		List<OrderDTO> list = service.locationListSelect(pro_code);
		
		for(int i=0; i<list.size(); i++) {
			list.get(i).setPro_code(pro_code);
		}

		System.out.println("list: " + list);
		
		return list;

	}
	
	//상품+검색어에 해당하는 리스트
	@GetMapping("/searchList")
	public List<OrderDTO> searchList(int pro_code, String searchWrd){
		System.out.println(searchWrd + pro_code);
		return service.getSearchList(pro_code, searchWrd);
	}
	
	@PostMapping("/orderForm")
	public ModelAndView orderForm(OrderDTO dto, ProductDTO pdto, HttpServletRequest request) {
		System.out.println(request.getSession());
		ModelAndView mav = new ModelAndView();
		System.out.println(" :-"+dto);
		System.out.println(" :-"+pdto);
		
		//ord_no select
		dto.setOrd_no(service.ordNoSelect(dto));
		System.out.println(":::"+pdto);
		
		pdto = service.proInfor(dto.getOrd_no());
		
		dto.setUserid((String)request.getSession().getAttribute("logId"));
		dto.setRank(service.userRank(dto.getUserid()));
		dto.setPro_code(pdto.getPro_code());
		
		//주문DB등록
		service.orderInsert(dto);
		
		//rest_count update
		int newRest = dto.getRest_count()-dto.getOrd_count();
		dto.setRest_count(newRest);
		service.restUpdate(dto);
		
		System.out.println(" :"+dto);
		System.out.println(" :"+pdto);
		mav.addObject("dto", dto);
		mav.addObject("pdto",pdto);
		mav.setViewName("/online/orderForm");
		return mav;
		
	}
	
	
}
