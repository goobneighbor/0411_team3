package com.t09ether.home.controller;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.t09ether.home.dto.ProductDTO;
import com.t09ether.home.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	@GetMapping("/productWrite")
	public ModelAndView productIn() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/productWrite");
		return mav;
	}
	
	@PostMapping("/productWriteOk")
	public ResponseEntity<String> boardWriteOk(ProductDTO dto) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=utf-8");
		
		//상품등록시 실패하면 예외발생
		try {
			service.productInsert(dto);
			String htmlTag = "<script>location.href='home';</script>";
			entity = new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			String htmlTag = "<script>"; 
			htmlTag += "alert('글이 등록되지 않았습니다.');";
			htmlTag += "history.back();";
			htmlTag += "</script>";
			entity = new ResponseEntity<String>(htmlTag, headers, HttpStatus.BAD_REQUEST);
		}
		return entity; 
		
	}

}
