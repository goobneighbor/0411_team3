<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 오프라인 공구 대화방(댓글) -->
<style>
	li{list-style-type: none;}
	.text-center text-white>h2{
		color:#fff;
		margin:0 auto;
		text-align: center;
	}
	.commentDiv{
		border: 2px double orange;
	}
</style>
<script>

</script>
	<!-- Header-->
	<header class="bg-tomato py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
	        	<h1 class="display-4 fw-bolder" style="color:#FFF">일정조율하기</h1>	
	        	<h2>참가자들과 자유롭게 일정을 조율해보세요!</h2>	        	           
	        </div>
	    </div>
	</header>
	
<div class="container">	
	<h1>여기에 댓글구현</h1>
	<div class="commentDiv">
		<form method="post" id="commentForm">
			<input type="hidden" name="no" value="${dto.off_no}"/> <!-- 원글 번호 -->
			<textarea name="coment" id="coment"></textarea>
			<button id="commentInsert">댓글등록</button>
		</form>
	</div>
</div>