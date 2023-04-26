<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<style>
	footer {
		display:none;
	}
	#alert{
		 overflow:auto;
	}
	#alert li{
		float:left;
		width:20%;
		list-style:none;
		border:1px solid #ddd;
		line-height:40px;
		height:90px;
		padding: 8px;		
	}
	
</style>
</head>
<body>
	<section id="main" class="container">

					<section class="box special">
						<header class="major">
							<h2>관리자 페이지</h2>
							<p></p>
						<ul id="alert">
							<li>가입인원<br/>
							50명
							</li>
							<li>온라인 거래량<br/>
							1500건
							</li>
							<li>오프라인 거래량<br/>
							2300건
							</li>
							<li>신고 접수<br/>
							150회
							</li>
							<li>QnA 등록<br/>
							250개
							</li>
						</ul>
						</header>
					</section>
					
					

					<section class="box special features">
						<div class="features-row">
							<section>
								<span class="icon solid major fa-bolt accent2"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adUser">회원 관리</a></h3>
								<p>회원 목록/ 검색/ 영구제명(이 부분은 다 만들고 삭제예정)</p>
							</section>
							<section>
								<span class="icon solid major fa-chart-area accent3"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adReport">신고관리</a></h3>
								<p>신고목록 / 검색/ 활동정지 승인/ 활동정지 반려/ 영구제명</p>
							</section>
						</div>
						<div class="features-row">
							<section>
								<span class="icon solid major fa-cloud accent4"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adStat">통계</a></h3>
								<p>가입 인원/ 공동구매(온,오프라인) 거래량<br/>
									/신고 접수/ 인기 상품/  등..<br/>
									*기간 별 설정</p>
							</section>
							<section>
								<span class="icon solid major fa-lock accent5"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adQna">고객센터관리(링크는 여기걸려있음)</a></h3>
								<p>qna 목록/미답변 게시물 표기 / 작성 수정 삭제 검색/ 답변<br/>
									faq 작성 수정 삭제 검색<br/>(링크 아래 작은 글씨부분은 다 만들고 삭제예정)
								</p>
							</section>
						</div>
						<div class="features-row">
							<section>
								<span class="icon solid major fa-cloud accent4"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adProduct">상품관리</a></h3>
								<p>온라인 상품목록/ 리뷰 목록/ 추가 수정 삭제 검색</p>
							</section>
							<section>
								<span class="icon solid major fa-lock accent5"></span>
								<h3><a href="<%=request.getContextPath()%>/admin/adBoard">게시글관리(공지사항 기능+오프라인게시판 관리)</a></h3>
								<p>공지사항 작성/수정/삭제<br/>
									오프라인 작성/수정/삭제/검색</p>
							</section>
						</div>
					</section>
				</section>
</body>