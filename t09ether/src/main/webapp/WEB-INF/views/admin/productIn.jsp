<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#proIn ul{
		
	}
	
	#proIn li{
		list-style:none;
	}
</style>
<h1>상품 등록</h1>
<div class="container">
<form method="post" id="proIn">
	<ul> 
		<li>상품명</li>
		<input type="text" name="pro_name" id="pro_name"/>
		<li>상품가격</li>
		<input type="number" name="pro_price" id="pro_price"/>
		<li>재고개수</li>
		<li><input type="number" name="pro_stock" id="pro_stock"/></li>
		<li>상품이미지</li>
		<li><input type="file" name=image id="image" accept=".gif, .jpg, .png"/></li>
	</ul>
</form>
</div>