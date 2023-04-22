package com.t09ether.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siot.IamportRestClient.IamportClient;
import com.t09ether.home.service.PaymentService;

@RestController
@RequestMapping("/pay")
public class PaymentController {
//	//토큰 발급을 위해 아임포트에서 제공해주는 rest api 사용.(gradle로 의존성 추가)
//		private final IamportClient iamportClientApi;
//		
//		//생성자로 rest api key와 secret을 입력해서 토큰 바로생성.
//		public PaymentController() {
//			this.iamportClientApi = new IamportClient("1456485756545636",
//					"723XBRqRiIMZsO65ZY90OLJ1gGExsyrz70PAs7ZgOJRSyJanoUfv4StVHkXkxv10XDWABUK9eOB8ibnu");
//		}
//		
//		@Autowired
//		PaymentService service;
//	

}
