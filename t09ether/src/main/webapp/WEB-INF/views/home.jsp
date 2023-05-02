<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Banner -->
				<section id="banner">
					<h2>t09ether</h2>
					<p>온/오프라인 공동구매 서비스</p>
					<ul class="actions special">
						<c:if test="${logStatus != 'Y' }">
						<li><a href="<%=request.getContextPath()%>/join" class="button primary">회원가입</a></li>
						</c:if>
						<!-- <li><a href="#" class="button">더 알아보기</a></li> -->
					</ul>
				</section>

			<!-- Main -->
				<section id="main" class="container">

					<section class="box special">
						<header class="major">
							<h2>토탈 공동구매 서비스
							<br/>
							온/오프라인 커뮤니티</h2>
							<p>t09ether와 함게 하는 알뜰살뜰 스마트 공동구매</p>
						</header>
					</section>


					<div class="row">
						<div class="col-6 col-12-narrower">

							<section class="box special">
								<span class="image featured"><img src="<%=request.getContextPath()%>/resources/images/home_test3.jpg" alt="image" /></span>
								<h3>온라인 공동구매란?</h3>
								<p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
								<ul class="actions special">
									<li><a href="<%=request.getContextPath()%>/product/onlineHome" class="button alt">시작하러가기</a></li>
								</ul>
							</section>

						</div>
						<div class="col-6 col-12-narrower">

							<section class="box special">
								<span class="image featured"><img src="<%=request.getContextPath()%>/resources/images/home_test2.jpg" alt="" /></span>
								<h3>오프라인 공동구매란?</h3>
								<p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
								<ul class="actions special">
									<li><a href="<%=request.getContextPath()%>/offline" class="button alt">시작하러가기</a></li>
								</ul>
							</section>
						</div>
					</div>
				</section>

