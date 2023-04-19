<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   	#wrappertwo {
		display: grid;
		place-items: center;
		min-height: 10vh;
	}

	#searchKey { /*제목임*/
		width:40%;
		text-align:center;
		margin: auto;
	}
	#searchWord { /*검색칸*/
		width:40%;
		margin: auto;
	}
   .pagingDiv li{
		float:left;
		text-align :center;
		padding:10px 20px;
		list-style:none;
	}
	.pagingDiv a:link, .pagingDiv a:hover, .pagingDiv a:visited,
	.board_list a:link, .board_list a:hover, .board_list a:visited {
		color:#000;
	}
	.searchDiv {
		clear:left;
		padding:10px;
		text-align:center;
	}

</style>
<script>
$(function() {
	$("#searchForm").submit(function() {
		if($("#searchWord").val()=="") {
			alert("검색어를 입력하세요..");
			return false;
		}
		return true;
	});

</script>
</head>

<body>
<!-- Main -->
<section id="main" class="container">
<header>
   <h2>고객 센터</h2>
   <p>작은 목소리도 크게 귀담아 듣겠습니다.</p>
</header>

<div class="row">
<div class="col-12">
<section class="box">
   <div class="table-wrapper">
   <h2 style="text-align:left; padding:20px;">자주 묻는 질문</h2>
      <table>
         <thead>
            <tr>
               <th>글 번호</th>
               <th>제목</th>
               <th>작성자</th>
               <th>등록일</th>
               <th>등급</th>
            </tr>
         </thead>
            <tbody>
               <c:forEach var="CustomerCenterDTO" items="${list}">
                 <tr>
                  <td><c:out value="${CustomerCenterDTO.cus_b_num}"/></td>
                  <td>
                  	<a href="faqlist?cus_b_num=${CustomerCenterDTO.cus_b_num }"><c:out value="${CustomerCenterDTO.subject }"/></a>
                  </td>
                  <td>${CustomerCenterDTO.userid}</td>
                  <td>${CustomerCenterDTO.writedate}</td>
                  <td>${CustomerCenterDTO.rank }</td>
                 </tr>
               </c:forEach> 
            </tbody>
         </table>
         <!-- 페이징 -->	
	<div class="pagingDiv" id="wrappertwo">
		<ul>
			<!-- nowPage -->
			<c:if test="${vo.nowPage==1}"> <!-- 현재페이지가 1일때 -->
				<li>prev</li>
			</c:if>
			<c:if test="${vo.nowPage>1}"> <!-- 현재페이지가 1아닐때 -->
				<li><a href="customerBoard?nowPage=${vo.nowPage-1}<c:if test="${vo.searchWord != null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">prev</a></li>
			</c:if>
			
			<!-- 페이지번호 -->
			
			<c:forEach var="p" begin="${vo.startPageNum}" end="${vo.startPageNum+ vo.onePageNumCount-1}">
				<c:if test="${p <= vo.totalPage}"> <!-- 표시할 페이지 번호가 총페이지 수보다 작거나 같을 때 페이지 번호를 출력한다 -->
					<!-- 현재페이지 표시하기 -->
				<c:if test ="${p==vo.nowPage }">
					<li style="background:#ddd;">
				</c:if>	
				<c:if test ="${p!=vo.nowPage }">
					<li>
				</c:if>
					<a href="customerBoard?nowPage=${p}<c:if test="${vo.searchWord != null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">${p}</a></li>
				</c:if>
			</c:forEach>
			
			
			<!-- 다음페이지 -->
			<c:if test="${vo.nowPage==vo.totalPage}"> <!-- 현재페이지가 마지막일때 -->
				<li>next</li>
			</c:if>
			<c:if test="${vo.nowPage<vo.totalPage}"> <!-- 현재페이지가 마지막 아닐때 -->
				<li><a href="customerBoard?nowPage=${vo.nowPage+1}<c:if test="${vo.searchWord != null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">next</a></li>					
			</c:if>
			
		</ul>
	</div>

        <!-- 검색하기 -->	
	<div class ="searchDiv">
		<form method="get" id="searchForm" action="customerBoard">
			<select name = "searchKey" id="searchKey">
				<option value="subject">제목</option>
				<option value="userid">작성자</option>
				<option value="content">글내용</option>
			</select>
			<input type="text" name="searchWord" id="searchWord"/>
			<input type="submit" value="Search"/>
		</form>
	
	</div>	

	<!--  1:1 문의 만들기 -->
      <h2 style="text-align:left; padding:20px;">1:1문의</h2>

      
      </div>
      </section>
      </div>
      
   </div>
      </section>      
</body>
</html>