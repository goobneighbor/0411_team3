package com.t09ether.home.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.t09ether.home.dto.AdminOrderPagingVO;
import com.t09ether.home.dto.AdminPagingVO;
import com.t09ether.home.dto.OrderDTO;
import com.t09ether.home.dto.ProductDTO;
import com.t09ether.home.dto.RegisterDTO;
import com.t09ether.home.dto.ReportDTO;
import com.t09ether.home.dto.TempDTO;
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
	public ModelAndView adUser(AdminPagingVO vo, AdminOrderPagingVO vo2) {
		
		ModelAndView mav = new ModelAndView();
		
		vo.setTotalRecord(service.totalRecord(vo));
		vo2.setTotalRecord(service.totalStopRecord(vo2));
		//System.out.println(vo.toString());
		
		List<RegisterDTO> list = service.pageSelect(vo);
		List<RegisterDTO> list2 = service.pageStopSelect(vo2);
		//System.out.println(list);
		
		mav.addObject("vo",vo);
		mav.addObject("vo2",vo2);
		mav.addObject("list", list);
		mav.addObject("list2", list2);
		mav.setViewName("admin/adUser");
		return mav;
	}
	//임시정지
	@PostMapping("/tempStop")
	public ModelAndView tempStop(AdminPagingVO vo, RegisterDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		int result = service.tempStopInsert(dto.getNoList());
		System.out.println(result);
		
		mav.addObject("nowPage", vo.getNowPage());
		if(vo.getSearchWord()!=null && !vo.getSearchWord().equals("")) {
			mav.addObject("searchKey", vo.getSearchKey());
			mav.addObject("searchWord", vo.getSearchWord());
		}
		
		mav.setViewName("redirect:adUser");
		return mav;
		
	}
	//정지해제
	@PostMapping("/unStop")
	public ModelAndView unStop(AdminOrderPagingVO vo2, TempDTO dto) {
		ModelAndView mav = new ModelAndView();
		System.out.println(dto.getNoList());

		int result = service.tempStopDel(dto.getNoList());
		
		System.out.println(result);
		
		mav.addObject("nowPage2", vo2.getNowPage2());
		if(vo2.getSearchWord2()!=null && !vo2.getSearchWord2().equals("")) {//자바니깐 공백도 물어봐야(equals("")
			mav.addObject("searchKey2", vo2.getSearchKey2());
			mav.addObject("searchWord2", vo2.getSearchWord2());
		}
		
		mav.setViewName("redirect:adUser");
		return mav;
		
	}
	
	@GetMapping("/adReport")
	public ModelAndView adReport(AdminPagingVO vo) {
		
		ModelAndView mav = new ModelAndView();
		
		vo.setTotalRecord(service.totalReportRecord(vo));
	
		List<RegisterDTO> list = service.pageReportSelect(vo);
		
		mav.addObject("vo",vo);
		mav.addObject("list", list);
		mav.setViewName("admin/adReport");
		return mav;
	}
	
	@PostMapping("/reportDel")
	public ModelAndView reportDel(AdminPagingVO vo, ReportDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		int result = service.reportDel(dto.getNoList());
		System.out.println(result);
		
		mav.addObject("nowPage", vo.getNowPage());
		if(vo.getSearchWord()!=null && !vo.getSearchWord().equals("")) {
			mav.addObject("searchKey", vo.getSearchKey());
			mav.addObject("searchWord", vo.getSearchWord());
		}
		
		mav.setViewName("redirect:adReport");
		return mav;
		
	}
	
	@PostMapping("/reportAccept")
	public ModelAndView reportAccept(AdminPagingVO vo, ReportDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		//target_id select
		List<String> tarlist = service.targetSelect(dto.getNoList());
		System.out.println(tarlist);
		
		//target_id update
		for(String userid : tarlist) {
			int result = service.targetUpdate(userid);
			System.out.println(result+" "+userid);
		}
		//신고테이블에서 삭제
		int resultDel = service.reportDel(dto.getNoList());
		System.out.println(resultDel);
		
		mav.addObject("nowPage", vo.getNowPage());
		if(vo.getSearchWord()!=null && !vo.getSearchWord().equals("")) {
			mav.addObject("searchKey", vo.getSearchKey());
			mav.addObject("searchWord", vo.getSearchWord());
		}
		
		mav.setViewName("redirect:adReport");
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
	public ModelAndView adProduct(AdminPagingVO vo) {
		ModelAndView mav = new ModelAndView();
		//총레코드수 구하기
		vo.setTotalRecord(service.totalProductRecord(vo));
		
		//해당페이지 레코드 선택하기
		mav.addObject("list", service.pageProductSelect(vo)); //list정보도 뷰페이지에서 사용하게
		
		mav.addObject("vo",vo); //페이지 정보를 뷰페이지로 갖고가게
		mav.setViewName("admin/adProduct");
		return mav;
	}
	
	@GetMapping("/productWrite")
	public ModelAndView productWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/productWrite");
		return mav;
	}
	//상품 DB등록
	@PostMapping("/productWriteOk")
	public ResponseEntity<String> productWriteOk(ProductDTO dto) {
		System.out.println(dto.toString());
		//글등록할때 실패하면 예외발생 
		String htmlTag = "<script>";
		try {
		
			int result = service.productInsert(dto); 
			htmlTag += "alert('상품이 등록되었습니다.');";
			htmlTag += "location.href = 'adProduct';"; 
		
		}catch(Exception e) {
			e.printStackTrace();
			htmlTag += "alert('상품이 등록되지 않았습니다.');";
			htmlTag += "history.back();";
		
		}
		htmlTag += "</script>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);
		
	}
	@PostMapping("/productDel")
	public ModelAndView productDel(AdminPagingVO vo, ProductDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		int result = service.productDel(dto.getNoList());
		System.out.println(result);
		
		mav.addObject("nowPage", vo.getNowPage());
		if(vo.getSearchWord()!=null && !vo.getSearchWord().equals("")) {//자바니깐 공백도 물어봐야(equals("")
			mav.addObject("searchKey", vo.getSearchKey());
			mav.addObject("searchWord", vo.getSearchWord());
		}
		
		mav.setViewName("redirect:adProduct");
		return mav;
		
	}
	//수정폼
	@GetMapping("/productEdit")
	public ModelAndView productEdit(ProductDTO dto) {
		dto = service.proInfor(dto.getPro_code());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.setViewName("admin/productEdit");
		return mav;
		
	}
	//수정 DB update
	@PostMapping("/productEditOk")
	public ResponseEntity<String> productEditOk(ProductDTO dto) {
		System.out.println(dto.toString());
		//글등록할때 실패하면 예외발생 
		System.out.println(dto);
		String htmlTag = "<script>";
		try {
		
			int result = service.productUpdate(dto); 
			System.out.println(result);
			htmlTag += "alert('상품이 수정되었습니다.');";
			htmlTag += "location.href = 'adProduct';"; 
		
		}catch(Exception e) {
			e.printStackTrace();
			htmlTag += "alert('상품이 수정되지 않았습니다.');";
			htmlTag += "history.back();";
		
		}
		htmlTag += "</script>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);
		
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
		vo.setTotalRecord(service.totalOrderRecord(vo));
		//System.out.println(vo.toString());
		
		List<OrderDTO> list = service.mgtPageSelect(vo);
		//System.out.println(list);
		
		mav.addObject("list", list);		
		mav.addObject("vo", vo);
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

	@GetMapping("/adOrderList")
	public ModelAndView totalOrdSelect(AdminPagingVO vo) {
		ModelAndView mav = new ModelAndView();
		vo.setTotalRecord(service.totalOrdRecord(vo));
		//System.out.println(vo.toString());
		
		List<OrderDTO> list = service.totalOrdSelect(vo);
		//System.out.println(list);
		
		mav.addObject("vo",vo);
		mav.addObject("list", list);
		mav.setViewName("admin/adOrderList");
		return mav;
	}
	
	
}
