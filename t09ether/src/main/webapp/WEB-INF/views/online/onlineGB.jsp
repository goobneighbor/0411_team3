<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style>
	
	#onlineGBForm ul{
		overflow:auto;
	}
	#onlineGBForm li{
		list-style:none;
	}
	

</style>
<script>
	$(function(){
		
		$("#gbAddrSearch").click(function kakaopost() {
		      new daum.Postcode({
		        oncomplete: function (data) {
		          var addressCompany = data.address;
		          document.getElementById("gbaddr").value = addressCompany; // 주소 넣기
		          document.querySelector("input[name=gbAddrDetail]").focus(); //상세입력 포커싱
		        }
		      }).open();
		});
		
		$("#addrSearch").click(function kakaopost() {
		      new daum.Postcode({
		        oncomplete: function (data) {
		          var addressCompany = data.address;
		          document.getElementById("addr").value = addressCompany; // 주소 넣기
		          document.querySelector("input[name=addrDetail]").focus(); //상세입력 포커싱
		        }
		      }).open();
		});
		
	});
		
</script>

<!-- Header-->
<header class="bg-tomato py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
        	<h1 class="display-4 fw-bolder" style="color:#FFF">온라인 공동구매</h1>
            <p class="lead fw-normal text-white-75 mb-0">공동구매를 시작하거나 참여해보세요.</p>
        </div>
    </div>
</header>
<div class="container">
	<h1>온라인 공구 생성폼</h1>
	<form method="post" id="onlineGBForm">
		<img class="card-img-top" src="https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/199341325/B.jpg?523000000" alt="..." /></div>
		<ul>
			
			<li>갤업 고농축 액체세제 2.5L x 50개</li>
			<li>가격 : 49,500</li>
			<li>공구 주소</li>
			<li>
				<input type="text" id="gbaddr" name="gbaddr" readonly />
				<input type="button" value="주소찾기" id="gbAddrSearch"/>
			</li>
			<li>공구 상세주소</li>
				<li><input type="text" name="gbAddrDetail" id="gbAddrDetail"/></li>
				
			<li>배송지 주소</li>
			<li>
				<input type="text" name="addr" id="addr"/>
				<input type="button" value="주소찾기" id="addrSearch"/>
			</li>
			<li>배송지 상세주소</li>
			<li><input type="text" name="addrdetail" id="addrdetail"/></li>
			<li>
					<input type="submit" value="공구등록"/>
			</li>
		</ul>
	</form>
</div>

