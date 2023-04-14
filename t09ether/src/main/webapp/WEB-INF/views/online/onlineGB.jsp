<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
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
	
	/*스타일 되는부분*/
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
	
	/*스타일 되는부분*/
	#on_count, #pro_price{
		text-align:center;
	}
	
	/*스타일 되는부분*/
	.card-img-top{
		width: 400px;
  		height: 400px;
  		
	}
	
	/*스타일 되는부분*/
	h1{
		margin: 30px;
	}
</style>
<script>
	$(function(){
		$("#addrSearch").click(function kakaopost() {
		      new daum.Postcode({
		        oncomplete: function (data) {
		          var addressCompany = data.address;
		          document.getElementById("addr").value = addressCompany; // 주소 넣기
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
			
			reg = /^[0-9]{10,11}$/
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
			

			//form태그의 action속성 설정
			$("#onlineGBForm").attr("action","onlineList");
		});
	});
		
</script>
<div class="container">
	<h1>온라인 공구 생성폼</h1>
	<form method="post" id="onlineGBForm">
		<div>
			<ul id="firstul">
				<li><h3>주문상품</h3></li>
				<!-- 상품이미지가져와야함 -->
				<li id="#imagetest"><img class="card-img-top" src="https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/199341325/B.jpg?523000000" alt="..." /></li>
				<li><input type="text" name="pro_name" id="pr_name" value="갤업 고농축 액체세제 2.5L x 50개" readonly></li> <!-- 상품명가져와야함 -->
				<li>가격</li>
				<li><input type="number" name="pro_price" id="pro_price" value="49500" readonly/></li> <!-- 가격가져와야함 -->
				<li>수량</li> 
				<li><input type="number" name="on_count" id="on_count" min="1" max="50" value="1"/></li>
				<li>전체 가격 </li>
					
			</ul>
			<ul>			
				<li><h3>주문자</h3></li> 
				<li>주문자명</li> <!-- 주문자명가져와야함 -->
				<li><input type="text" id="username" name="username" value="" placeholder="주문자명입력" onfocus="this.placeholder=''"/></li>
				<li>전화번호</li> <!-- 전화번호가져와야함 -->
				<li><input type="text" id="tel" name="tel" placeholder="-빼고입력" onfocus="this.placeholder=''"/></li>
			</ul>	
			<ul>	
				<li><h3>배송지</h3></li>
				<li>배송 주소</li>
				<li>
					<!-- 배송주소가져와야함 -->
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
			<input type="submit" value="결제하기" id="lastsubmit"/>
		</div>
		
	</form>
</div>

