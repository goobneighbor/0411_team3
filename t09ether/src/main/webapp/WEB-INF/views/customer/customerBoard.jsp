<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .inbox1 {
      float:left;
      width:24%;
      height:200px;
      border : 2px solid #ddd;
      border-radius: 20%;
      overflow: hidden;
      background-position:center;
   }   
   .inbox img {
      width:100%;
      height:80%;
      padding: 20px 20%;
   }
   .inbox3 {
      float:left;
      width:24%;
      height:200px;
      border : 2px solid #ddd;
      border-radius: 20%;
      overflow: hidden;
      background-position:center;
   }   
   .inbox5 {
      float:left;
      width:24%;
      height:200px;
      border : 2px solid #ddd;
      border-radius: 20%;
      overflow: hidden;
      background-position:center;
   }   
   .inbox2, .inbox4 {
      float:left;
      width:10%;
      height:200px;
      border : 2px solid #ddd;
      border-radius: 20%;
      overflow: hidden;
      background-position:center;
      display:none;
      margin: 0 auto;
   }
   #totalBox {
      margin: 0 auto;
   
   }
   
   
   
</style>
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
            </tr>
         </thead>
            <tbody>
               <c:forEach var="CustomerCenterDTO" items="${list}">
                 <tr>
                  <td>${CustomerCenterDTO.cus_b_num}</td>
                  <td>${CustomerCenterDTO.subject}</td>
                  <td>${CustomerCenterDTO.userid}</td>
                  <td>${CustomerCenterDTO.writedate}</td>
                 </tr>
               </c:forEach>   
            </tbody>
         </table>
      
      <h2 style="text-align:left; padding:20px;">1:1문의</h2>
         <div id="totalBox">
            <div class="inbox1">
               <img src="../resources/images/checklist.png" alt=""/>
               
               <p style="text-align:center;">1:1문의 접수</p>
            </div>
            
            <div class="inbox2">
            
            </div>
            <div class="inbox3">
            
            </div>
         
            <div class="inbox4">
            
            </div>
         
            <div class="inbox5">
            
            </div>
         </div>
      
      </div>
      </section>
      </div>
      
   </div>
      </section>      

   
</body>
</html>