<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 오프라인 공구 참여자 상세정보(리뷰) 보기 팝업창 -->
<style>
	#footer{
		display: none;
	}
	ul,li{
		list-style-type: none;
	}
	
	.pHeader>div{	
		margin:10px 0;
		width:100%;
		float:left;
		padding:10px;
		background :orange;
	}
	.board li{
		float:left;
		height:40px;
		line-height: 40px;
		border-bottom: 1px solid gray;
		/*말줄임표시하기*/
		white-space: nowrap;/*줄바꾸지않는다*/
		overflow:hidden;
		text-overflow:ellipsis;/*넘친데이터 말줄임표시*/	
		text-align: center;
	}
	
	.board li:nth-child(4n+1){/*공구번호*/
		width:10%;
	}
	.board li:nth-child(4n+2){/*작성자*/
		width:20%;
	}
	.board li:nth-child(4n+3){/*내용*/
		width:50%;
	}
	.board li:nth-child(4n){/*작성일*/
		width:20%;
	}
	.goBack{
		margin: 20px 0 0 10px;
		width:1800px;
		height:50px;
		background: #00FFCA;
		border:1px solid #ddd;
	}
	.noReview{
		text-align: center;
		font-size: 2em;
	}
	
</style>
<script>

</script>

<!-- Header-->
<header class="bg-tomato py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
        	<h1 class="display-4 fw-bolder" style="color:#FFF">${dto.userid}님이 받은 리뷰</h1>        
        </div>
    </div>
</header>	
<div class="container">	
	<div class = "pHeader">
		<div>리뷰 수 : ${reviewCount} </div>
	</div>
	
	
		
	<c:choose>
			<c:when test="${reviewCount==0}">
				<div class="noReview">아직 작성된 리뷰가 없습니다 <br/>첫 리뷰를 작성해보세요!<hr/></div>
			</c:when>
			<c:otherwise>		
				<ul class="board">
					<li>공구번호</li>
					<li>작성자</li>
					<li>내용</li>
					<li>작성일</li>
					<c:forEach var="rDTO" items="${list}">
						<li>${rDTO.off_no}</li>
						<li>${rDTO.userid}</li>
						<li>${rDTO.content}</li>
						<li>${rDTO.writedate }</li>
					</c:forEach>
				</ul>	
			</c:otherwise>		
				
		</c:choose>		
	
	<a href="javascript:history.back();" class="goBack">뒤로가기</a>
</div>