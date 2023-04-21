<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
#finalPayment{
	list-style-type:none;
	float:right;
	text-align:center; 
}
#finalPayment li{
	float:left;
	font-size:1.2em;
	width:150px;
	height:40px;
	line-height:40px;
}

</style>
<script>
	window.name="orderForm"
	var ord_total = ${Math.ceil(pdto.pro_price/pdto.pro_total)*dto.ord_count }
	console.log(ord_total)
</script>
;
		
	<section id="main" class="container">
		<header>
			<h2>주문하기</h2>
			<p>${logName } 님은 현재 ${dto.rank} 등급입니다! <br/>할인을 확인하시고 결제진행해주세요!</p>
		</header>
		<div class="row">
			<div class="col-12">

			<!-- 주문내역 리스트 -->
				<section class="box">
					<div class="table-wrapper">
						<table>
							<thead>
								<tr>
									<th>주문일</th>
									<th>상품명</th>
									<th>수량</th>
									<th>금액</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>2023.03.26</td>
									<td>${pdto.pro_name }</td>
									<td>${dto.ord_count }</td>
									<td> ${Math.ceil(pdto.pro_price/pdto.pro_total)*dto.ord_count }</td>
								<tr>
							</tbody>
						</table>
						<div id="finalPayment">
							<div style="font-size:0.7em">
								<li>총금액 * 할인율</li>
								<li>할인금액</li>
							</div>
							<div >
								<li> ${Math.ceil(pdto.pro_price/pdto.pro_total)*dto.ord_count } * 10%</li>
								<li>${Math.ceil(pdto.pro_price/pdto.pro_total*dto.ord_count*0.1) }</li>
							</div>
							<div style="font-size:0.7em">
								<li>총금액 - 할인금액</li>
								<li>최종금액</li>
							</div>
							<div >
								<li>${Math.ceil(pdto.pro_price/pdto.pro_total)*dto.ord_count } - ${Math.ceil(pdto.pro_price/pdto.pro_total*dto.ord_count*0.1) }</li>
								<li>${Math.ceil(pdto.pro_price/pdto.pro_total)*dto.ord_count - Math.ceil(pdto.pro_price/pdto.pro_total*dto.ord_count*0.1) }</li>
							</div>
						</div>
					</div>
					</section>
						<div class="text-center"><a class="btn btn-outline-dark mt-auto" href="">결제하기</a></div>
					</div>
				</div>
	</section>