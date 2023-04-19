<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<style>
	input::-webkit-outer-spin-button,
	input::-webkit-inner-spin-button {
  		-webkit-appearance: none;
  		margin: 0;
	
	}
	#onlineGBForm ul{
		overflow:auto; 
		border:1px solid #ddd;
		padding:50px;
		
	}
	#onlineGBForm li{
		
		margin:5px ; 
		padding:5px 0;	
		list-style:none;
		
	}
	
	#firstul li>:nth-child(2n){
		float:left;
	}
	
	#addr, #shareaddr{
 		width:80%;
 		float:left;
 	}
 	
	#addrdetail, #shareaddrDetail{
		width:90%;
	}
	
	#lastsubmit{
		width:150px;
        margin:auto;
		display:block;
	}
	
	#test{
		float:left;
	}
	#imagetest{
		
	}

	#on_count, #pro_price, #pro_aprice, #addr_p, #o_price{
		text-align:center;
	}
	
	
	.card-img-top{
		width: 400px;
  		height: 400px;
  		
	}
	#plus, #minus{
		text-align:center;
		width:42px;
		height:35px;
	}
</style>
<script>
	$(function(){
		$("#pro_aprice").ready(function(){
		    var num = document.getElementById("pro_aprice").value
		    num = Math.ceil(num);
		    document.getElementById("pro_aprice").value = num;
	    });
		
		$("#o_price").ready(function(){
		    var num = document.getElementById("o_price").value
		    num = Math.ceil(num);
		    document.getElementById("o_price").value = num;
	    });
		
		$("#plus").click(function(){
			var pro_total = parseInt(document.getElementById("pro_total").value);
			var cnt =  parseInt(document.getElementById("on_count").value);
			if(cnt<pro_total){
				var c_cnt = document.getElementById("on_count").value = cnt + 1;
				var num =  parseInt(document.getElementById("o_price").value);
				var total = (num*c_cnt)+500;
				document.getElementById("pro_aprice").value = total;
			}
		});
		
		$("#minus").click(function(){
			var cnt =  parseInt(document.getElementById("on_count").value);
			if(cnt>1){
				var c_cnt = document.getElementById("on_count").value = cnt - 1;
				var num =  parseInt(document.getElementById("o_price").value);
				var total = (num*c_cnt)+500;
				document.getElementById("pro_aprice").value = total;
			}
		});
		
		
		$("#addrSearch").click(function kakaopost() {
		      new daum.Postcode({
		        oncomplete: function (data) {
		          var addressCompany = data.address;
		          document.getElementById("addr").value = addressCompany; // 주소 넣기
		          document.getElementById('zipcode').value = data.zonecode;
		          document.querySelector("input[name=addrdetail]").focus(); //상세입력 포커싱
		        }
		      }).open();
		});
		
		
		$("#shareaddrSearch").click(function kakaopost() {
		      new daum.Postcode({
		        oncomplete: function (data) {
		          var addressCompany = data.address;
		          document.getElementById("shareaddr").value = addressCompany; // 주소 넣기
		          document.querySelector("input[name=shareaddrDetail]").focus(); //상세입력 포커싱
		        }
		      }).open();
		});
		
		//유효성 검사
		$("#onlineGBForm").submit(function() {
			
			if($("#username").val()=="") {
				alert("이름을 입력하세요.");
				return false;
			}
			//이름검사
			reg = /^[가-힣]{2,10}$/
			if(!reg.test($("#username").val())) {
				alert("이름은 2글자에서 10글자까지 한글만 가능합니다.");
				return false;
			}
			
			//전화번호
			if($("#tel").val()=="") {
				alert("전화번호를 입력하세요.");
				return false;
			}
			
			reg = /^(010|02|031|041|051)-[0-9]{3,4}-[0-9]{4}$/
			if(!reg.test($("#tel").val())) {
				alert("전화번호를 잘못 입력했습니다.");
				return false;
			}
			
			if($("#addr").val()=="") {
				alert("배송주소를 입력하세요.");
				return false;
			}
			
			if($("#addrdetail").val()=="") {
				alert("배송상세주소를 입력하세요.");
				return false;
			}
			
			if($("#shareaddr").val()=="") {
				alert("나눔주소를 입력하세요.");
				return false;
			}
			
			if($("#shareaddrDetail").val()=="") {
				alert("나눔상세주소를 입력하세요.");
				return false;
			}
			
			const IMP = window.IMP; // 생략 가능
			IMP.init("imp01658864"); // 예: imp00000000a
			
			function requestPay() {
	            IMP.request_pay({
	                pg : 'kakao',
	                pay_method : 'card',
	                merchant_uid: "57008833-33004", 
	                name : '당근 10kg',
	                amount : 1004,
	                buyer_email : 'Iamport@chai.finance',
	                buyer_name : '포트원 기술지원팀',
	                buyer_tel : '010-1234-5678',
	                buyer_addr : '서울특별시 강남구 삼성동',
	                buyer_postcode : '123-456'
	            }, function (rsp) { // callback
	                if (rsp.success) {
	                    console.log(rsp);
	                } else {
	                    console.log(rsp);
	                }
	            });
	            
			}
			requestPay();
		
			  
			
			//form태그의 action속성 설정
			$("#onlineGBForm").attr("action","payTest");
		});
	});
		
</script>
<div class="container">
	<section id="main" class="container">
		<header>
			<h2>온라인 공동구매 생성</h2>
			<p>공동 구매 상품확인</p>
		</header>
	</section>
	<form method="post" id="onlineGBForm" >
		<div>
			<ul id="firstul">
				<li><h3>주문상품</h3></li>
				<!-- 상품이미지가져와야함 -->
				<li><img class="card-img-top" src="${dto.image }" alt="${dto.pro_name }" /></li>
				<li>상품명</li>
				<li><input type="text" name="pro_name" id="pr_name" value="${dto.pro_name }" readonly></li> <!-- 상품명가져와야함 -->
				<li>가격</li>
				<li><input type="number" name="pro_price" id="pro_price" value="${dto.pro_price }" readonly/></li> <!-- 가격가져와야함 -->
				<li>개당가격</li>
				<li><input type="number" name="o_price" id="o_price" value="${dto.pro_price/dto.pro_total}" readonly/>&nbsp;원</li> <!-- 가격가져와야함 -->
				<li>수량</li>
				<li><input type="hidden" name="pro_total" id="pro_total" value="${dto.pro_total }"/></li> 
				<li>
					<input type="button" name="plus" id="plus" value="+"/>
					<input type="number" name="on_count" id="on_count" min="1" max="${dto.pro_total }" value="1" readonly/>
					<input type="button" name="minus" id="minus" value="-"/>
				</li>
				<li>배송비</li>
				<li><input type="number" name="addr_p" id="addr_p" value="500" readonly/>&nbsp;원</li>
				<li>전체 가격 </li>
				<li><input type="number" name="pro_aprice" id="pro_aprice" value="${ (dto.pro_price/dto.pro_total)+500}" readonly/> 원</li>
				
					
			</ul>
			<ul>			
				<li><h3>주문자</h3></li> 
				<li>주문자명</li> <!-- 주문자명가져와야함 -->
				<li><input type="text" id="username" name="username" value='<%= request.getSession().getAttribute("logName") %>' placeholder="주문자명입력" onfocus="this.placeholder=''"/></li>
				<li>전화번호</li>
				<li><input type="text" id="tel" name="tel" value="" placeholder="-포함입력" onfocus="this.placeholder=''"/></li>
			</ul>	
			<ul>	
				<li><h3>배송지</h3></li>
				<li>배송 주소</li>
				<li>
					<input type="hidden" name="zipcode" id="zipcode" value="" placeholder="우편번호" onfocus="this.placeholder=''" readonly/>
					<input type="text" name="addr" id="addr" value="" placeholder="수령주소" onfocus="this.placeholder=''" readonly/>
					<input type="button" value="주소찾기" id="addrSearch"/> 
				</li>
				<!-- 상세주소가져와야함 -->
				<li><input type="text" name="addrdetail" id="addrdetail" value="" placeholder="수령상세주소입력" onfocus="this.placeholder=''"/></li>
				
				<li>만남 주소</li>
				<li>
					<input type="text" id="shareaddr" name="shareaddr" value="" placeholder="나눔주소입력" onfocus="this.placeholder=''" readonly/>
					<input type="button" value="주소찾기" id="shareaddrSearch"/>
				</li>
				<li><input type="text" name="shareaddrDetail" id="shareaddrDetail" value="" placeholder="나눔상세주소입력" onfocus="this.placeholder=''"/></li>
			</ul>
			<input type="submit" value="등록하기" id="lastsubmit"/>
		</div>
	</form>
</div>


    