<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#wrapper {
		display: grid;
		place-items: center;
		min-height: 10vh;
	}
	#searchForm{
		text-align:center;
	}
	#searchKey, #searchWord, #search{
		display:inline-block;
	}
	#searchKey { /*제목임*/
		width:15%;
		margin: auto;
	}
	#searchWord { /*검색칸*/
		width:40%;
		margin: auto;
	}
	.searchDiv{
		padding:10px;
		text-align: center;	
		width:100%;	
	}
	.paging_div li{
		float:left;
		padding:10px 20px;
		list-style:none;
	}
	.paging_div a:link, .paging_div a:hover, .paging_div a:visited{
		color:#000;
	}
</style>
<script>
	$(function(){
		$("#searchForm").submit(function(){
			if($("#searchWord").val()==""){
				alert("검색어를 입력하세요.");
				return false;
			}
			return true;
		});
		
		//--- 전체 선택 클릭하면 체크박스 상태에 따라 선택 또는 해제 하는 기능 구현
		$("#allCheck").click(function(){
			$(".board_list input[name=noList]").prop("checked", $("#allCheck").prop("checked"));
			
		});
		
		//선택 삭제 버튼 클릭하면
		$("#chooseDel").click(function(){
			// 최소 1개 이상 삭제를 선택했을 때
			
			var checkCount = 0;
			$(".board_list input[name=noList]").each(function(idx, obj){
				if(obj.checked){ //$(obj.prop('checked'))>jquery 근데 안됨..
					checkCount++;
				}
			});
			
			if(checkCount>0){
				if(confirm(checkCount+'개의 글을 삭제 하시겠습니까?')){
					$("#delList").submit();
				}
			}else{
				alert("한 개 이상의 글을 선택 후 삭제 하세요.");
			}
		});
		
	});
</script>
	<!-- Main -->
	<section id="main" class="container">
		<header>
			<h2>온라인 공구 내역</h2>
			<p>진행중인 내역</p>
		</header>
		<div class="row">
			<div class="col-12">
				<!-- 주문내역 리스트 -->
				
				<section class="box">
					<div class="table-wrapper">
					<form method="post">
					<input type="hidden" name="nowPage" value="${vo.nowPage }"/>
					<c:if test="${vo.searchWord!=null}">
						<input type="hidden" name="searchKey" value="${vo.searchKey }"/>
						<input type="hidden" name="searchWord" value="${vo.searchWord }"/>
					</c:if>
				
						<table class="board_list">
							<thead>
								<tr>
									<th><input type="checkbox" id="allCheck"/>전체선택</th>
									<th>글번호</th>
									<th>주문번호</th>
									<th>상품코드</th>
									<th>상품명</th>
									<th>공구장</th>
									<th>주문 개수</th>
									<th>주문 날짜</th>
									<th>취소</th>
								</tr>
							</thead>
							
							<tbody>
							<c:set var="recordNum" value="${vo.totalRecord-(vo.nowPage-1)*vo.onePageRecord}"/>
							<c:forEach var="bDTO" items="${list}">
								<c:if test="${bDTO.status==1}">
								<tr>
									<td><input type="checkbox" name="noList" value="${bDTO.username}"/></td>
									<td>${recordNum}</td>
									<td>${bDTO.ord_no }</td>
									<td>${bDTO.pro_code }</td>
									<td>${bDTO.pro_name }</td>
									<td>${bDTO.userid }</td>
									<td>${bDTO.ord_count }</td>
									<td>${bDTO.orderdate }</td>
									<td><input type="button" id="payCancel" onclick="location.href='<%=request.getContextPath() %>/pay/payCancel?ord_no=${bDTO.ord_no}'" value="결제 취소"/></td>
								</tr>
								</c:if>
								<c:set var="recordNum" value="${recordNum-1}"/>	
							</c:forEach>
							</tbody>
							<!--<tfoot>
								<tr>
									<td colspan="2"></td>
									<td>100.00</td>
								</tr>
							</tfoot>  -->
						</table>
					</form>
					</div>
					<div>
						<input type="button" value="영구제명" id="chooseDel"/>
					</div>
					<!-- 페이징 -->
					<div  id="wrapper">
					<div class="paging_div"> 
						<ul>
							<!-- 이전 페이지 : nowPage를 기준으로 -->
							<c:if test="${vo.nowPage==1}"><!-- 현재 페이지가 첫번째 페이지 일때 -->
								<li></li>
							</c:if>
							<c:if test="${vo.nowPage>1}"><!--  현재 페이지가 첫번째 페이지가 아닐때 -->
								<li><a href="myOrder?nowPage=${vo.nowPage-1}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">이전</a></li>
							</c:if>
							<!-- 페이지 번호 -->
							
				         <c:forEach var="p" begin="${vo.startPageNum}" end="${vo.startPageNum+vo.onePageNumCount-1}">
				            <c:if test="${p<=vo.totalPage}"><!-- 표시할 페이지 번호가 총 페이지 수보다 작거나 같을 때 페이지 번호 출력.-->
				               <!-- 현재페이지 표시하기 -->
				               <c:if test="${p==vo.nowPage}">
				                  <li style="background:#ddd;">
				               </c:if>
				               <c:if test="${p!=vo.nowPage}">
				                 <li>
				               </c:if>
				                  <a href="myOrder?nowPage=${p}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">${p}</a>
				                  </li>
				            </c:if>
				         </c:forEach>
							
							<!-- 다음 페이지 -->
							<c:if test="${vo.nowPage<vo.totalPage}"><!-- 다음 페이지가 있을 때 -->
								<li><a href="myOrder?nowPage=${vo.nowPage+1}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">다음</a></li>
							</c:if>
							<c:if test="${vo.nowPage==vo.totalPage}"><!-- 다음 페이지가 없을 때 -->
								<li></li>
							</c:if>
						</ul>
					</div>
					<!--검색 -->
					<div class ="searchDiv">
						<form method="get" id="searchForm" action="myOrder">
							<select name = "searchKey" id="searchKey">
								<option value="userid">참가자</option>
								<option value="orderdate">주문날짜</option>
							</select>
							<input type="text" name="searchWord" id="searchWord"/>
							<input type="submit" value="Search" id="search"/>
						</form>
					</div>
					</div>
				</section>
			</div>
		</div>
	</section>
	<!-- Main -->
	<section id="main" class="container">
		<header>
			<h2> </h2>
			<p>완료 내역</p>
		</header>
		<div class="row">
			<div class="col-12">
				<!-- 주문내역 리스트 -->
				
				<section class="box">
					<div class="table-wrapper">
					<form method="post">
					<input type="hidden" name="nowPage" value="${vo.nowPage }"/>
					<c:if test="${vo.searchWord!=null}">
						<input type="hidden" name="searchKey" value="${vo.searchKey }"/>
						<input type="hidden" name="searchWord" value="${vo.searchWord }"/>
					</c:if>
				
						<table class="board_list">
							<thead>
								<tr>
									<th><input type="checkbox" id="allCheck"/>전체선택</th>
									<th>글번호</th>
									<th>주문번호</th>
									<th>상품코드</th>
									<th>상품명</th>
									<th>공구장</th>
									<th>주문 개수</th>
									<th>주문 날짜</th>

								</tr>
							</thead>
							
							<tbody>
							<c:set var="recordNum" value="${vo.totalRecord-(vo.nowPage-1)*vo.onePageRecord}"/>
							<c:forEach var="bDTO" items="${list}">
								<c:if test="${bDTO.status==2}">
								<tr>
									<td><input type="checkbox" name="noList" value="${bDTO.username}"/></td>
									<td>${recordNum}</td>
									<td>${bDTO.ord_no }</td>
									<td>${bDTO.pro_code }</td>
									<td>${bDTO.pro_name }</td>
									<td>${bDTO.userid }</td>
									<td>${bDTO.ord_count }</td>
									<td>${bDTO.orderdate }</td>
								</tr>
								</c:if>
								<c:set var="recordNum" value="${recordNum-1}"/>	
							</c:forEach>
							</tbody>
							<!--<tfoot>
								<tr>
									<td colspan="2"></td>
									<td>100.00</td>
								</tr>
							</tfoot>  -->
						</table>
					</form>
					</div>
					<div>
						<input type="button" value="영구제명" id="chooseDel"/>
					</div>
					<!-- 페이징 -->
					<div id="wrapper"> 
					<div class="paging_div"> 
						<ul>
							<!-- 이전 페이지 : nowPage를 기준으로 -->
							<c:if test="${vo.nowPage==1}"><!-- 현재 페이지가 첫번째 페이지 일때 -->
								<li></li>
							</c:if>
							<c:if test="${vo.nowPage>1}"><!--  현재 페이지가 첫번째 페이지가 아닐때 -->
								<li><a href="myOrder?nowPage=${vo.nowPage-1}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">이전</a></li>
							</c:if>
							<!-- 페이지 번호 -->
							
				         <c:forEach var="p" begin="${vo.startPageNum}" end="${vo.startPageNum+vo.onePageNumCount-1}">
				            <c:if test="${p<=vo.totalPage}"><!-- 표시할 페이지 번호가 총 페이지 수보다 작거나 같을 때 페이지 번호 출력.-->
				               <!-- 현재페이지 표시하기 -->
				               <c:if test="${p==vo.nowPage}">
				                  <li style="background:#ddd;">
				               </c:if>
				               <c:if test="${p!=vo.nowPage}">
				                 <li>
				               </c:if>
				                  <a href="myOrder?nowPage=${p}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">${p}</a>
				                  </li>
				            </c:if>
				         </c:forEach>
							
							<!-- 다음 페이지 -->
							<c:if test="${vo.nowPage<vo.totalPage}"><!-- 다음 페이지가 있을 때 -->
								<li><a href="myOrder?nowPage=${vo.nowPage+1}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">다음</a></li>
							</c:if>
							<c:if test="${vo.nowPage==vo.totalPage}"><!-- 다음 페이지가 없을 때 -->
								<li></li>
							</c:if>
						</ul>
					</div>
					
					
					<!--검색 -->
					<div class ="searchDiv">
						<form method="get" id="searchForm" action="myOrder">
							<select name = "searchKey" id="searchKey">
								<option value="userid">참가자</option>
								<option value="orderdate">주문날짜</option>
							</select>
							<input type="text" name="searchWord" id="searchWord"/>
							<input type="submit" value="Search"/>
						</form>
					</div>
					</div>
				</section>
			</div>
		</div>
	</section>