<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 오프라인 공구 종료 -->
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
	.info{
		margin:30px auto;
		color:#7AA874 !important;
		text-align: center;
	}
	.participantInfo{
		border: none;;
		font-size: 1.5em;
		color:tomato;
	}	
	.goComment{
		margin:10px auto;
		width:220px;
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
	.offlineClose{
		margin:10px auto;
		width:220px;
		font-size: 1.6em;
		border:1px solid tomato;
		border-radius: 10px;
		background-color:#FFEBEB;
		color: white;
		
	}
	#offlineReview{
		padding:0;
		height:50px;
	}
	.tdReview{
		margin:auto;
		padding:0 auto;;
		height:50px;
	}
</style>
<script>
	
</script>
	<!-- Header-->
	<header class="bg-tomato py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">	        	
	        	<h1 class="display-4 fw-bolder" style="color:#FFF">공동구매가 종료되었습니다</h1>	          
	        	<h3 style="color:#FEE8B0">만족스러우셨나요? 같이 참여한 사람들에 대한 리뷰를 남겨보세요!</h3>
	        </div>
	    </div>
	</header>
	
<div class="container">	
	<div class="info"><h2>[공동구매 상세정보]</h2></div>
	
	<ul id="view">
		
		<li>제목 : ${dto.off_subject}</li>				
		<li>작성자 : ${dto.userid}</li>			
		<li>모집인원 : ${dto.group_num}</li>				
		<li>모집마감일 : ${dto.deaddate}</li>				
		<li>만남시간 : ${dto.app_time}</li>					
		<li>상세정보 : ${dto.off_content}</li>		
		<li class="participantInfo">참가자 정보</li>
	</ul>
	
	
	<div id="participantList" style="border:2px solid orange;">		
		<table>
			<tr class="theader">
			    <th>번호</th>
			    <th>아이디</th>
			    <th>이름</th>
			    <th>연락처</th>
			    <th>리뷰쓰러가기</th>
			    <th>신고하기</th>
			</tr>			  
		<c:forEach var="opDTO" items="${list}" varStatus="status">
			<tr class="infoDetail">
				<td style="width:6%; text-align:center;">${status.count}</td>
				<td>${opDTO.userid}<c:if test="${opDTO.userid==dto.userid}">(방장)</c:if></td>
				<td>${opDTO.username}</td>
				<td>${opDTO.tel}</td>
				<td class="tdReview">	
					<form method="post" action="offlineReview" id="offlineReview">
						<input type="hidden" name="off_no" value="${dto.off_no}"/>	
						<input type="hidden" name="target_id" value="${opDTO.userid}"/>			
						<input type="submit" name ="review "value="리뷰" class="reviewButton"/>
					</form>	
				</td>
				<td>
					<form method="post" action="offlineReport" id="offlineReport">
						<input type="hidden" name="off_no" value="${dto.off_no}"/>	
						<input type="hidden" name="target_id" value="${opDTO.userid}"/>			
						<input type="submit" name ="review "value="신고" class="reportButton"/>
					</form>	
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>

</div>