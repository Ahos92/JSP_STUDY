<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attribute Main Page</title>
</head>
<body>

<h3># Request Attribute</h3>
<p>
	request하나의 요청이 살아있는 동안 유지된다.(즉, 응답하기 전까지 유효하다 forward, include ...)
</p>

<strong>Key : <%=request.getAttribute("key") %></strong> <br>
<Strong>favColor : <%=request.getAttribute("favcolor") %></Strong> <br>
<% if (request.getAttribute("emplist") != null) { %>
<% for (String emp : (String[])(request.getAttribute("emplist"))) { %>
	<p><%=emp %></p>
<% } } %>

<hr>

<!-- ※ 세션과 어플리케이션 객체는 많은 양이ㅡ 데이터를 싣는 경우 서버의 성능이 저하될 우려가 깊다 -->
<h3># Session Attribute</h3>
<p>
	세션이 유효한 동안 유지된다. (사용자가 웹 브라우저를 종료하기 전까지 Attribute의 데이터가 유효하다)
</p>
<ul>
	<li>login : <%=session.getAttribute("login") %></li>
	<li>no_more_today : <%=session.getAttribute("no_more_today") %></li>
</ul>
<hr>

<h3># Application Attribute</h3>
<p>
	서버가 꺼지기 전까지 유지된다. 가장 유지되는 기간이 길다
</p>
<ul>
	<li><%=application.getAttribute("message") %></li>
	<li><%=application.getAttribute("id") %></li>
	<li><%=application.getServerInfo() %></li>
</ul>
</body>
</html>