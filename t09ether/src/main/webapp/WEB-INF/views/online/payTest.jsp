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
	#onlineGBPayForm ul{
		overflow:auto; 
		border:1px solid #ddd;
		padding:50px;
		
	}
	#onlineGBPayForm li{
		
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

	#ord_count, #discount_amount, #final_amount{
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
	var sum;
$(function(){
	var IMP = window.IMP; 
    IMP.init("imp01658864"); 
    
    var pro_name = document.getElementById("pro_name").value;
    var all_amount = document.getElementById("final_amount").value;;
    var email = document.getElementById("email").value;
    var username = document.getElementById("username").value;
    var tel = document.getElementById("tel").value;
    var addr = document.getElementById("addr").value+" "+ document.getElementById("addrdetail").value;
    var zipcode = document.getElementById("zipcode").value;

    function requestPay() {
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid: "merchant-"+ new Date().getTime(), 
            name : pro_name,
            amount : all_amount,
            buyer_email : email,
            buyer_name : username,
            buyer_tel : tel,
            buyer_addr : addr,
            buyer_postcode : zipcode
        }, function (rsp) { // callback
            if (rsp.success) {
                console.log(rsp);
            } else {
                console.log(rsp);
            }
        });
    }
    
    $("#lastsubmit").click(function(){
    	requestPay();
    	
    });
    
});
	
		
</script>



    