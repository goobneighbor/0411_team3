<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- 부트스트랩 넣은것 -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
<style>
.container{
	margin:0 auto;
	padding:20px;

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

	    window.open('<%=request.getContextPath()%>/online/onlineJoinForm', 'join', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
	});
	
});

function openPopup() {
	 
    var _width = '730';
    var _height = '750';
 
    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
    var _left = Math.ceil(( window.screen.width - _width )/2);
    var _top = Math.ceil(( window.screen.height - _height )/2); 

    window.open('<%=request.getContextPath()%>/online/kakaomap?pro_code=${dto.pro_code}', '위치 찾기', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
}

$(function(){
	//지역목록뿌리기
		function locationList(){
			$.ajax({
				url:"<%=request.getContextPath()%>/online/locationList", //onlineController에 있어
				data:{
					pro_code:${dto.pro_code}
				},
				success:function(locationList){//서버에서 정상적으로 데이터를 가져왔을때
					console.log(locationList);
					listView(locationList)
				},error:function(e){
					console.log(e.responseText);
				}
			});
		}

		//제일마지막에 실행** 
		//뿌려주기 ===>처음에 상품상세보기로 오면 지역 보여주기
		locationList();//호출
		
		
	})
	


$(function(){
	$("#searchForm").submit(function(){
		event.preventDefault();
		let params = $("#searchForm").serialize();
		
		$.ajax({
			url:"/home/online/searchList", //onlineController에 있어
			type:"GET",		//서버서 가져온데이터
			data:params,
			success:function(searchresult){
				console.log(searchresult);
				listView(searchresult)
			},error:function(e){
				console.log(e.responseText);
			}
		});
	});
	
});
	
function listView(result) {
	var tag = "";
	$(result).each(function(i, lDTO){
		tag += "<li><p>"+lDTO.shareaddr+"<span style='font-size:0.8em; float:right'>남은수량:</span><button type='button' style='float:right' id='onlineJoinForm' class='btn btn-primary'>참여</button>";
		
		tag += "</p></li>"; //리스트하나에 li하나 열리는 상황
	
	});
	
	$("#locationList").html(tag);
	
}
	
</script>
 
        <!-- Page content-->
        <div class="container">
        <div class="row">
        	<div class="card mb-4">
                        <div class="card-header">온라인 공동구매 시작하세요!</div>
                        <div class="card-body">'내가 공구만들기'시, 공구장이되어 집으로 물품이 배송됩니다! 공구장이 되어 등급을 올리세요! <br/>'참여하기'에서 인근 위치의 공구목록에서 공구에 참여해보세요!</div>
            </div>
            
                <!-- Blog entries-->
                <div class="col-lg-6">
                    <!-- Featured blog post-->
                    <div class="card mb-4">
                        <img src="${dto.image }" />
                        <div class="card-body">
                            <div class="small text-muted"></div>
                            <div id="review">리뷰</div>
                            <h2 class="card-title">${dto.pro_name }</h2>
                            <p class="card-text">${dto.detailed }</p>
                            <a class="btn btn-primary" href="<%=request.getContextPath()%>/product/onlineGB?pro_code=${dto.pro_code }">내가 공구만들기</a>

                        </div>
                    </div>

                </div>
                <!-- Side widgets-->
                <div class="col-lg-6">
                    <!-- Search widget-->
                    <div class="card mb-6">
                        <div class="card-header">참여하기</div>
                        <div class="card-body">
                        <button class="btn btn-primary" id="button-search" type="button" style="float:right; margin:5px" onclick="openPopup()">지도로 찾아보기</button>
                            <div class="input-group">
                            <form method="get" name="searchForm" id="searchForm" >
                            	<input id="pro_code" name="pro_code" value="${dto.pro_code }" type="hidden"/>
                                <input id="searchWrd" name="searchWrd" value="${vo.searchWrd }" class="form-control" type="text" placeholder="지역명" aria-label="지역명" aria-describedby="button-search" />
                                <button class="btn btn-primary" id="button-search" type="submit" >검색</button>
                            </form>
                                <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true" class="scrollspy-example bg-light p-3 rounded-2" tabindex="0" style="overflow: scroll; width: 100%; height: 400px; padding: 10px;">
								  <ul id="locationList" style="list-style-type:none"></ul>
								</div>
                            </div>
                        </div>
                    </div>		    							                     
                  </div>
                    
                    
              </div>
            </div>

