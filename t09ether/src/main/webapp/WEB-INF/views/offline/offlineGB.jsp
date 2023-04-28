<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	
		
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
<div class="container">	
	<div class="board_header"><h3><a href="offlineWrite">오프라인공구 시작하기</a></h2></div>
	<div class = "pHeader">
		<div>진행중인 공구 : ${vo.totalRecord }건 </div>
		<div>${vo.nowPage}페이지/${vo.totalPage}페이지</div>			
	</div>	
	<!-- 페이지번호, 검색어, 검색키 -->
	<input type="hidden" name="nowPage" value="${vo.nowPage }"/>
	<c:if test="${vo.searchWord!=null}">
		<input type="hidden" name="searchKey" value="${vo.searchKey }"/>
		<input type="hidden" name="searchWord" value="${vo.searchWord }"/>
	</c:if>	
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
	                    <img class="card-img-top" src="./resources/images/cart1jpg.jpg" alt="image" />
	                    	
	                    	<!-- Product details-->
	                        <div class="card-body p-4">
	                        	<div class="text-center">
	                            	<!-- Product name-->
	                                <h5 class="fw-bolder">${proDTO.off_subject}</h5>
	                                <!-- Product price-->
	                                
	                                <div>총&nbsp;&nbsp;원</div>
	                                개당&nbsp;&nbsp;원
	                            </div>
	                        </div>
	                        <!-- Product actions-->
	                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                        	<div class="text-center"><a class="btn btn-outline-dark mt-auto" href="">구매하기</a></div>
	                        </div>
	                 </div>
	            </div>
	            <c:set var="recordNum" value="${recordNum-1 }"></c:set>
            </c:forEach>
     <!-- 여기에 있던 코드 잠시 테스트로 인해 뺌 -->
        </div>
    </div>
    <div class="pagingDiv" id="wrapper">
		<div id="item">
		<ul>
			<!-- nowPage -->
			<c:if test="${vo.nowPage==1}"> <!-- 현재페이지가 1일때 -->
				<li>prev</li>
			</c:if>
			<c:if test="${vo.nowPage>1}"> <!-- 현재페이지가 1아닐때 -->
				<li><a href="offline?nowPage=${vo.nowPage-1}<c:if test="${vo.searchWord != null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">prev</a></li>
			</c:if>
			
			<!-- 페이지번호 -->
			<c:forEach var="p" begin="${vo.startPageNum}" end="${vo.startPageNum+ vo.onePageNumCount-1}">
				<c:if test="${p <= vo.totalPage}"> <!-- 표시할 페이지 번호가 총페이지 수보다 작거나 같을 때 페이지 번호를 출력한다 -->
					<!-- 현재페이지 표시하기 -->
				<c:if test ="${p==vo.nowPage }">
					<li style="background:orange;">
				</c:if>	
				<c:if test ="${p!=vo.nowPage }">
					<li>
				</c:if>
					<a href="offline?nowPage=${p}<c:if test="${vo.searchWord != null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">${p}</a></li>
				</c:if>
			</c:forEach>
			
			
			<!-- 다음페이지 -->
			<c:if test="${vo.nowPage==vo.totalPage}"> <!-- 현재페이지가 마지막일때 -->
				<li>next</li>
			</c:if>
			<c:if test="${vo.nowPage<vo.totalPage}"> <!-- 현재페이지가 마지막 아닐때 -->
				
				<li><a href="offline?nowPage=${vo.nowPage+1}<c:if test="${vo.searchWord != null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">next</a></li>			
				
			</c:if>
			
		</ul>
		</div>	
	</div>
</section>
</div>
