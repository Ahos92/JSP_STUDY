<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지</title>
</head>
<body>

<h1 style="text-align: center">홈페이지</h1>

<c:choose>
	<c:when test="${empty login }" >
		<form action="./loginpage.jsp">
			<input type="submit" value="로그인 하세요~!"/>
		</form>
	</c:when>
	
	<c:otherwise>
		<h3>환영 합니다! '${login.name}'님</h3>
	</c:otherwise>
</c:choose>

<ul>
	<li><a href="./homeContent1.jsp"> 홈페이지 내용 1</a></li>
	<li><a href="./homeContent2.jsp"> 홈페이지 내용 2</a></li>
	<li><a href="./homeContent3.jsp"> 홈페이지 내용 3(로그인 필요)</a></li>
	<li><a href="./homeContent4.jsp"> 홈페이지 내용 4(로그인 필요)</a></li>
	<li>...</li>
</ul>



</body>
</html>