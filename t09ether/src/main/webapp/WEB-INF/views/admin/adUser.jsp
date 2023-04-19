<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Main -->
	<section id="main" class="container">
		<header>
			<h2>온라인 공구 내역</h2>
			<p>진행 중인 내역</p>
		</header>
		<div class="row">
			<div class="col-12">
				<!-- 주문내역 리스트 -->
				<section class="box">
					<div class="table-wrapper">
						<table>
							<thead>
								<tr>
									<th>주문일</th>
									<th>상품명</th>
									<th>가격</th>
									<th>수량</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>2023.03.26</td>
									<td>니베아 맨 센서티브 쉐이빙 폼, 200ml, 6개</td>
									<td>22,350원</td>
									<td>1개</td>
								</tr>
								<tr>
									<td>2023.03.26</td>
									<td>니베아 맨 센서티브 쉐이빙 폼, 200ml, 6개</td>
									<td>22,350원</td>
									<td>1개</td>
								</tr>
								<tr>
									<td>2023.03.26</td>
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
					</div>
				</section>
			</div>
		</div>
	</section>
</body>
</html>