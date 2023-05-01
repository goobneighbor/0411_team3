<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(function(){ 
		var totalprice=document.getElementById('totalprice').innerHTML; 
		totalprice = Math.floor(totalprice/10)*10; 
		totalprice= totalprice.toLocaleString() 
		document.getElementById('totalprice').innerHTML = totalprice; 
		
		var oneprice=document.getElementById('oneprice').innerHTML; 
		oneprice = Math.floor(oneprice/10)*10; 
		oneprice = oneprice.toLocaleString() 
		document.getElementById('oneprice').innerHTML = oneprice; 
});
</script>
<style>
	.pagingDiv li{
		float:left;
		border:1px solid #000;
		padding: 10px 20px;
		list-style: none;
	}
	.pagingDiv a:link, .pagingDiv a:hover, .pagingDiv a:visited{
		color:#000;
	}
	.pagingDiv ul{
		margin:0 auto;
	}
</style>
<!-- Header-->
<header class="bg-tomato py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
        	<h1 class="display-4 fw-bolder" style="color:#FFF">온라인 공동구매</h1>
            <p class="lead fw-normal text-white-75 mb-0">공동구매를 시작하거나 참여해보세요.</p>
        </div>
    </div>
</header>

<!-- Section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        	<input type="hidden" name="nowPage" value="${vo.nowPage }"/>
  			<!-- 시작번호 설정 -->
			<c:set var="recordNum" value="${vo.totalRecord -(vo.nowPage -1)*vo.onePageRecord }"></c:set>
        	<c:forEach var="proDTO" items="${list}">
	        	<div class="col mb-5">
	            	<div class="card h-100">
	                	<!-- Product image-->
	                    <img class="card-img-top" src="${proDTO.image }" alt="${proDTO.pro_name }" />
	                    	
	                    	<!-- Product details-->
	                        <div class="card-body p-4">
	                        	<div class="text-center">
	                            	<!-- Product name-->
	                                <h5 class="fw-bolder">${proDTO.pro_name }</h5>
	                                <!-- Product price-->
	                                <!-- 원래 가격 줄그어서 세일 표시하는 스타일
	                                <span class="text-muted text-decoration-line-through">총${proDTO.pro_price }원</span> 
	                                --> 
	                                <div>총&nbsp;<span id="totalprice">${proDTO.pro_price }</span>&nbsp;원</div>
	                                <div>개당&nbsp;<span id="oneprice">${ Math.floor(proDTO.pro_price/proDTO.pro_total/10)*10 }</span>&nbsp;원</div>
	                            </div>
	                        </div>
	                        <!-- Product actions-->
	                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                        	<div class="text-center"><a class="btn btn-outline-dark mt-auto" href="productDetail?pro_code=${proDTO.pro_code }">구매하기</a></div>
	                        </div>
	                 </div>
	            </div>
	            <c:set var="recordNum" value="${recordNum-1 }"></c:set>
            </c:forEach>
     <!-- 여기에 있던 코드 잠시 테스트로 인해 뺌 -->
        </div>
    </div>
    <div class="pagingDiv">
				<ul>
					<!-- nowPage -->
					<c:if test="${vo.nowPage==1 }"> <!-- 현재페이지가 첫번째 페이지 일때 -->
						<li>이전</li>
					</c:if>
					
					<c:if test="${vo.nowPage>1 }"> <!-- 현재페이지가 첫번째 페이지가 아닐때 -->
						<li><a href="onlineHome?nowPage=${vo.nowPage-1 }">이전</a></li>
					</c:if>
					<!-- 페이지번호 -->
					<c:forEach var="p" begin="${vo.startPageNum }" end="${vo.startPageNum+vo.onePageNumCount-1 }">
						<c:if test="${p <= vo.totalPage }"><!-- 표시할 페이지번호 총페이지수보다 작거나 같을때 페이지번호를 출력한다. -->	
							<!-- 현재페이지 표시하기 -->
							<c:if test="${p==vo.nowPage }">
								<li style="background:#ddd;"> 
							</c:if>
							<c:if test="${p!=vo.nowPage }">
								<li id="sort">
							</c:if>
								<a href="onlineHome?nowPage=${p}">${p }</a></li>
						</c:if>
					</c:forEach>
					
					<!-- 다음페이지 -->
					<c:if test="${vo.nowPage<vo.totalPage }">
						<li><a href="onlineHome?nowPage=${vo.nowPage+1 }">다음</a></li>
					</c:if>
					<c:if test="${vo.nowPage==vo.totalPage }">
						<li>다음</li>
					</c:if>
				</ul>
	</div>
</section>

