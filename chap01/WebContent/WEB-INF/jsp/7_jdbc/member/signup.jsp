<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/7_jdbc/jspfrag/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<c:choose>
	<c:when test="${signCheck eq false}">
		<c:remove var="signCheck" scope="session"/>
		<script>
			 alert("이미 등록된 아이디 입니다.");
		</script>
	</c:when>	
</c:choose>

<h1>회원 가입 페이지</h1>

<form action="<c:url value='/signup_check'/>" method="POST">
아이디 : <input type="text" name="user_id"/> <br />
비밀번호 : <input type="password" name="user_password"/><br />
이름 : <input type="text" name="user_name"/><br />
나이 : <input type="text" name="user_age"/><br />
<input type="submit" value="회원가입"/>
</form>

<a href="<c:url value='/home'/>">메인으로 돌아가기</a>

</body>
</html>