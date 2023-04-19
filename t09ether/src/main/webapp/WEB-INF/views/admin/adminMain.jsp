<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<style>
	footer {
		display:none;
	}
</style>
</head>
<body>
	<section id="main" class="container">

					<section class="box special">
						<header class="major">
							<h2>관리자 페이지</h2>
							<p>김홍렬-사용자관리, 신고관리, 통계<br/>
								신동민-1대1문의, 상품관리, 게시글 관리<br/><br/>
								통계는 나중에 메인에 나오게 만들겠습니다.
								</p>
								
						</header>
					</section>

					<section class="box special features">
						<div class="features-row">
							<section>
								<span class="icon solid major fa-bolt accent2"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adUser">사용자관리</a></h3>
								<p></p>
							</section>
							<section>
								<span class="icon solid major fa-chart-area accent3"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adReport">신고관리</a></h3>
								<p></p>
							</section>
						</div>
						<div class="features-row">
							<section>
								<span class="icon solid major fa-cloud accent4"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adStat">통계</a></h3>
								<p></p>
							</section>
							<section>
								<span class="icon solid major fa-lock accent5"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adQna">1대1문의</a></h3>
								<p></p>
							</section>
						</div>
						<div class="features-row">
							<section>
								<span class="icon solid major fa-cloud accent4"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adProduct">상품관리</a></h3>
								<p></p>
							</section>
							<section>
								<span class="icon solid major fa-lock accent5"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adBoard">게시글관리</a></h3>
								<p></p>
							</section>
						</div>
					</section>
				</section>
</body>