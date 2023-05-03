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
							<h2 style="line-height:50px">동네 이웃과 함께 하는 공구생활</h2>
							<h2>t09ether</h2>
							<p>묶음으로는 너무 많고, 조금 사기에는 너무 비싼가요?<br/>
								t09ether에서 함께 구매할 이웃을 찾아보세요
							</p>
						</header>
					</section>


					<div class="row">
						<div class="col-6 col-12-narrower">

							<section class="box special">
								<span class="image featured"><img src="<%=request.getContextPath()%>/resources/images/home_test3.jpg" alt="image" /></span>
								<h3 style="line-height:50px; margin-bottom:30px;">온라인 공동구매</h3>
								<p style="color:gray; margin-bottom:30px; font-size:1.2em">t09ether가 준비한 상품은 어떠세요? <br/>
								좋은 가격으로 다양한 상품을 준비했어요<br/>
								공구장 or 공구원이 되어 이웃과 구매해보세요<br/>
								</p>
								<ul class="actions special">
									<li><a href="<%=request.getContextPath()%>/product/onlineHome" class="button alt">시작하러가기</a></li>
								</ul>
							</section>

						</div>
						<div class="col-6 col-12-narrower">

							<section class="box special">
								<span class="image featured"><img src="<%=request.getContextPath()%>/resources/images/home_test2.jpg" alt="" /></span>
								<h3 style="line-height:50px; margin-bottom:30px;">오프라인 공동구매</h3>
								<p style="color:gray; margin-bottom:30px; font-size:1.2em">
								혼자 마트가기 힘드세요?<br/>
								대형 마트에서도 공동구매를 하고 싶으세요?<br/>
								함께 할 공구메이트를 찾아보세요<br/>
								</p>
								<ul class="actions special">
									<li><a href="<%=request.getContextPath()%>/offline" class="button alt">시작하러가기</a></li>
								</ul>
							</section>
						</div>
					</div>
				</section>

