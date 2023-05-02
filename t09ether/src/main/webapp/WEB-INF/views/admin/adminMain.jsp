<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<section id="main" class="container">
      <header>
         <h2></h2>
       
      </header>
      <div class="row">
         <div class="col-12">
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">관리자 페이지</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">관리자 메인페이지</li>
                        </ol>                     
                        <div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                        Area Chart Example
                                    </div>
                                    <div class="card-body"><%-- <canvas id="myAreaChart" width="100%" height="40"></canvas> --%></div>
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Bar Chart Example
                                    </div>
                                    <div class="card-body"><%-- <canvas id="myBarChart" width="100%" height="40"></canvas> --%></div>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                가입한 회원 정보
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>아이디</th>
                                            <th>이름</th>
                                            <th>연락처</th>
                                            <th>이메일</th>
                                            <th>가입일</th>
                                            <th>등급</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <c:forEach var="aDTO" items="${list}">
                                        <tr>
                                            <td>${aDTO.userid }</td>
                                            <td>${aDTO.username }</td>
                                            <td>${aDTO.tel }</td>
                                            <td>${aDTO.email }</td>
                                            <td>${aDTO.writedate }</td>
                                            <td>${aDTO.rank }</td>
                                        </tr>
                                        </c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
                
            </div>
      <!--   </div>  -->
</body>
         </div>
      </div>
   </section>