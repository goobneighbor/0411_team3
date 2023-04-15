<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

<!-- 카카오 스크립트 -->
<script>
Kakao.init('8eb7bc1501b18bca203ea80145d3d9ba'); // 반드시 본인꺼 쓰세요!!!!
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response);
        	  alert(response);
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
/*
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
*/


</script>
<style>
	#logFrm input{
		width:100%;	
	}
	#logFrm li:nth-child(2n) {
		padding-bottom:30px;
	}
	#logFrm li {
		list-style:none;	
	}
	#threestyle {
		width:100%;
		background-color:#E2D2D2;
		margin:20px;
		padding:30px;
		text-align:center;
		word-spacing: 40px;
	}
	a { 
		text-decoration: none; 
		color: black; 
	}
    a:visited { 
    	text-decoration: none; 
    }
    a:hover { 
    	text-decoration: none;
    }
    a:focus { 
    	text-decoration: none; 
    }
    a:hover, a:active { 
    	text-decoration: none; 
    }
</style>

<div class="container">
	<h1>로그인</h1>
	<form method="post" action="loginOk" id="logFrm">
		<ul>
			<li>아이디</li>
			<li><input type="text" name="userid" id="userid"/></li>
			<li>비밀번호</li>
			<li><input type="password" name="userpwd" id="userpwd"/></li>
			<li><input type="submit" value="LOGIN"/></li>
		</ul>
		<ul>
	<!-- <li onclick="kakaoLogin();"> 
      <a href="javascript:void(0)">-->
          <li><img src="resources/images/kakao_login.png" onclick="kakaoLogin()" alt=""/></li>
     
		</ul>
	</form>
	<div id="threestyle" >
		<a href="join">회원가입</a>
		<a href="idSearchForm">아이디찾기</a>
		<a href="pwdSearchForm">비밀번호찾기</a>
	</div>
</div>