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
	float:center;

	
}

.card-img-top{
	width:600px;
	height:350px;
}
#review{
	float:right;
}
#onlineJoinForm {
	float:right;
 	widh:100px; 
 	padding-right:30px;
 	text-align:center;
 	}

</style>
<script>
$(function(){
	$("#onlineJoinForm").on('click', function(){
		var _width = '500';
	    var _height = '248';
	    
		// 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
	    var _left = Math.ceil(( window.screen.width - _width )/2);
	    var _top = Math.ceil(( window.screen.height - _height )/2); 

	    window.open('onlineJoinForm', 'join', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );

	});
	
});

function openPopup() {
	 
    var _width = '730';
    var _height = '750';
 
    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
    var _left = Math.ceil(( window.screen.width - _width )/2);
    var _top = Math.ceil(( window.screen.height - _height )/2); 

    window.open('kakaomap', '위치 찾기', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
}
</script>
 
        <!-- Page content-->
        <div class="container">
            <div class="row">
                <!-- Blog entries-->
                <div class="col-lg-6">
                    <!-- Featured blog post-->
                    <div class="card mb-4">
                        <img src="${pageContext.request.contextPath }/resources/images/product_sample.png" />
                        <div class="card-body">
                            <div class="small text-muted"></div>
                            <div id="review">리뷰</div>
                            <h2 class="card-title">상품명</h2>
                            <p class="card-text">상세설명</p>
                            <a class="btn btn-primary" href="onlineGB">내가 공구만들기</a>

                        </div>
                    </div>

                </div>
                <!-- Side widgets-->
                <div class="col-lg-6" style="float:left">
                    <!-- Search widget-->
                    <div class="card mb-6">
                        <div class="card-header">참여하기</div>
                        <div class="card-body">
                        <button class="btn btn-primary" id="button-search" type="button" style="float:right; margin:5px" onclick="openPopup()">지도로 찾아보기</button>
                            <div class="input-group">
                                <input class="form-control" type="text" placeholder="지역명" aria-label="지역명" aria-describedby="button-search" />
                                <button class="btn btn-primary" id="button-search" type="button" >검색</button>
                                <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true" class="scrollspy-example bg-light p-3 rounded-2" tabindex="0" style="overflow: scroll; width: 100%; height: 400px; padding: 10px;">
								  <h4 id="scrollspyHeading1">서울시 서대문구</h4>
								  <p>통일로 135 충정빌딩<button type="button" id="onlineJoinForm" class="btn btn-primary">참여</button></p>
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

