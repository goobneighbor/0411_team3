package com.t09ether.home.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.t09ether.home.dto.PaymentDTO;
import com.t09ether.home.service.PaymentService;

@RestController
@RequestMapping("/pay")
public class PaymentController {
	
	@Autowired
	PaymentService service;
	
	@PostMapping("/verifyIamport")
	public ResponseEntity<Map<String, Object>> verifyIamport(@RequestBody PaymentDTO data) {
		String imp_uid = data.getImp_uid();
		int ord_no = data.getOrd_no();
		int total_amount = data.getTotal_amount();
		int discount_amount = data.getDiscount_amount();
		int final_amount = data.getFinal_amount();
		
		
		System.out.println(imp_uid+final_amount+discount_amount+ord_no+total_amount);
	    
	    // 아임포트 API를 사용하여 결제 검증 수행
	    IamportClient iamportClient = new IamportClient("1456485756545636", "723XBRqRiIMZsO65ZY90OLJ1gGExsyrz70PAs7ZgOJRSyJanoUfv4StVHkXkxv10XDWABUK9eOB8ibnu");
	    try {
	   
	        // 결제 검증 결과가 일치하지 않으면 예외 발생
	    	IamportResponse<Payment> paymentResponse = iamportClient.paymentByImpUid(imp_uid);
	    	Payment payment = paymentResponse.getResponse();
	    	if (!payment.getStatus().equals("paid") || payment.getAmount().compareTo(new BigDecimal(final_amount)) != 0) {
	    	    throw new Exception("결제 검증 실패");
	    	}
	        
	        // DB에 결제 정보 삽입
	        service.payInsert(imp_uid, final_amount, discount_amount, ord_no, total_amount);
	        
	        Map<String, Object> result = new HashMap<String, Object>();
	        result.put("success", true);
	        result.put("message", "결제 검증 및 DB 삽입 완료");
	        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	        
	    } catch (Exception e) {
	    	e.printStackTrace();
	        // 결제 검증 또는 DB 삽입 실패 시 예외 처리
	    	Map<String, Object> result = new HashMap<String, Object>();
	        result.put("success", true);
	        result.put("message", "결제 검증 및 DB 삽입 실패");
	        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.BAD_REQUEST);
	    }
	}
}
