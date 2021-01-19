<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<h1 style="text-align: center"> 로그인 페이지 </h1>

<form action="./home.jsp" method="POST">
<h2 style="text-align: center">
	아이디 : <input type="text" name="user_id"/><br />
	<br />
	비밀번호 : <input type="password" name="user_password"/><br />
	<br />
	<input type="submit" value="로그인"/>
</h2>
</form>

</body>
</html>