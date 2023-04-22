<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="utf-8">
    <title>키워드로 장소검색하고 목록으로 표출하기</title>
<style>
header,footer{
		display:none;
	}
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:500px;}
#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px;}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}
#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default;color:#777;}
</style>
<script>
	$(function(){
		$("#searchForm").submit(function(){
			event.preventDefault();
			let params = $("#searchForm").serialize();
			console.log(params);
			$.ajax({
				url:"/home/online/kakaomapList", //commentController에 있어
				type:"GET",		//서버서 가져온데이터
				data: params,
				dataType:'json',
				success:function(result){
					console.log(result);
					localList(result);
				},error:function(e){
					console.log(e.responseText);
				}
			});
		});
		
	});
	
</script>
</head>
<body>

	<form method="get" name="searchForm" id="searchForm" >
		 
		<div>
			<input id="pro_code" name="pro_code" value="${dto.pro_code }" type="hidden"/>
		    <input type="text" class="text" id="searchWrd" name="searchWrd" placeholder="지역명을 입력해주세요!" style="width: 300px;"   value="${vo.searchWrd }" /> 
		    <input type="submit" value="검색"/>
		</div>
		 
	</form>
 
	<div>
	      <div class="map_wrap">
	        <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div> 
	   	</div>
	    
	</div>
	 

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6252bd7f72ed64a20b2f8cca3afb7204&libraries=services"></script>

<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  
	
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	var geocoder = new kakao.maps.services.Geocoder();
	////////////////////////////////////////////
	if(document.getElementById("searchWrd").value==""){
	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        
	        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px; border-radius:5%;">현 위치입니다</div>'; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	            
	      });
	    
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
	    message = 'geolocation을 사용할수 없어요..'
	        
	    displayMarker(locPosition, message);
	}

	// 지도에 마커와 인포윈도우를 표시하는 함수입니다
	function displayMarker(locPosition, message) {

	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({  
	        map: map, 
	        position: locPosition
	    }); 
	    
	    var iwContent = message, // 인포윈도우에 표시할 내용
	        iwRemoveable = true;

	    // 인포윈도우를 생성합니다
	    var infowindow = new kakao.maps.InfoWindow({
	        content : iwContent,
	        removable : iwRemoveable
	    });
	    
	    // 인포윈도우를 마커위에 표시합니다 
	    infowindow.open(map, marker);
	    
	    // 지도 중심좌표를 접속위치로 변경합니다
	    map.setCenter(locPosition);      
		}
	}
	
	//////////////////////////////////////////////////////////////////////
	function localList(result) {
	
		 //주소-좌표 변환 객체를 생성합니다
		
		//주소 리스트 
		result.map(function(addr, index){
		
		    // 주소로 좌표를 검색합니다
		    geocoder.addressSearch(addr.shareaddr, function(shareresult, status) {
		    	console.log(": "+addr.shareaddr)
		        // 정상적으로 검색이 완료됐으면 
		         if (status === kakao.maps.services.Status.OK) {
		    		//주소로 좌표구하기
		    		
		            var coords = new kakao.maps.LatLng(shareresult[0].y, shareresult[0].x);
		            var content = '<div class="overlay_info">';
		            content += '    <a><strong>' + addr.shareaddr +'</strong></a>';
		            content += '</div>';
		            // 결과값으로 받은 위치를 마커로 표시합니다.
		            displayMarker(coords, content);
		
		            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		            if(index == 0){
		                map.setCenter(coords);    
		            }
		        } 
	   		 });  
	
		}); 
	}
</script>
</body>