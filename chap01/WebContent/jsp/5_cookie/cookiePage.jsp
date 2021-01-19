<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 값에 따른 페이지 구성</title>
</head>
<body>

<h1>쿠키 적용 페이지</h1>

<c:if test="${empty cookie.nmt.value }">
<script>	
	result = window.confirm("확인?");
</script>
</c:if>

<c:choose>
	<c:when test="${empty cookie.ac.value}">
		쿠키 ac가 없음 : <input type="text" name="name" autocomplete="off"/>
	</c:when>
	<c:otherwise>
		쿠키 ac가 있음 : <input type="text" name="name" autocomplete="on" />
	</c:otherwise>
</c:choose>

</body>
</html>