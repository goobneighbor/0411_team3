package com.t09ether.home.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.t09ether.home.dto.PaymentDTO;
import com.t09ether.home.service.OrderService;
import com.t09ether.home.service.PaymentService;
import com.t09ether.home.service.ProductService;

import okhttp3.Response;

@RestController
@RequestMapping("/pay")
public class PaymentController {
	
	@Autowired
	PaymentService paymentservice;
	
	@Autowired
	OrderService orderService;

	@Autowired
	ProductService productService;
	
	@PostMapping("/verifyIamport")
	public ResponseEntity<Map<String, Object>> verifyIamport(@RequestBody PaymentDTO data) {
		String imp_uid = data.getImp_uid();
		String r_merchant_uid = data.getR_merchant_uid();
		int ord_no = data.getOrd_no();
		int total_amount = data.getTotal_amount();
		int discount_amount = data.getDiscount_amount();
		int final_amount = data.getFinal_amount();
		
		
		System.out.println(imp_uid+""+r_merchant_uid+""+final_amount+""+discount_amount+""+ord_no+""+total_amount);
	    
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
	    	paymentservice.payInsert(imp_uid,r_merchant_uid, final_amount, discount_amount, ord_no, total_amount);
	        
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
	
	@GetMapping("/payCancel")
	public ModelAndView payCancel(int ord_no) {
		ModelAndView mav = new ModelAndView();
		PaymentDTO dto = paymentservice.paymentSelect(ord_no);
		mav.addObject("dto",dto);
		mav.setViewName("online/payCancel");
		return mav;
	}
	/*
	@PostMapping("payCancelOk")
	public ResponseEntity<?> payCancel(HttpServletRequest request,
            @RequestParam(value = "imp_uid") String impUid,
            @RequestParam(value = "merchant_uid") String merchantUid,
            @RequestParam(value = "amount") int amount,
            @RequestParam(value = "reason") String reason) {
		try {
			// 아임포트 API 클라이언트 생성
			IamportClient iamportClient = new IamportClient("your_api_key", "your_api_secret");
			
			// 결제 취소 데이터 생성
			CancelData cancelData = new CancelData(impUid, true, amount); // 전액 환불
			((Object) cancelData)).setAmount(amount);
			cancelData.setReason(reason);
			
			// 결제 취소 요청
			IamportResponse<Response<CancelPayment>> cancelResponse = iamportClient.cancelPaymentByImpUid(cancelData);
			
			// 결제 취소 결과 확인
			if (cancelResponse.getResponse().getStatus().equals("cancelled")) {
			// 환불 성공 시 DB에서 데이터 삭제 처리
			// ...
			return ResponseEntity.ok().body("{\"code\":\"1\"}");
			
			} else {
			// 환불 실패 시 처리할 코드 작성
			return ResponseEntity.ok().body("{\"code\":\"0\"}");
			
			}
			} catch (Exception e) {
			// 오류 발생 시 처리할 코드 작성
			return ResponseEntity.ok().body("{\"code\":\"0\"}");
			}
	}
	 */
}
