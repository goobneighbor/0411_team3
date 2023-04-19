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
</style>
<body>
<section id="main" class="container">
<header>
   <h2>자주 묻는 질문</h2>
   
</header>
	<ul id="uldesign">
		<li>글 번호 : ${CustomerCenterDTO.cus_b_num }</li>
		<li>작성자 : ${CustomerCenterDTO.userid }</li>
		<br/>
		<li>제목 : ${CustomerCenterDTO.subject }</li>
		<li>글 내용</li>
		<li>${CustomerCenterDTO.content }</li>
		<li>등록일</li>
		<li>${CustomerCenterDTO.writedate }</li>
	</ul>

</section>
</body>
</html>