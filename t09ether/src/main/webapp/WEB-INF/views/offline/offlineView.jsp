<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.boardSubMenu{
		background: gray;
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
</style>
<div class="container">
	<h1>글내용보기</h1>
	<ul id="view">
		<li>번호</li>
		<li>${dto.no}</li>
		<li>글쓴이</li>
		<li>${dto.username}</li>
		<li>조회수</li>
		<li>${dto.hit}</li>
		<li>등록일</li>
		<li>${dto.writedate}</li>
		<li>제목</li>
		<li>${dto.subject}</li>			
		<li>글내용</li>
		<li>${dto.content}</li>			
	</ul>	
</div>