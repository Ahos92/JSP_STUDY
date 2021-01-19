<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내용 3</title>
</head>
<body>

<c:choose>
	<c:when test="${login eq false || empty login}" >
		<form action="./loginpage">
			<input type="submit" value="로그인을 해야 보기가 가능합니다!"/>
		</form>
	</c:when>
	
	<c:otherwise>
		<h3>홈페이지 내용 3의 내용들</h3>
		<ul>
			<li>홈페이지 내용 3의 내용들 1</li>
			<li>홈페이지 내용 3의 내용들 2</li>
			<li>홈페이지 내용 3의 내용들 3</li>
		</ul>
	</c:otherwise>
</c:choose>


</body>
</html>