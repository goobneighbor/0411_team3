<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.board_header{
		margin:20px;
		padding:30px;
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
	.board_list li:nth-child(8n+1){
		width:5%;
		text-align: center;	
	}
	.board_list li:nth-child(8n+2){
		width:15%;
		/*말줄임표시하기*/
		white-space: nowrap;/*줄바꾸지않는다*/
		overflow:hidden;
		text-overflow:ellipsis;/*넘친데이터 말줄임표시*/	
		text-align: center;	
	}
	.board_list li:nth-child(8n+4){
		width:30%;
		/*말줄임표시하기*/
		white-space: nowrap;/*줄바꾸지않는다*/
		overflow:hidden;
		text-overflow:ellipsis;/*넘친데이터 말줄임표시*/	
		text-align: center;	
	}
	
	.board_list li:nth-child(8n+7){
		width:15%;		
		white-space: nowrap;
		overflow:hidden;
		text-overflow:ellipsis;	
	}
	.board_list li:nth-child(8n+3), board_list li:nth-child(8n+6){
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
<!-- Header-->
<header class="bg-tomato py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
        	<h1 class="display-4 fw-bolder" style="color:#FFF">오프라인 공동구매</h1>
            <p class="lead fw-normal text-white-75 mb-0">공동구매를 시작하거나 참여해보세요.</p>
        </div>
    </div>
</header>
<div class="container">	
	<div class="board_header"><h3><a href="offlineWrite">오프라인공구 시작하기</a></h3></div>
	<div class = "pHeader">
		<div>진행중인 공구 : ${vo.totalRecord } </div>
		<div>${vo.totalPage}페이지/${vo.nowPage}페이지</div>		
	</div>
	<form method="post" action="/campus/board/boardMultiDel" id="delList">
		<!-- 페이지번호, 검색어, 검색키 -->
		<input type="hidden" name="nowPage" value="${vo.nowPage }"/>
		<c:if test="${vo.searchWord!=null}">
			<input type="hidden" name="searchKey" value="${vo.searchKey }"/>
			<input type="hidden" name="searchWord" value="${vo.searchWord }"/>
		</c:if>
		<ul class="board_list">			
			<li>번호</li>
			<li>지역</li>
			<li>인원</li>
			<li>제목</li>
			<li>작성자</li>
			<li>조회수</li>
			<li>등록일</li>
			<li>마감일</li>
			<!-- 시작번호 설정       :                 총 레코드 수       현재페이지        한페이지레코드수-->	
			<c:set var="recordNum" value="${vo.totalRecord - (vo.nowPage-1)*vo.onePageRecord}"/>
			<c:forEach var="offDTO" items="${list}">				
				<li>${offDTO.off_no}</li>
				<li>${offDTO.location}</li>
				<li>${offDTO.current_num}/${offDTO.group_num}</li>
				<!-- 글내용보기 : 레코드번호, 현재페이지, 검색어가 있다면 검색키와 검색어 가지고 뷰페이지로 이동하여야 
				다시 목록으로 올 때 해당 검색과 페이지도 이동할 수 있다-->
				<li><a href="offlineView?off_no=${offDTO.off_no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">${offDTO.off_subject}</a></li>
				<li>${offDTO.userid }</li>
				<li>${offDTO.off_hit }</li>
				<li>${offDTO.writedate }</li>
				<li>${offDTO.deaddate}</li>
				<c:set var="recordNum" value="${recordNum-1}"/>
			</c:forEach>
		</ul>
	</form>
	
	<!-- 페이징 -->	
	<div class="pagingDiv">
		<ul>
			<!-- nowPage -->
			<c:if test="${vo.nowPage==1}"> <!-- 현재페이지가 1일때 -->
				<li>prev</li>
			</c:if>
			<c:if test="${vo.nowPage>1}"> <!-- 현재페이지가 1아닐때 -->
				<li><a href="boardList?nowPage=${vo.nowPage-1}<c:if test="${vo.searchWord != null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">prev</a></li>
			</c:if>
			
			<!-- 페이지번호 -->
			<c:forEach var="p" begin="${vo.startPageNum}" end="${vo.startPageNum+ vo.onePageNumCount-1}">
				<c:if test="${p <= vo.totalPage}"> <!-- 표시할 페이지 번호가 총페이지 수보다 작거나 같을 때 페이지 번호를 출력한다 -->
					<!-- 현재페이지 표시하기 -->
				<c:if test ="${p==vo.nowPage }">
					<li style="background:#ddd;">
				</c:if>	
				<c:if test ="${p!=vo.nowPage }">
					<li>
				</c:if>
					<a href="boardList?nowPage=${p}<c:if test="${vo.searchWord != null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">${p}</a></li>
				</c:if>
			</c:forEach>
			
			
			<!-- 다음페이지 -->
			<c:if test="${vo.nowPage==vo.totalPage}"> <!-- 현재페이지가 마지막일때 -->
				<li>next</li>
			</c:if>
			<c:if test="${vo.nowPage<vo.totalPage}"> <!-- 현재페이지가 마지막 아닐때 -->
				
				<li><a href="boardList?nowPage=${vo.nowPage+1}<c:if test="${vo.searchWord != null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">next</a></li>			
				
			</c:if>
			
		</ul>
	</div>
	<!--검색 -->
	
	<div class ="searchDiv">
		<form method="get" id="searchForm" action="boardList">
			<select name = "searchKey">
				<option value="subject">제목</option>
				<option value="username">작성자</option>
				<option value="content">글내용</option>
			</select>
			<input type="text" name="searchWord" id="searchWord"/>
			<input type="submit" value="Search"/>
		</form>
	
	</div>

</div>

</body>
