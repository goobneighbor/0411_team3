<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
<div class="container">
	<h1>로그인</h1>
	<form method="post" action="loginOk" id="logFrm">
		<ul>
			<li>아이디</li>
			<li><input type="text" name="userid" id="userid"/></li>
			<li>비밀번호</li>
			<li><input type="password" name="userpwd" id="userpwd"/></li>
			<li><input type="submit" value="확인"/></li>
		</ul>
	</form>
</div>
</body>
</html>