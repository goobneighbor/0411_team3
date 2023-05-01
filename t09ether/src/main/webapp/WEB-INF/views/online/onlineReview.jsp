<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
.card-text{
	font-size:.1.2em;
	
}
</style>
<script>
$(function(){
	$("#submitRev").on("click", function () {
		event.preventDefault();
		
		let rate = $('#rate').val();

        if(!rate){
            alert("별점을 선택해주세요.");
            $('#rate').focus();
            return false;
        }
        
        if($("#content").val==""){
        	alert("후기를 입력해주세요.");
        	$('#content').focus();
            return false;
        }
       
      //form태그의 action속성 설정
		<%-- $("#reviewForm").attr("action","<%=request.getContextPath() %>/online/reviewOk"); --%>
		let params = $("#reviewForm").serialize();
		console.log(params);
		$.ajax({
			type:"POST",
			url:"/home/online/reviewOk",
			data:params,
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			success:function(result){
				console.log(result); 
				alert('리뷰가 등록되었습니다.');
				location.href="/home/online/onlineReview?pro_code="+${dto.pro_code};
			},error:function(error){
				console.log(error.responseText); 
			}
		});//ajax
        
	});
	
	$("#deleteRev").on("click", function () {
		event.preventDefault();
		if(confirm("리뷰를 삭제할까요?")){
			var params = "on_r_no="+ $(this).attr("title");
			console.log(params);
			$.ajax({
				url:"/home/online/reviewDel",
				data:params,
				success:function(result){
					console.log(result); 
					if(result>0){
						 alert('리뷰가 삭제되었습니다.');
						 location.href="/home/online/onlineReview?pro_code="+${dto.pro_code};
					}
				},error:function(error){
					console.log(error.responseText); 
				}
			});//ajax
		}//if문
		});		
	
});
</script>
<section id="main" class="container">
	<header>
		<h2>상품 리뷰</h2>
		<p>리뷰를 확인해주세요</p>
	</header>
       <div class="row">
       
           <!-- Blog entries-->
           <div class="col-lg-5">
               <!-- Featured blog post-->
               <div class="card mb-6">
                   <img src="${dto.image }" />
                   <hr/>
	               <p style="margin-left:10px"><h2 class="card-title" style="margin-left:20px">${dto.pro_name }</h2></p>
	               <p>총가격 : ${dto.pro_price }</p>
	               <p>개당 가격 :${dto.pro_total }</p>
	               <p ></p>
	               <br/>
               </div>
               

           </div>
           <!-- Side widgets-->
           <div class="col-lg-7">
               <div class="card mb-6">
              		<div class="card-header">리뷰 </div>
              		<div class="card-body"> 
              		<span class='star-rating'><span style = "width:70%"></span></span>                      
                      	<form method="get" id="reviewForm">
                      		<input type="hidden" name="pro_code" value="${dto.pro_code }">
                      		<select name="rate" id="rate">
            						<option value="">평점을 선택해주세요★</option>
						     <c:forEach var="i" items="${rating}">
						     	<option value="${i.key}">${i.value}</option>
						    </c:forEach>
            					</select>
            				<c:choose>
	            				<c:when test="${fn:contains(userList, logId)}">
	                      		<textarea rows="2" name="content" id="content" placeholder="코멘트를 입력하세요!" ></textarea>
	            					<button type="submit" id="submitRev" style="float:right">리뷰 등록</button>
	            				</c:when>
	            				<c:otherwise>
	            				<textarea rows="2" name="content" id="content" placeholder="상품 구매한 이후, 1회 리뷰 작성 가능합니다!" readonly ></textarea>
	            					<button type="submit" id="submitRev" style="float:right" disabled>리뷰 등록</button>
	            				</c:otherwise>
            				</c:choose>
                      	</form>
                      	<br/>
                      	<table class="table table-stripped" id="reviews">
				    <thead>
				        <tr>
				            <th>Rating</th> <!-- 평점 -->
				            <th>User</th>
				            <th>Text</th>
				            <th>writedate</th>
				        </tr>
				    </thead>
				    <tbody>
				        <c:forEach var="i" items="${list}" varStatus="status">
				            <!-- 평점 기준 별표시 출력 -->
				            <tr>
				                <td><c:forEach var="rating" items="${rating}" varStatus="status" begin="1" end="${ i.rate }">★</c:forEach></td>
				                <%-- <td><input type="hidden" name="on_r_no" value="${i.on_r_no }"><td> --%>
				                <td>${i.userid }</td>
				                <td>${i.content }</td>
				                <td>${i.writedate }<c:if test="${logId == i.userid }"><button id="deleteRev" title='${i.on_r_no  }'>X</button></c:if></td>
				               
				            </tr>
				        </c:forEach>
				    </tbody>
				    </table>
					    
                   </div>  
               </div>		    							                     
             </div>
             
            </div>
        </section>