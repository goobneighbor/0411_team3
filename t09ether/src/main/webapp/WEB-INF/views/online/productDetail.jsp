<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- 부트스트랩 넣은것 -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
<style>
.container{
	width:1000px;
	margin:0 auto;
	padding:20px;
}

</style>
<!-- Header-->
<header class="bg-tomato py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
        	<h1 class="display-4 fw-bolder" style="color:#FFF">오프라인 공동구매</h1>
            <p class="lead fw-normal text-white-75 mb-0">직접 공동구매를 함께할 메이트 모집을 시작하거나 참여해보세요.</p>
        </div>
    </div>
</header>

 
        <!-- Page content-->
        <div class="container">
            <div class="row">
                <!-- Blog entries-->
                <div class="col-lg-8">
                    <!-- Featured blog post-->
                    <div class="card mb-4">
                        <a href="#!"><img class="card-img-top" src="https://dummyimage.com/850x350/dee2e6/6c757d.jpg" alt="..." /></a>
                        <div class="card-body">
                            <div class="small text-muted">리뷰보기</div>
                            <h2 class="card-title">상품명</h2>
                            <p class="card-text">상세설명</p>
                            <a class="btn btn-primary" href="#!">내가 공구만들기</a>
                        </div>
                    </div>

                </div>
                <!-- Side widgets-->
                <div class="col-lg-4">
                    <!-- Search widget-->
                    <div class="card mb-4">
                        <div class="card-header">참여하기</div>
                        <div class="card-body">
                            <div class="input-group">
                                <input class="form-control" type="text" placeholder="Enter search term..." aria-label="Enter search term..." aria-describedby="button-search" />
                                <button class="btn btn-primary" id="button-search" type="button">Go!</button>
                                <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true" class="scrollspy-example bg-light p-3 rounded-2" tabindex="0" style="overflow: scroll; width: 100%; height: 320px; padding: 10px;">
								  <h4 id="scrollspyHeading1">서울시 서대문구</h4>
								  <p>통일로 135 충정빌딩</p>
								  <p>통일로 135 충정빌딩 앞</p>
								  <p>통일로 135 충정빌딩 옆</p>
								  <h4 id="scrollspyHeading2">서울시 동작구</h4>
								  <p>...</p>
								  <h4 id="scrollspyHeading3">서울시 영등포구</h4>
								  <p>...</p>
								  <h4 id="scrollspyHeading4">Fourth heading</h4>
								  <p>...</p>
								  <h4 id="scrollspyHeading5">Fifth heading</h4>
								  <p>...</p>
								</div>
                            </div>
                        </div>
                    </div>
                  
							    
							    							                     
                    </div>
                    <!-- Side widget-->
                    <div class="card mb-4">
                        <div class="card-header">온라인 공동구매 시작하세요!</div>
                        <div class="card-body">'내가 공구만들기'시, 공구장이되어 집으로 물품이 배송됩니다! 공구장이 되어 등급을 올리세요! <br/>'참여하기'에서 인근 위치의 공구목록에서 공구에 참여해보세요!</div>
                    </div>
                </div>
            </div>
        </div>
