package com.t09ether.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.SearchVO;
import com.t09ether.home.service.OnlineJoinService;

import net.sf.json.JSONArray;



@RestController
@RequestMapping("/online")
public class OnlineController {
	@Autowired
	OnlineJoinService service;
	

	@GetMapping("/onlineJoinForm") 
 	public ModelAndView onlineJoin() {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("online/onlineJoinForm"); 
		return mav; 
	}
	
	@GetMapping("/kakaomap")
	public ModelAndView kakaomap(SearchVO vo) {
		ModelAndView mav = new ModelAndView();
		
		//검색어
		mav.addObject("vo",vo);
		mav.setViewName("online/kakaomap");
		return mav;
	}
	
	//상품에 해당하는 나눔장소 전체 리스트
	@GetMapping("/locationList")
	public List<OrderDTO> locationList(int pro_code) {
		return service.locationListSelect(pro_code);
	}
	
	//모든 나눔장소
	@GetMapping("/kakaomapList")
	public List<OrderDTO> list(String searchWrd) {
	   
	    return service.getList(searchWrd);
	}
	
}