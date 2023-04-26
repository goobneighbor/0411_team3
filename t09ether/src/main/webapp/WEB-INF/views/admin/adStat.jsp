<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.2.1/chart.min.js"></script>

<script>
	$(function(){
		const labels = Utils.months({count: 7});
		const data = {
		  labels: labels,
		  datasets: [{
		    label: 'My First Dataset',
		    data: [65, 59, 80, 81, 56, 55, 40],
		    fill: false,
		    borderColor: 'rgb(75, 192, 192)',
		    tension: 0.1
		  }]
		};
		
		const stackedLine = new Chart(document.getElementById("line_chart"), {
		    type: 'line',
		    data: data,
		    options: {
		        scales: {
		            y: {
		                stacked: true
		            }
		        }
		    }
		});
	});
</script>

	<!-- LineChart넣기 -->
		<div style="border:1px solid #ddd;">
			<canvas id="line_chart" ></canvas>
		</div>

