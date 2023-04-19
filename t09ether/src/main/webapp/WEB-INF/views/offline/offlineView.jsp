<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#view>li{
			padding:5px 0;
			border-bottom:1px solid #ddd;
			list-style-type: none;
		}
	.boardSubMenu{
		background: #fff;
		padding:50px 0;
	}
	#commentList>li{
			padding:10px;
			border-bottom:1px solid #ddd;
		}
	#coment{
			width:50%;
			height:80px;
		}
	.bg-tomato py-5{
		margin:0;
		padding:0;
	}
	
	.jr{
		list-style-type: none;
	}
	.join{
		width:110px;
		border:1px solid tomato;
		border-radius: 10px;
		background-color : yellow;	
		float:left;	
		
	}
	.report{
		width:100px;
		border:1px solid tomato;
		border-radius: 10px;
		background-color : orange;
		color:#fff;
		float:right;	
		text-align: center;
	}
	#offlineJoin{
		margin:0 auto;
		float:left;
		text-align: center;
	}
	
</style>
<script>
	function offlineDel(){
		if(confirm("정말 삭제하시겠습니까?")){
			location.href="offlineDel?off_no=${dto.off_no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>";
		}	
	}
	
</script>
<div class="container">
	<!-- Header-->
	<header class="bg-tomato py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
	        	<h1 class="display-4 fw-bolder" style="color:#FFF">오프라인 공동구매 참여하기</h1>	           
	        </div>
	    </div>
	</header>
	<ul id="view">
		<li>번호 : ${dto.off_no}</li>	
		<li>제목 : ${dto.off_subject}</li>
		<li>등록일 : ${dto.writedate}</li>	
		<li>작성자 : ${dto.userid}</li>		
		<li>조회수 : ${dto.off_hit}</li>	
		<li>모집인원 : ${dto.group_num}</li>
		<li>현재인원 : ${dto.current_num}</li>	
		<li>모집마감일 : ${dto.deaddate}</li>				
		<li>만남시간 : ${dto.app_time}</li>					
		<li>상세정보 : ${dto.off_content}</li>
		
		<li class="report"><a href="">신고하기</a></li>
			
	</ul>
	<form method="post" action="offlineJoin" id="offlineJoin">
			<input type="submit" value="지금참여하기"/>
			<input type="hidden" name="dto" value="${dto}"/>
	</form>
			
	<div class="boardSubMenu">		
		<!-- 작성자와 로그인 아이디 같은경우 수정 삭제 버튼 -->		
		<c:if test="${logId==dto.userid}">
			<a href="offlineEdit?off_no=${dto.off_no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">수정</a>
			<a href="javascript:offlineDel()">삭제</a>
		</c:if>
	</div>
	
	
</div>