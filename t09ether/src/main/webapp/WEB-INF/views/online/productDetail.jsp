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
	$(document).on('click',"#onlineJoinForm", function(){
		console.log($(this).parent().parent())
	
		var idx = $("#locationList>li").index($(this).parent().parent());
		console.log(idx)
		var _width = '500';
	    var _height = '248';
	   
		// 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
	    var _left = Math.ceil(( window.screen.width - _width )/2);
	    var _top = Math.ceil(( window.screen.height - _height )/2); 
	    window.open('<%=request.getContextPath()%>/online/onlineJoinForm?on_no='+on_no[idx]+'&rest_count='+rest_count[idx]+'&pro_code='+pro_code[idx], 'join', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
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
	
let on_no=[];
let rest_count=[];
let pro_code=[];
let userid=[];
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
	
		on_no.push(lDTO.on_no); // [3, 6,  9]
		rest_count.push(lDTO.rest_count);
		pro_code.push(lDTO.pro_code);
		userid.push(lDTO.userid);
		
		tag += "<li><p><span style='width:30%'>"+lDTO.shareaddr+"</span><span style='width:20%;float:right;text-align:center'>"+lDTO.userid+"</span><button type='button' style='float:right' id='onlineJoinForm' class='btn btn-primary'>참여/"+lDTO.rest_count+"</button>";

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
                        <div class="card-body" style="font-size:1em; text-align:center; font-weight:lighter"><a class="btn btn-primary">내가 공구만들기</a>로 <span style="font-size:1.8em">공구장</span>이되면  <span style="font-size:1.8em"><i class="bi bi-house-fill"></i></span>으로  물품이  배송됩니다!  공구장이  되어  <span style="font-size:1.8em">할인등급<i class="bi bi-graph-up"></i></span>을  올리세요! <br/>공구목록에서  가까운  <span style="font-size:1.8em"><i class="bi bi-geo-alt-fill"></i></span>를  확인하고  <button type='button'class='btn btn-primary'>참여/남은갯수</button>을  클릭해 <span style="font-size:1.8em">공구원</span>이되어 공구에 참여해보세요!</div>
            </div>
            
            <!-- Blog entries-->
            <div class="col-lg-6">
                <!-- Featured blog post-->
                <div class="card mb-6">
                    <img src="${dto.image }" />
                    
                </div>

            </div>
            <!-- Side widgets-->
            <div class="col-lg-6">
                <div class="card mb-6">
               		<div class="card-header">상품상세</div>
               		<div class="card-body">
                        <button class="btn btn-primary" id="button-search" style="float:right">리뷰</button>
                        <h2 class="card-title">${dto.pro_name }</h2>
                        <p class="card-text" style="font-size:1.4em; float:right">가격/할인적용시가격</p>
                      
                        <br/>
                        <hr/>
                        <p class="card-text">${dto.detailed }</p>
                        <a class="btn btn-primary" style="float:right" href="<%=request.getContextPath()%>/product/onlineGB?pro_code=${dto.pro_code }">내가 공구만들기</a>

                    </div>  
                </div>		    							                     
              </div>
       		<hr/>
                  <!-- 참여하기 -->
             <div class="card mb-4">
                   <div class="card-header">참여하기</div>
                   <div class="card-body">
                   <button class="btn btn-primary" id="button-search" type="button" style="float:right; margin:5px" onclick="openPopup()">지도로 찾아보기</button>
                      <!--  <div class="input-group"> -->
                       <form method="get" name="searchForm" id="searchForm">
                       	<div class=" col-lg-10"> 
	                       	<div class="input-group">
			                <!-- <mx-auto> -->
			                
			               		<input id="pro_code" name="pro_code" value="${dto.pro_code }" type="hidden"/>		
			                    <input  id="searchWrd" name="searchWrd" value="${vo.searchWrd }" type="text" class="form-control" placeholder="지역명을 입력해주세요!" aria-label="search" aria-describedby="button-addon2">
			                	
			               <!--  </mx-auto>	 -->	
			                <button class="btn btn-success" type="submit" id="button-addon2">검색</button>
			                </div>
		                </div>	
                       </form>
                        	<p><span style='width:60%; text-align:center;'>&nbsp;&nbsp;&nbsp;나눔 주소</span><span style='width:20%;float:right;text-align:center'>공구장 아이디</span><button type='button' style='float:right' class='btn btn-primary'>참여/남은갯수</button></p><hr/>
                           	<div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true" class="scrollspy-example bg-light p-3 rounded-2" tabindex="0" style="overflow: scroll; width: 100%; height: 300px; padding: 10px;">
			  					<ul id="locationList" style="list-style-type:none"></ul>
							</div>
                       </div>
                   </div>
            </div>
                    
                    
              </div>
            </div>
