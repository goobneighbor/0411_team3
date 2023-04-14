<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section id="main" class="container">
	<header>
	<h2>고객 센터</h2>
	<p>작은 목소리도 크게 귀담아 듣겠습니다.</p>
	</header>
</section>
<!--  <div class="row"> -->
<!--  <div class="col-12"> -->
<section class="box">
	<div class="table-wrapper">
	<h2 style="text-align:left; padding:20px;">자주 묻는 질문</h2>
	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="CustomerCenterDTO" items="${list}">
				 <tr>
					<td>${CustomerCenterDTO.cus_b_num}</td>
					<td>${CustomerCenterDTO.subject}</td>
					<td>${CustomerCenterDTO.userid}</td>
					<td>${CustomerCenterDTO.writedate}</td>
				  </tr>
			</c:forEach>	
				</tbody>
			</table>
		</div>
		</section>
		<h3 style="text-align:left; padding:20px;">1:1 문의</h3>
			<section class="box special features">
				<div class="features-row">
					<section>
					<span class="icon solid major fa-chart-area accent3"></span>
					<h3>내역 보기</h3><br/>
					<p><a href="myOrder">온라인 공구 내역</a><br/> 
					<a href="myPost">오프라인 공구 게시물</a></p>
			</section>
			<section>
				<span class="icon solid major fa-lock accent5"></span>
				<h3>내 정보</h3><br/>
				<p><a href="myPersInfo">회원정보 수정</a></p>
			</section>
			<section>
				<span class="icon solid major fa-cloud accent4"></span>
				<h3>빈칸</h3>
				<p>예시</p>
			</section>
		</div>
</section>
</body>
</html>