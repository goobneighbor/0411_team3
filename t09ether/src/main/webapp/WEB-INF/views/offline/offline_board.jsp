<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	li{
		list-style-type: none;
	}
	.board_header{
		margin:30px;
		padding:20px;
		width:350px;
		height:70px;
		background-color:tomato;
		text-align: center;
		border-radius: 10px;
	}
	.board_header a{
		color:white;
	}
	
	.board_list{
		text-decoration: none;
	}
	.board_list li{
		float:left;
		width:10%;
		height:40px;
		line-height:40px;
		border-bottom:1px solid gray;
		text-overflow:ellipsis;/*넘친데이터 말줄임표시*/	
		white-space: nowrap;/*줄바꾸지않는다*/
		overflow:hidden;
		text-align: center;
	}
	.board_list li:nth-child(8n+1){/*글번호*/
		width:5%;
		text-align: center;	
	}
	.board_list li:nth-child(8n+2){/*지역*/
		width:15%;
		/*말줄임표시하기*/
		white-space: nowrap;/*줄바꾸지않는다*/
		overflow:hidden;
		text-overflow:ellipsis;/*넘친데이터 말줄임표시*/	
		text-align: center;	
	}
	.board_list li:nth-child(8n+4){/*글제목*/
		width:35%;
		/*말줄임표시하기*/
		white-space: nowrap;/*줄바꾸지않는다*/
		overflow:hidden;
		text-overflow:ellipsis;/*넘친데이터 말줄임표시*/	
		text-align: center;	
	}
	
	.board_list li:nth-child(8n+7),.board_list li:nth-child(8n+8){/*등록일, 마감일*/
		width:10%;		
		white-space: nowrap;
		overflow:hidden;
		text-overflow:ellipsis;	
	}
	
	.board_list li:nth-child(8n+3), board_list li:nth-child(8n+6){/*인원, 조회수*/
		width:5%;		
		white-space: nowrap;
		overflow:hidden;
		text-overflow:ellipsis;	
	}
	
	.pHeader>div{	
		width:50%;
		float:left;
		padding:10px 0;
		background :orange;
	}
	.pHeader>div:last-child{
		text-align: right;
	}
	.pagingDiv{		
		text-align: center;
		border:1px solid orange;
	}
	.pagingDiv li{
		float:left;
		padding:10px 20px;
	}
	.pagingDiv a:link, .pagingDiv a:hover, .pagingDiv a:visited{
		color:#000;
	}
	.board_list a:link, .board_list a:hover, .board_list a:visited{
		color:#000;
	}
	.listDiv a:hover, .listDivt a:visited{
		color:tomato;
	}
	.searchDiv{
		clear:left;
		margin:0;
		padding:0;
		text-align: center;		
	}
	#wrapper{
		display: grid;
     	place-items: center;
     	min-height: 5vh;
     	margin:0 auto;
	}
	.text-center2{
		width: 100px;
		margin:0 auto;
		text-align:center;
		border : 1px solid #ddd;
		border-radius: 10px;
		background-color: orange;
	}
</style>
<script>
	$(function(){
		$("#searchForm").submit(function(){
			if($("#searchWord").val()==""){
				alert("검색어를 입력하세요....");
				return false;
			}
			return true;
		});
</script>
<!-- Header-->
<header class="bg-tomato py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
        	<h1 class="display-4 fw-bolder" style="color:#FFF">오프라인 공동구매</h1>
            <p class="lead fw-normal text-white-75 mb-0">같이 쇼핑할 사람들을 찾아보세요!</p>
            <a href="<%=request.getContextPath()%>/offlineGB">오프라인 갤러리 게시판(테스트)</a>
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
        	<c:forEach var="offDTO" items="${list}">
	        	<div class="col mb-5">
	            	<div class="card h-100">
	                	<!-- Product image-->
	                    <img class="card-img-top" src="./resources/images/cart1jpg.jpg" alt="image" />
	                    	
	                    	<!-- details-->
	                        <div class="card-body p-4">
	                        	<div class="text-center">
	                            	<!-- name-->
	                                <h5 class="fw-bolder">${offDTO.off_subject}</h5>
	                                <!-- details-->	                                
	                                <div>${offDTO.location}</div>
	                                <div>${offDTO.current_num}명/${offDTO.group_num}명</div>
	                                <c:choose>
										<c:when test="${offDTO.status==1}"><li style="color:green;">모집중</li></c:when>
										<c:otherwise><li style="color:red;">마감</li></c:otherwise>				
									</c:choose>	
	                            </div>
	                        </div>
	                        <!-- Product actions-->
	                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                        	<div class="text-center2"><a href="offlineView?off_no=${offDTO.off_no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">참여하기</a></div>
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
</div>

</body>
