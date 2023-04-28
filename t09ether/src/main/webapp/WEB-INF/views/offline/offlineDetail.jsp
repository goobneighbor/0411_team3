<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 오프라인 공구 방(?) -->
<style>
	li{list-style-type: none;}
	#view>li{
			padding:5px 0;
			border-bottom:1px solid #ddd;
			list-style-type: none;
		}		
	.bg-tomato py-5{
		margin:0;
		padding:0;
	}
	.participantInfo{
		border: none;;
		font-size: 1.5em;
		color:tomato;
	}	
	.goComment{
		margin:10px auto;
<<<<<<< HEAD
		padding: 5px 5px;
		width:240px;
=======
		width:220px;
>>>>>>> e1553b84b7f1106e38dcfebd49b677c1b3164044
		font-size: 1.6em;
		border:1px solid tomato;
		border-radius: 10px;
		background-color:#FFD777;
		color: white;
		
	}
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	  text-align: center;
	}
	.theader th{
		text-align: center;
	}
	td, th {
	  border: 1px solid #dddddd;
	  padding: 8px;
	}

	tr:nth-child(even) {
	  background-color: orange;
	}
	tr:nth-child(odd) {
	  background-color: yellow;
	}
<<<<<<< HEAD
	
	.offlineClose{
		margin:0 auto;
	}
	#closeButton{
		margin:10px auto;
		padding:0;
		width:220px;
		font-size: 1.6em;
		border:1px solid tomato;
		border-radius: 10px;
		background-color:#F79540;
		color:#FEE8B0;		
	}
	.buttonDiv{
		margin:0 auto;
	}
	.participantInfo{
		margin:0 auto;
		text-align: center;
		
	}
	.participantInfo h2{
		font-size: 2em;
		color: #9CA777;
	}
	
=======
>>>>>>> e1553b84b7f1106e38dcfebd49b677c1b3164044
</style>
<script>
	
</script>
	<!-- Header-->
	<header class="bg-tomato py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">	        	
	        	<h1 class="display-4 fw-bolder" style="color:#FFF">${dto.userid}님의 공동구매</h1>	           
<<<<<<< HEAD
	        	<h3 style="color:orange;">약속시간이 가까워지면 문자로 안내드립니다 즐거운시간되세요!</h3>
	        	<div class="goComment"><a href="offlineComment?off_no=${dto.off_no}">일정조율하러가기</a></div>	    
=======
	        	<div class="goComment"><a href="offlineComment?off_no=${dto.off_no}">일정조율하러가기</a></div>
>>>>>>> e1553b84b7f1106e38dcfebd49b677c1b3164044
	        </div>
	    </div>
	</header>
	
<div class="container">	
	<ul id="view">		
		<li>제목 : ${dto.off_subject}</li>
		<li>처리상태 : 
			<c:choose>
				<c:when test="${dto.status==1}">진행중</c:when>
				<c:otherwise>종료</c:otherwise>
			</c:choose>
		</li>			
		<li>작성자 : ${dto.userid}</li>			
		<li>모집인원 : ${dto.group_num}</li>
		<li>현재인원 : ${dto.current_num}</li>			
		<li>모집마감일 : ${dto.deaddate}</li>				
		<li>만남시간 : ${dto.app_time}</li>					
<<<<<<< HEAD
		<li>상세정보 : ${dto.off_content}</li>	
		
	</ul>
	<form method="get" action="offlineClose" class="offlineClose">
		<input type="hidden" name="off_no" value="${dto.off_no}"/>
		<div class="buttonDiv">
			<c:if test="${logStatus=='Y'}">
				<input type="submit" value="모집마감하기" id="closeButton"/>	
			</c:if>
		</div>
	</form>
	<div class="participantInfo"><h2>[참가자 정보]</h2></div>
=======
		<li>상세정보 : ${dto.off_content}</li>		
		<li class="participantInfo">참가자 정보</li>
	</ul>
	
>>>>>>> e1553b84b7f1106e38dcfebd49b677c1b3164044
	<div id="participantList" style="border:2px solid orange;">		
		<table>
			<tr class="theader">
			    <th>번호</th>
			    <th>아이디</th>
			    <th>이름</th>
			    <th>연락처</th>
			</tr>			  
		<c:forEach var="opDTO" items="${list}" varStatus="status">
			<tr class="infoDetail">
				<td style="width:6%; text-align:center;">${status.count}</td>
				<td>${opDTO.userid}<c:if test="${opDTO.userid==dto.userid}"> (방장)</c:if></td>
				<td>${opDTO.username}</td>
				<td>${opDTO.tel}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</div>