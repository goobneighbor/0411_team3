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
		width:220px;
		font-size: 1.6em;
		border:1px solid tomato;
		border-radius: 10px;
		background-color:#FFD777;
		color: red;
		
	}
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	  text-align: center;
	}

	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}

	tr:nth-child(even) {
	  background-color: orange;
	}
	tr:nth-child(odd) {
	  background-color: yellow;
	}
</style>
<script>
	
</script>
	<!-- Header-->
	<header class="bg-tomato py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
	        	<h1 class="display-4 fw-bolder" style="color:#FFF">${dto.userid}님의 공동구매</h1>	           
	        </div>
	    </div>
	</header>
	
<div class="container">	
	<ul id="view">		
		<li>제목 : ${dto.off_subject}</li>			
		<li>작성자 : ${dto.userid}</li>			
		<li>모집인원 : ${dto.group_num}</li>
		<li>현재인원 : ${dto.current_num}</li>			
		<li>모집마감일 : ${dto.deaddate}</li>				
		<li>만남시간 : ${dto.app_time}</li>					
		<li>상세정보 : ${dto.off_content}</li>	
		<li class="goComment"><a href="offlineComment?off_no=${offDTO.off_no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">일정조율하러가기</a></li>		
		<li class="participantInfo">참가자 정보</li>
	</ul>
	
	<div id="participantList" style="border:2px solid orange;">		
		<table>
			<tr>
			    <th>번호</th>
			    <th>아이디</th>
			    <th>이름</th>
			    <th>연락처</th>
			  </tr>
		<c:forEach var="opDTO" items="${list}" varStatus="status">
			<tr class="infoDetail">
				<td style="width:5%;">[${status.count}]</td>
				<td>${opDTO.userid}</td>
				<td>${opDTO.username}</td>
				<td>${opDTO.tel}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</div>