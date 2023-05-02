<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.3.0/chart.min.js"></script>

	<section id="main" class="container">
		<header>
			<p></p>
			<h2>통계</h2>
			<p></p>
		</header>
		<div class="row">
			<div class="col-12">
			<!-- 월별 가입자수 / Line 차트 -->
				<div>
					<h5 style="text-align: center;">월별 가입자</h5>
					<canvas id="regiChart"></canvas>
				</div>
			
			<!-- 월별 온라인 공동구매 거래량 / Line 차트 -->
				<div>
					<h5 style="text-align: center;">월별 온라인 공동구매 거래량</h5>
					<canvas id="onlineChart"></canvas>
				</div>
				
				
				
			</div>
		</div>
	</section>
	

<script>
	function colorize() {
		var r = Math.floor(Math.random()*200);
		var g = Math.floor(Math.random()*200);
		var b = Math.floor(Math.random()*200);
		var color = 'rgba(' + r + ', ' + g + ', ' + b + ', 0.7)';
		return color;
	}		
	
	//통계
	//월별 가입자
	var labelList = new Array();
	var valueList = new Array();
	var colorList = new Array();
	
	var jsonData = ${json}
	var jsonObject = JSON.stringify(jsonData);
	var jData = JSON.parse(jsonObject);	
	
	for(var i = 0; i<jData.length; i++) {
		var d = jData[i];
		labelList.push(d.Month);
		valueList.push(d.Count);
		//colorList.push(colorize());
	}
		
	var data = {
				labels: labelList,
				datasets: [{
						data : valueList,
						/* backgroundColor: colorList, */
						label: '월별 가입자 수',
						fill:false,
						borderColor:'rgb(75, 192, 192)',
						tension:0.1 
						
						
				}],
				options : {
						title : {
						display : true,
						text: '월별 가입자 수'
						}
				}
	};
			
	var ctx1 = document.getElementById('regiChart').getContext('2d');
	new Chart(ctx1, {
		      type: 'line',
			  data: data
	});
	
	
	//월별 온라인 공구 거래량
	var labelList1 = new Array();
	var valueList1 = new Array();
	var colorList1 = new Array();
	
	var jsonData1 = ${onlineJson}
	var jsonObject1 = JSON.stringify(jsonData1);
	var jData1 = JSON.parse(jsonObject1);	
	
	for(var i = 0; i<jData1.length; i++) {
		var e = jData1[i];
		labelList1.push(e.Month);
		valueList1.push(e.Count);
		//colorList.push(colorize());
	}
		
	var data = {
				labels: labelList1,
				datasets: [{
						data : valueList1,
						/* backgroundColor: colorList, */
						label: '월별 온라인 공동구매 거래량',
						fill:false,
						borderColor:'rgb(75, 102, 152)',
						tension:0.1 
						
						
				}],
				options : {
						title : {
						display : true,
						text: '월별 온라인 공동구매 거래량'
						}
				}
	};
			
	var ctx1 = document.getElementById('onlineChart').getContext('2d');
	new Chart(ctx1, {
		      type: 'line',
			  data: data
	});
	
</script>


