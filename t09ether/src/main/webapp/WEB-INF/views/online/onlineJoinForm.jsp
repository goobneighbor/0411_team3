<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
header,footer{
		display:none;
	}
 #restCount{
	font-size:1.5em;
	background:rgba(0,0,0,0.2);
	border-radius:5%;
	
} 

</style>
<script>
	$(function(){
			
		$(document).on('click','#insertbtn',function(){
			
			if($("#ord_count").val()==""){
				alert("수량을 입력하세요.")
				return false;
			}
			var reg = /[0-9]+$/
			if(!reg.test($("#ord_count").val())){
				alert("숫자만 입력 가능합니다.");
				return false;
			}
		
			alert("주문이 진행됩니다.");
			opener.location.href = "orderForm";
			window.close();
			
		})
		
		
	})
	
	
</script>
		<section id="cta">

					<h2>공구 참여하기</h2>
					<p>수량을 입력시 결제하기가 진행됩니다!</p>
	<form>
					<div class="row gtr-50 gtr-uniform">
							<div class="col-8 col-12-mobilep">
							
								<p id="restCount">12</p>
							
							</div>
							<br/>
							<div class="col-4 col-12-mobilep">
							
								<p id="restCount">남은 수량</p>
						
							</div>
					</div>
		
						<div class="row gtr-50 gtr-uniform">
							<div class="col-8 col-12-mobilep">
								<input type="text" name="ord_count" id="ord_count" placeholder="수량을 입력하세요!" />
							</div>
							<div class="col-4 col-12-mobilep">
								<input type="submit" id="insertbtn" value="입력하기" class="fit" />
							</div>
						</div>
					</form>

		</section>	