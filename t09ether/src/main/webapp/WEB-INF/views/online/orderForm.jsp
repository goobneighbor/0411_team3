<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<style>
#main, #finalPayment{
	list-style-type:none;
	float:center;
	text-align:left; 
	margin:0 auto;
	padding:10px;
	width:80%;
}
#finalPayment li{
	margin:0 auto;
	padding:5px;
	float:center;
	font-size:1.2em;
	color:#646464;
	
	/* line-height:10px; */
}
#finalPayment li>:nth-child(2n+1){
    float:center;
    font-size:1.2em;
    padding:10px;
	margin:5px;

}
   

#username, #rank{
	font-weight:bold;
}
</style>

<script>
	window.name="orderForm"

		/* if (!isLogin) {
            alert("로그인 후 이용할 수 있습니다.");
            return;
        } */
$(function(){      
	var IMP = window.IMP; 
    IMP.init("imp01658864"); 
    
    var pro_name = document.getElementById("pro_name").value;
    var all_amount = document.getElementById("final_amount").value;;
    var email = document.getElementById("email").value;
    var username = document.getElementById("username").value;
    var tel = document.getElementById("tel").value;

    function requestPay() {
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid: "merchant-"+ new Date().getTime(), 
            name : pro_name,
            amount : all_amount,
            buyer_email : email,
            buyer_name : username,
            buyer_tel : tel
        }, function (rsp) { // callback
            if (rsp.success) {
                //form의 action
                $("#payment_form").attr("action","<%=request.getContextPath() %>/online/paymentSuc");
             	 //form에 정보담아 submit
                document.getElementById('payment_form').submit();
             } else {
                 var msg = '결제에 실패하였습니다.';
                 msg += '에러내용 : ' + rsp.error_msg;
                 alert(msg);
             }

        });
    }
    
    $("#payment").click(function(){
       requestPay();
       
    });
    
});
</script>
;
		
	<section id="main" class="container">
		<header>
			<h2>주문하기</h2>
			<p><span id="username">${logName }</span> 님은 현재 <span id="rank">${dto.rank}</span> 등급입니다! <br/>할인을 확인하시고 결제진행해주세요!</p>
		</header>
		<div class="container">
	        <div class="row">
				 <div class="col-lg-6">
		             <!-- Featured blog post-->
		             <div class="card mb-6">
		                 <img src="${pdto.image }" />	                 
		        	</div>
		         </div>
							 <!-- Side widgets-->
		            <div class="col-lg-6">
		                <div class="card mb-6">
		               		<div class="card-header" style="text-align:right">결제 상세보기</div>
		               		 <form method="post" id="payment_form">
		               		 <div id="finalPayment">
			               		<li>상품명</li>
					           	<li><input type="text" name="pro_name" id="pro_name" value="${pdto.pro_name }" readonly></li> 
					            <li>수량</li>
					            <li><input type="text" name="ord_count" id="ord_count" value="${dto.ord_count }" readonly/></li>
					            <li>금액</li>
					            <li><input type="text" name="ord_count" id="first_count" value="${Math.ceil(pdto.pro_price/pdto.pro_total)*dto.ord_count }" readonly/></li>
								<li>총금액 * 할인율 = 할인금액</li>
								<li><input type="text" name="ord_count" id="discount_count" value="${Math.ceil(pdto.pro_price/pdto.pro_total)*dto.ord_count } * 10% = ${Math.ceil(pdto.pro_price/pdto.pro_total*dto.ord_count*0.1) }" readonly/></li>
								<li>총금액 - 할인금액 = 최종금액</li>
								<li><input type="text" name="final_count" id="final_count" value="${Math.ceil(pdto.pro_price/pdto.pro_total)*dto.ord_count } - ${Math.ceil(pdto.pro_price/pdto.pro_total*dto.ord_count*0.1) } = ${Math.ceil(pdto.pro_price/pdto.pro_total)*dto.ord_count - Math.ceil(pdto.pro_price/pdto.pro_total*dto.ord_count*0.1) }" readonly/></li>
								<input type="hidden" id="final_amount" name="final_amount" value="${Math.ceil(pdto.pro_price/pdto.pro_total)*dto.ord_count - Math.ceil(pdto.pro_price/pdto.pro_total*dto.ord_count*0.1) }"/>
								<input type="hidden" id="username" name="username" value="${dto.username }"/>
								<input type="hidden" id="email" name="email" value="${dto.email}"/>
								<input type="hidden" id="tel" name="tel" value="${dto.tel}"/>
								<input type="hidden" id="userid" name="userid" value="${dto.userid}"/>
								<input type="hidden" id="ord_no" name="ord_no" value="${dto.ord_no}"/>
								<input type="hidden" id="rest_count" name="rest_count" value="${dto.rest_count }"/>
								<input type="hidden" id="on_no" name="on_no" value="${dto.on_no}"/>
							</div>
							</form>
						</div>
		             </div>		    							                     
		     </div>
	       	<hr/>
	       	<br/>
		</div>
		<input type="button" value="결제하기" id="payment"/>
	</section>