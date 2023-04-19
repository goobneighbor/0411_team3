<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 오프라인 공구 방(?) -->
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
		background-color : red;
		color:#fff;
		float:right		
	}
	.party{
		list-style-type: none;
		float:left;
		text-align: center;
	}
</style>
<script>
	
</script>
	<!-- Header-->
	<header class="bg-tomato py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
	        	<h1 class="display-4 fw-bolder" style="color:#FFF">오프라인 공동구매 상세페이지</h1>	           
	        </div>
	    </div>
	</header>
<div class="container">	
	<ul id="view">
		<li>원글번호 : ${dto.off_no}</li>	
		<li>제목 : ${dto.off_subject}</li>
		<li>등록일 : ${dto.writedate}</li>	
		<li>작성자 : ${dto.userid}</li>			
		<li>모집인원 : ${dto.group_num}</li>
		<li>현재인원 : ${dto.current_num}</li>			
		<li>모집마감일 : ${dto.deaddate}</li>				
		<li>만남시간 : ${dto.app_time}</li>					
		<li>상세정보 : ${dto.off_content}</li>			
	</ul>
	<ul class="party">		
		<li>참가자정보</li>
		<c:forEach var="pDTO" items="${list}" varStatus="status">
			<li>${status.count}번째 참가자</li>
			<li>아이디 : ${pDTO.userid}</li>
			<li>이름 : ${pDTO.username}</li>
			<li>연락처: ${pDTO.tel}</li><hr/>
		</c:forEach>
	</ul>
</div>