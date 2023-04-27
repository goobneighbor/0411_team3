<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#uldesign {
		list-style:none;
		
	}
	#wrappertwo {
		display: grid;
		place-items: center;
		min-height: 10vh;
	}
	<!--
	#uldesign>li:nth-child(0n) {
		border:1px solid #ddd;
	}
	#uldesign>li:nth-child(2n) {
		border:1px solid #ddd;
	}
	-->
</style>
<body>
<section id="main" class="container">
<header>
   <h2>Q&A 게시판</h2>
   
</header>
	<ul id="uldesign">
		<li>글 번호 : ${CustomerCenterDTO.cus_b_num }</li>
		<li>작성자 : ${CustomerCenterDTO.userid }</li>
		<br/>
		<li>제목</li>
		<li>${CustomerCenterDTO.subject }</li>
		<li>글 내용</li>
		<li>${CustomerCenterDTO.content }</li>
		<li>등록일</li>
		<li>${CustomerCenterDTO.writedate }</li>
	</ul>
	
	<div class="boardSubMenu" id="wrappertwo">
		<a href="customerBoard?nowPage=${vo.nowPage }<c:if test="${vo.searchWord!=null }">&searchKey=${vo.searchKey }&searchWord=${vo.searchWord }</c:if>">글목록</a>
		
		<c:if test="${logId == CustomerCenterDTO.userid }">
		<a href="csBoardEdit?cus_b_num=${CustomerCenterDTO.cus_b_num }&nowPage=${vo.nowPage }<c:if test="${vo.searchWord!=null }">&searchKey=${vo.searchKey }&searchWord=${vo.searchWord }</c:if>">수정</a>
		<a href="javascript:boardDel()">삭제</a>
		</c:if>
	</div>

</section>
</body>
</html>