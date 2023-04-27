<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
   .boardSubMenu{
      background:white;
      padding:40px 0;
   }
   #coment{
      width:50%;
      height:80px;
   }
   #commentList>li{
      padding:10px 0;
      border-bottom:1px solid #ddd;
   }
</style>
<script>
   function boardDel(){
      if(confirm("정말 삭제하시겠습니까?")){
         location.href = "boardDel?no=${dto.no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>";
      }
   }
   $(function(){
      
      //댓글 목록 가져오기(댓글이 없어도 있어야함)
      //ajax로 해당 게시물에 대한 모든 댓글을 선택하여 뷰에 표시하는 함수
      function commentList(){
         $.ajax({
            url : "/campus/commentList",
            data : {
               no : ${dto.no}
            },
            type : 'GET',
            success:function(comment){
               //원래 있는 댓글 목록 지움.
               //$("#commentList").html("");
               
               var tag = "";
               $(comment).each(function(i, cDTO){
                  tag += "<li><div><b>"+ cDTO.userid+" ("+cDTO.writedate+")</b>";
                  
                  //본인이 쓴 댓글일때 수정 삭제 버튼 표시
                  if(cDTO.userid=='${logId}'){//  처음에 왼쪽은 'goguma'  오른쪽은 goguma 라고 떠서 'goguma'를 만들기 위해 ' ' 추가
                     tag += "<input type='button' value='Edit'/>";
                     tag += "<input type='button' value='Del' title='"+cDTO.c_no+"'/>";
                     
                     tag += "<p>"+cDTO.coment+"</p></div>"; //댓글내용
                     
                     //댓글 수정폼을 만들기 - 기존 댓글과, 댓글번호(c_no)가 폼에 있어야함.
                     tag += "<div style='display:none'>";
                     tag += "<form method='post'>";
                     tag += "<input type='hidden' name='c_no' value='"+cDTO.c_no+"'/>"; //댓글 일련번호 
                     tag += "<textarea name='coment' style='width:400px; height:80px;'>"+cDTO.coment+"</textarea>";
                     tag += "<input type='submit' value='댓글수정하기'/>";
                     tag += "</form>";
                     tag += "</div>";
                     
                  }else{   
                     tag += "<p>"+cDTO.coment+"</p></div>"; //댓글내용
                  }
                  
                  tag += "</li>";
                  
               });
               
               $("#commentList").html(tag);
               
            },error:function(e){
               console.log(e.responseText);
            }
         });
         
      }
      
      
      //댓글쓰기-------------------------------------------
      $("#commentForm").submit(function(){
         //코멘트 있어야 ajax 실행
         //코멘트가 없을때
         if($("#coment").val()==""){
            alert("댓글을 입력하세요.");
            return false;
         }
         //코멘트 있을때
         //폼의 값을 쿼리문으로 만들기 
         //폼의 컴포넌트의 데이터를 name 속성 값과 value 속성의 값을 이용하여 쿼리문 만들어줌.
         
         //$("#commentForm").serialize() 도 가능
         var query = $(this).serialize(); //no=45&coment=어쩌구저쩌구 이렇게 설정되어 나옴
         console.log(query);
         $.ajax({
            url : "/campus/commentSend",
            data : query,
            type : "POST",
            success:function(result){
               console.log(result);
               
               //기존에 입력한 댓글 지우기
               $("#coment").val("");
               
               //댓글 목록 가져오기(댓글 쓸때마다도 있어야함)
               commentList();
               
            }, error:function(e){
               console.log(e.responseText);
            }
         });
         
         return false; // form의 기본 이벤트 때문에 다음 실행이 있고 그걸 중단
         
      });
      
      //댓글 수정폼 보여주기 : 본인이 쓴 글일때 Edit버튼을 클릭하면 글 내용은 숨기고, 폼을 보여줌.
      $(document).on('click','#commentList input[value=Edit]',function(){//body가 로그인되고 나서 나중에 추가된거라 $(document) 로 해줘야 함.
         //기존에 열어놓은 폼이나 숨겨놓은 댓글 내용을 처리하고
         //$("#commentList>li>div:nth-first").css('display','block');
         //$("#commentList>li>div:nth-first").css('display','none');
      
         ///
         $(this).parent().css("display","none");// 댓글 숨기고
         $(this).parent().next().css("display","block");// 폼 보여주고
      });
      
      //댓글 수정 - DB
      $(document).on('click','#commentList input[value=댓글수정하기]',function(){
         // 데이터준비
         var params = $(this).parent().serialize();// c_no=34&coment=어쩌구저쩌구
         var url = "/campus/commentEdit";
         
         $.ajax({
            url : url,
            data : params,
            type : "POST",
            success:function(result){
               console.log(result);
               //댓글목록 다시 가져오기
               commentList();
               
            }, error:function(e){
               console.log(e.responseText);
            }
         });
         return false;
         
      });
      //댓글 삭제
      $(document).on('click','#commentList input[value=Del]',function(){
         if(confirm("댓글을 삭제할까요?")){
            var params = "c_no="+ $(this).attr("title");
            console.log(params);
            var url = "/campus/commentDelete";
            
            $.ajax({
               url : url,
               data : params,
               success:function(result){
                  console.log(result);
                  //댓글목록 다시 가져오기
                  commentList();
                  
               },error:function(error){
                  console.log(error.responseText);
               }
            });
         }
         
      });
      
      // 댓글 목록 가져오기 - (댓글 쓰기 전)처음에 글 내용 보기로 오면 댓글 보여주기
      commentList();
      
   });
</script>
<div class="container">
   <h1>글 내용보기</h1>
   <ul id="view">
      <li>번호</li>
      <li>${dto.no }</li>
      <hr/>
      <li>글쓴이</li>
      <li>${dto.username }</li>
      <hr/>
      <li>조회수</li>
      <li>${dto.hit}</li>
      <hr/>
      <li>등록일</li>
      <li>${dto.writedate}</li>
      <hr/>
      <li>제목</li>
      <li>${dto.subject}</li>
      <hr/>
      <li>내용</li>
      <li>${dto.content}</li>
      <hr/>
   </ul>
   
   <div class="boardSubMenu">
      <a href="boardList?nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null }">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord }</c:if> ">글목록</a>
      
      <c:if test="${logId==dto.userid }">
         <a href="boardEdit?no=${dto.no }&nowPage=${vo.nowPage }<c:if test="${vo.searchWord!=null }">&searchKey=${vo.searchKey }&searchWord=${vo.searchWord }</c:if>">수정</a>
         <a href="javascript:boardDel()">삭제</a>
      </c:if>
   </div>
   <!-- 댓글 -->
   
   <hr/>
   <div>
      <c:if test="${logStatus=='Y'}"><!-- 로그인한 경우에만 댓글 쓰기 폼 보여주기 -->
         <form method="post" id="commentForm"> <!-- ajax에서 구현할 예정이라 action 없음 -->
            <input type="hidden" name="no" value="${dto.no}"/><!-- 원글 글번호 -->
            <textarea name="coment" id="coment"></textarea>
            <button>댓글 등록</button> <!-- submit 기능 존재 -->
         </form>
      </c:if>
      <ul id="commentList">
         
      </ul>
   </div>
   
</div>