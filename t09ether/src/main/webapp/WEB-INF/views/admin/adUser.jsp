<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.searchDiv{
		clear:left;
		padding:10px;
		text-align: center;		
	}
</style>
</head>
<body>
<!-- Main -->
	<!-- Main -->
	<section id="main" class="container">
		<header>
			<h2>회원 관리</h2>
			<p>회원 목록</p>
		</header>
		<div class="row">
			<div class="col-12">
				<!-- 주문내역 리스트 -->
				<section class="box">
					<div class="table-wrapper">
					<form method="post">
					<input type="hidden" name="nowPage" value="${vo.nowPage }"/>
					<c:if test="${vo.searchWord!=null}">
						<input type="hidden" name="searchKey" value="${vo.searchKey }"/>
						<input type="hidden" name="searchWord" value="${vo.searchWord }"/>
					</c:if>
						<table>
							<thead>
								<tr>
									<th>번호</th>
									<th>상품명</th>
									<th>가격</th>
									<th>수량</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>니베아 맨 센서티브 쉐이빙 폼, 200ml, 6개</td>
									<td>22,350원</td>
									<td>1개</td>
								</tr>
								<tr>
									<td>2</td>
									<td>니베아 맨 센서티브 쉐이빙 폼, 200ml, 6개</td>
									<td>22,350원</td>
									<td>1개</td>
								</tr>
								<tr>
									<td>3</td>
									<td>니베아 맨 센서티브 쉐이빙 폼, 200ml, 6개</td>
									<td>22,350원</td>
									<td>1개</td>
								</tr>
								<tr>
								<c:forEach var="data" items="${list}">
									<td>${data.no}2023.03.26</td>
									<td>${data.product}니베아 맨 센서티브 쉐이빙 폼, 200ml, 6개</td>
									<td>${data.price}22,350원</td>
									<td>${data.quantity}1개</td>
								</c:forEach>
								</tr>
							</tbody>
							<!--<tfoot>
								<tr>
									<td colspan="2"></td>
									<td>100.00</td>
								</tr>
							</tfoot>  -->
						</table>
					</form>
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
				</section>
			</div>
		</div>
	</section>
</body>
</html>