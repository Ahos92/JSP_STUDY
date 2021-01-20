<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<h1 style="text-align: center"> 로그인 페이지 </h1>

<c:choose>
	<c:when test="${logincheck eq false}" >
		<script>
			 alert("아이디나 비밀번호가 맞지않습니다.");
		</script>
	</c:when>
	
	<c:when test="${signCheck eq true }">
		<c:remove var="signCheck" scope="session"/>
		<script>
			 alert("회원가입이 성공적으로 완료되었습니다.");
		</script>
	</c:when>
	
</c:choose>

<form action="<c:url value='/loginpage'/>" method="POST">
	<h2 style="text-align: center">
		아이디 : <input type="text" name="user_id"/><br />
		<br />
		비밀번호 : <input type="password" name="user_password"/><br />
		<br />
		<input type="submit" value="로그인"/>
	</h2>
</form>

<a href="<c:url value='/home'/>">메인으로 돌아가기</a>

</body>
</html>