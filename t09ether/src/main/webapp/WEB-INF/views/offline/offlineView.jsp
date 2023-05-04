<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
<<<<<<< HEAD
=======
<<<<<<< HEAD
	#view>li{
			padding:5px 0;
			border-bottom:1px solid #ddd;
			list-style-type: none;
		}
	.boardSubMenu{
		background: #fff;
		padding:50px 0;
	}
	#commentList>li{
			padding:10px;
			border-bottom:1px solid #ddd;
			list-style-type: none;
		}
	.boardSubMenu{			
		background: #fff;
		padding:0 0 10px 30px;;
	}
	.boardSubMenu a{
		border:1px solid #FEE8B0;
		border-radius :10px;
		background:#F79540;
		color:#FEE8B0;
		font-size:1.2em;
		padding: 10px;
	}	

	#coment{
			width:50%;
			height:80px;
		}
	.bg-tomato py-5{
		margin:0;
		padding:0;
	}
	
	.jr{
		list-style-type: none;
	}

	.join{
		width:110px;
		border:1px solid tomato;
		border-radius: 10px;
		background-color : yellow;	
		float:left;	
		
	}
	.report{
		width:100px;
		border:1px solid tomato;
		border-radius: 10px;
		background-color : orange;
		color:#fff;
		float:right;	
		text-align: center;
	}
	#offlineJoin{
		margin:0 auto;
		text-align: center;
	}
	.joinButton, .detailButton{
		margin:0 auto;
		background:##A4D0A4;
	}
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	  text-align: center;
	}
	.theader th{
		text-align: center;
	}
	td, th {
	  border: 1px solid #ddd;
	  padding: 8px;
	}

	tr:nth-child(even) {
	  background-color: orange;
	}
	tr:nth-child(odd) {
	  background-color: yellow;
	}
	.joinDiv{
		margin: 10px auto;
	}
	.joinDiv input{
=======
>>>>>>> ba3f6ef08de907eae6cbeb0dcbbe63222e7aa602
   #view, #view2, #viewParty ,#view3 {
      list-style:none;
   }
   #view li:first-child{
      font-size:30px;
      float:left;
      width:70%;
      padding:15px;
   }
   #view li:nth-child(2){
      float:right;
      width:20%;
      padding-top:30px;
   }
   #view{
      height:75px;
      margin-bottom:40px;
      border-top:1px solid #ddd;
      border-bottom:1px solid #ddd;
   }
   #view2{
      margin:10px 0;
      padding:0;
      height:90px;
      border-top:1px solid #ddd;
      border-bottom:1px solid #ddd;
   }
   #view2 li{
      float:left;
      width:15%;
      border-right:1px solid #ddd;
      border-left:1px solid #ddd;
      line-height:40px;
      height:90px;
      padding: 8px;
      text-align:center;
   }
   #view2 li:nth-child(3){
      width: 40%;
   }
   #viewParty{
      text-align:center;
      margin:auto;
      padding:0;
      height:90px;
      border-bottom:1px solid #ddd;
   }
   #viewParty li{
      display:inline-block;
      width:15%;
      line-height:40px;
      height:20px;
      padding: 8px;
      text-align:center;
   }
   #view3 {
      border: 1px solid #ddd;
      height:500px;
      margin: 0;
      padding: 0 32px;
   }
   
   #view3 li {
       text-align:left;
       margin:32px 0 16px 0;
   }
   .joinDiv input{
<<<<<<< HEAD
=======
>>>>>>> 5b53ef0a20bfd809b3afe3cf7fa168cfac913ae4
>>>>>>> ba3f6ef08de907eae6cbeb0dcbbe63222e7aa602
		float: left;
		margin :10px 10px;;
	}
	
	
	.bottomMenu{
		float:left;
		width:100%;

	}
	
	.boardSubMenu {
		float: left;
		margin: 0 0 0 5px;
	}
	.joinDiv{
		margin: 0 0 20px 0;
		width:60%;
		float:right;		
	}
	.joinDiv input{
		float:right;
	}
	.detailButton{
		position: relative;
		top: -40px;	
	}
	.joinButton{
		position:relative;
		top: -10px;
	}
	.writedate{
		width:30px;
	}
</style>
<script>

	function offlineDel(){
		if(confirm("정말 삭제하시겠습니까?")){
			location.href="offlineDel?off_no=${dto.off_no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>";
		}	
	}
	
	$(function(){
		var userid = '<%=session.getAttribute("logId")%>';	
		console.log("userid="+userid);
		$(".joinButton").click(function(){	
				if(!confirm(userid+"님 공동구매에 참여하시겠습니까?")){
					//아니오 -> 참여안함
					alert("공동구매 참여가 취소되었습니다.");
					return false;
				}else{//예 -> 참여함
					if(${dto.current_num}>=${dto.group_num}){//자리없으면 돌려보내기
						alert("정원이 가득 찼습니다");
						return false;
					}	
				}
			});
		});
</script>
<<<<<<< HEAD
=======
<<<<<<< HEAD
<div class="container">
	<!-- Header-->
	<header class="bg-tomato py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
	        	<h1 class="display-4 fw-bolder" style="color:#FFF">오프라인 공동구매 참여하기</h1>	           
	        </div>
	    </div>
	</header>
	<ul id="view">
		<li>번호 : ${dto.off_no}</li>	
		<li>제목 : ${dto.off_subject}</li>
		<li>처리상태 : 
			<c:choose>
				<c:when test="${dto.status==1}">진행중</c:when>
				<c:otherwise>마감</c:otherwise>
			</c:choose>
		</li>	
		<li>등록일 : ${dto.writedate}</li>	
		<li>작성자 : ${dto.userid}</li>		
		<li>조회수 : ${dto.off_hit}</li>	
		<li>모집인원 : ${dto.group_num}</li>
		<li>현재인원 : ${dto.current_num}</li>	
		<li>모집마감일 : ${dto.deaddate}</li>				
		<li>만남시간 : ${dto.app_time}</li>					
		<li>상세정보 : ${dto.off_content}</li>
		
		<li class="report"><a href="offlineReport">신고하기</a></li>
			
	</ul>
	<div class="boardSubMenu">		
		<!-- 작성자와 로그인 아이디 같은경우 수정 삭제 버튼 -->		
		<c:if test="${logId==dto.userid}">
			<a href="offlineEdit?off_no=${dto.off_no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">수정</a>
			<a href="javascript:offlineDel()">삭제</a>
		</c:if>
	</div>
	
	<br/>	
	<!-- 참여자 정보(아이디만 보이게) -->
	<div id="participantList">	
		<div style="text-align: center; color:tomato;">[참여자 정보]</div>	
		<div style="text-align: center; color:#A4D0A4;"> ※ 공동구매에 참여하시면 참여자들에 대한 더 자세한 정보를 알 수 있습니다 ※</div>
		<table>
			<tr class="theader">
			    <th>번호</th>
			    <th>아이디</th>			    
			</tr>			  
		<c:forEach var="opDTO" items="${list}" varStatus="status">
			<tr class="infoDetail">
				<td style="width:6%; text-align:center;">${status.count}</td>
				<td>${opDTO.userid}<c:if test="${opDTO.userid==dto.userid}"> (방장)</c:if></td>
			</tr>
		</c:forEach>
		</table>
	</div>
	
	
	<!-- 지금참여하기/리뷰쓰러가기 버튼 -->
	<div class="joinDiv">
		<c:if test="${logStatus=='Y'&& dto.status==1}">
			<form method="post" action="offlineJoin" id="offlineJoin">
					<input type="hidden" name="off_no" value="${dto.off_no}"/>
					<input type="submit" value="지금참여하기" class="joinButton"/>					
			</form>
		</c:if>
		<!-- 이미 참여되어있는 사람은 상세정보 페이지로 이동할 수 있는 버튼 -->
		<c:forEach var="ids" items="${idList}">
			<c:if test="${nowId==ids}">
				<form method="post" action="offlineJoin" id="offlineJoin">
					<input type="hidden" name="off_no" value="${dto.off_no}"/>
					<input type="submit" value="공구페이지로 이동" class="detailButton"/>					
			</form>
			</c:if>
		</c:forEach>		
		<c:if test="${logStatus=='Y'&& dto.status==2}">
			<form method="get" action="offlineFinished" id="offlineFinished">
				<input type="hidden" name="off_no" value="${dto.off_no}"/>
				<input type="submit" value="리뷰쓰러가기" id="reviewButton"/>
			</form>
		</c:if>
	</div>
</div>
=======
>>>>>>> ba3f6ef08de907eae6cbeb0dcbbe63222e7aa602
<header class="bg-tomato py-5" style="background-image:url('<%=request.getContextPath() %>/resources/images/test_banner.jpg'); background-size: 107% 100%">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
        	<h1 class="display-4 fw-bolder" style="color:#7d7b7a">오프라인 공동구매</h1>
        </div>
    </div>
</header>
<section style="height:30px"></section>
<section id="main" class="container">
   <ul id="view" class="major">
      <!-- <li>원글번호</li>
      <li>${dto.off_no }</li>
      <hr/> -->
      <li>${dto.off_subject }</li>
      <li>작성일: ${dto.writedate}</li>
   </ul>
   <section>
      <ul id="view2">
         <li>공구장 <br/>${dto.userid}</li>
         <li>현재인원/모집 인원 <br/>${dto.current_num}/${dto.group_num}</li>
         <li>만남장소 <br/>${dto.location}</li>
         <li>만남날짜 <br/>${dto.app_time}</li>
         <li>모집마감일 <br/>${dto.deaddate}</li>
      </ul>
   </section>
   <section>
         <ul id="viewParty">
            <li style="color:tomato; font-size: 1.3em;">[현재 참여자 정보]</li><br/>
               <c:forEach var="bDTO" items="${list}">
                  <li>${bDTO.userid}<c:if test="${bDTO.userid==dto.userid}">(공구장)</c:if></li>
               </c:forEach>
         </ul>
      
   </section>
   <section class="box special" style="padding:0; margin-top:50px;">
      <ul id="view3">
         <li>${dto.off_content}</li>   
      </ul>
   </section>
   <div class="bottomMenu">
  	   <!-- 목록,수정,삭제 버튼 / 지금참여하기/리뷰쓰러가기버튼-->
	   <div class="boardSubMenu">
	         <a class="btn btn-outline-dark mt-auto" href="offline?nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null }">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord }</c:if> ">목록</a>
		      <!-- 작성자와 로그인 아이디 같은경우 수정 삭제 버튼 -->		
			<c:if test="${logId==dto.userid}">
				<a class="btn btn-outline-dark mt-auto" href="offlineEdit?off_no=${dto.off_no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">수정</a>
				<a class="btn btn-outline-dark mt-auto" href="javascript:offlineDel()">삭제</a>
			</c:if>
			<!-- 지금참여하기/리뷰쓰러가기 버튼 -->
		</div>
		
		<div class="joinDiv">	
				<c:if test="${logStatus=='Y'&& dto.status==1}">
					<form method="post" action="offlineJoin" id="offlineJoin">
							<input type="hidden" name="off_no" value="${dto.off_no}"/>
							<input type="submit" value="지금참여하기" class="joinButton"/>					
					</form>
				</c:if>
				<!-- 이미 참여되어있는 사람은 상세정보 페이지로 이동할 수 있는 버튼 -->
				<c:forEach var="ids" items="${idList}">
					<c:if test="${nowId==ids && dto.status==1}">
						<form method="post" action="offlineJoin" id="offlineJoin">
							<input type="hidden" name="off_no" value="${dto.off_no}"/>
							<input type="submit" value="공구페이지로 이동" class="detailButton"/>					
					</form>
					</c:if>
					
				</c:forEach>		
				<c:if test="${logStatus=='Y'&& dto.status==2}">
					<form method="get" action="offlineFinished" id="offlineFinished">
						<input type="hidden" name="off_no" value="${dto.off_no}"/>
						<input type="submit" value="리뷰쓰러가기" id="reviewButton"/>
					</form>
				</c:if>
		</div>
	</div>
</section>
<<<<<<< HEAD
=======
>>>>>>> 5b53ef0a20bfd809b3afe3cf7fa168cfac913ae4
>>>>>>> ba3f6ef08de907eae6cbeb0dcbbe63222e7aa602
