package com.t09ether.home.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
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
		System.out.println("onlineJoin"+dto);
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
		//dto.setOrd_no(service.ordNoSelect(dto));
		//System.out.println(":::"+pdto);
		
		pdto = service.proInfor(dto.getPro_code());
		System.out.println("새로넣은"+pdto);
		//최종가격
		int ord_amount = dto.getOrd_count()*(pdto.getPro_price()/pdto.getPro_total());
		
		dto.setUserid((String)request.getSession().getAttribute("logId"));
		dto.setRank(service.userInfor(dto.getUserid()).getRank());
		dto.setUsername(service.userInfor(dto.getUserid()).getUsername());
		dto.setEmail(service.userInfor(dto.getUserid()).getEmail());
		dto.setTel(service.userInfor(dto.getUserid()).getTel());
		dto.setOrd_amount(ord_amount);
		dto.setPro_code(pdto.getPro_code());
		System.out.println(dto.getUsername());
		
		//주문DB등록
		service.orderInsert(dto);
		
		//rest_count update
		int newRest = dto.getRest_count()-dto.getOrd_count();
		dto.setRest_count(newRest);
		service.restUpdate(dto);
		
		System.out.println(" :"+dto.getOrd_no());
		System.out.println(" :"+pdto);
		mav.addObject("dto", dto);
		mav.addObject("pdto",pdto);
		mav.setViewName("/online/orderForm");
		return mav;
		
	}
	
	@PostMapping("/paymentSuc")
	public ModelAndView paymentSuc(OrderDTO dto, ProductDTO pdto) {
		System.out.println(":::"+pdto);
		System.out.println(":::"+dto.getOn_no());
		ModelAndView mav = new ModelAndView();
		System.out.println(dto.getRest_count());
		int restNum = dto.getRest_count();
		
		if(restNum==0) {
			//모든 공구참여자 status update
			dto.setStatus(service.statusUpdate(dto));
			//모든 공구참여자 register정보
			List<OrderDTO> list = service.selectInfor(dto.getOn_no());
		
			for(OrderDTO odto : list) {
				String tel = odto.getTel().replaceAll("-", "");
				String username = odto.getUsername();
				System.out.println(tel);
				//문자보내기
				send_msg(tel, username);
			}
			
		}
		mav.addObject("dto",dto);
		mav.addObject("pdto", pdto);
		mav.setViewName("/online/paymentSuc");
		return mav;
	}
	
	public void send_msg(String tel, String username) {
        // 호스트 URL
        String hostNameUrl = "https://sens.apigw.ntruss.com";
        // 요청 URL
        String requestUrl= "/sms/v2/services/";
        // 요청 URL Type
        String requestUrlType = "/messages";
        // 개인 인증키
        String accessKey = "wobfVS4EOczZJaPKy1LU";
        // 2차 인증을 위해 서비스마다 할당되는 service secret
        String secretKey = "AEdaVEJy6FNylYddLGtjeTe9A30W4IxLh6Brp5jz";
        // 프로젝트에 할당된 SMS 서비스 ID
        String serviceId = "ncp:sms:kr:306927261156:sms_project";
        // 요청 method
        String method = "POST";
        // current timestamp (epoch)
        String timestamp = Long.toString(System.currentTimeMillis());
        requestUrl += serviceId + requestUrlType;
        String apiUrl = hostNameUrl + requestUrl;

        // JSON 을 활용한 body data 생성
        JSONObject bodyJson = new JSONObject();
        JSONObject toJson = new JSONObject();
        JSONArray  toArr = new JSONArray();
        
        // 전송
        //toJson.put("content","테스트중");		
        toJson.put("to",tel);
       
        toArr.put(toJson); //messages
        
	    
        // 메시지 Type (sms)
        String content = "["+username+"]님 공구가 성공했습니다! 마이페이지를 통해 공구장과 일정을 조율하세요![t09ther]";
        bodyJson.put("type","sms");
        bodyJson.put("contentType","COMM");
        bodyJson.put("countryCode","82");
        bodyJson.put("content", content);
        // 발신번호 * 사전에 인증/등록된 번호만 사용할 수 있습니다.
        bodyJson.put("from","01029561335");		
        bodyJson.put("messages", toArr);		
	    
        String body = bodyJson.toString();
	    
        System.out.println(body);
	    
        try {
            URL url = new URL(apiUrl);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("content-type", "application/json");
            con.setRequestProperty("x-ncp-apigw-timestamp", timestamp);
            con.setRequestProperty("x-ncp-iam-access-key", accessKey);
            con.setRequestProperty("x-ncp-apigw-signature-v2", makeSignature(requestUrl, timestamp, method, accessKey, secretKey));
            con.setRequestMethod(method);
            con.setDoOutput(true);
            
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            
            wr.write(body.getBytes());
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            
            //BufferedReader br;
            
            System.out.println("responseCode" +" " + responseCode);
            
            if(responseCode==202) { // 정상 호출
                //br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                
            } else {  // 에러 발생
                //br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            /*
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            
            br.close();
            
            System.out.println(response.toString());
             */
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	//헤더 구성
    public static String makeSignature(
        String url, 
        String timestamp, 
        String method, 
        String accessKey, 
        String secretKey
    ) throws NoSuchAlgorithmException, InvalidKeyException {
        
	    String space = " "; 
	    String newLine = "\n"; 
	    
	    String message = new StringBuilder()
	        .append(method)
	        .append(space)
	        .append(url)
	        .append(newLine)
	        .append(timestamp)
	        .append(newLine)
	        .append(accessKey)
	        .toString();

	    SecretKeySpec signingKey;
	    String encodeBase64String;
		try {
			signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
			encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
		} catch (UnsupportedEncodingException e) {
			encodeBase64String = e.toString();
		}
	    

	  return encodeBase64String;
	}
	
}
