<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.board_header{
		padding:30px;
		background-color:tomato;
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
	.board_list li:nth-child(7n+1){
		width:5%;
		text-align: center;	
	}
	.board_list li:nth-child(7n+2){
		width:15%;
		/*말줄임표시하기*/
		white-space: nowrap;/*줄바꾸지않는다*/
		overflow:hidden;
		text-overflow:ellipsis;/*넘친데이터 말줄임표시*/	
		text-align: center;	
	}
	.board_list li:nth-child(7n+4){
		width:40%;
		/*말줄임표시하기*/
		white-space: nowrap;/*줄바꾸지않는다*/
		overflow:hidden;
		text-overflow:ellipsis;/*넘친데이터 말줄임표시*/	
		text-align: center;	
	}
	
	.board_list li:nth-child(7n+7){
		width:15%;		
		white-space: nowrap;
		overflow:hidden;
		text-overflow:ellipsis;	
	}
	.board_list li:nth-child(7n+3), board_list li:nth-child(7n+6){
		width:5%;		
		white-space: nowrap;
		overflow:hidden;
		text-overflow:ellipsis;	
	}
	
	.pHeader>div{	
		width:50%;
		float:left;
		padding:10px 0;
		background : #888;
	}
	.pHeader>div:last-child{
		text-align: right;
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
	.searchDiv{
		clear:left;
		padding:10px;
		text-align: center;
	}
</style>

<div class="container">
	<h1>오프라인 공구 게시판</h1>
	<div class="board_header"><a href="offlineWrite">글쓰기</a></div>
	<div class = "pHeader">
		<div>진행중인 공구 : ${vo.totalRecord}건 </div>
		<div>${vo.nowPage}페이지/${vo.totalPage}페이지</div>		
	</div>
	
	<ul class="board_list">
		<li>번호</li>		
		<li>지역</li>
		<li>인원</li>
		<li>제목</li>
		<li>작성자</li>
		<li>조회수</li>
		<li>등록일</li>
		
		<li>1</li>		
		<li>서울시 서초구</li>
		<li>3</li>
		<li><a href="offline/offlineView">코스트코 양재점 같이가실분 구해요</a></li>
		<li>홍길동</li>
		<li>3</li>
		<li>04-13</li>
		
		<li>2</li>		
		<li>서울시 중랑구</li>
		<li>4</li>
		<li>코스트코 상봉점 같이 가실분 구합니다</li>
		<li>이순신</li>
		<li>4</li>
		<li>04-13</li>
		
		<li>3</li>		
		<li>지역</li>
		<li>인원</li>
		<li>제목</li>
		<li>작성자</li>
		<li>조회수</li>
		<li>등록일</li>
		
		<c:forEach var="offDTO" items="${list}">					
				<li>${offDTO.off_no}</li>
				<!-- 글내용보기 : 레코드번호, 현재페이지, 검색어가 있다면 검색키와 검색어 가지고 뷰페이지로 이동하여야 
				다시 목록으로 올 때 해당 검색과 페이지도 이동할 수 있다-->
				<li><a href="boardView?no=${offDTO.off_no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">${bDTO.subject}</a></li>
				<li>${offDTO.userid }</li>
				<li>${offDTO.off_hit }</li>
				<li>${offDTO.writedate }</li>
		</c:forEach>
				
	</ul>

</div>

</body>
