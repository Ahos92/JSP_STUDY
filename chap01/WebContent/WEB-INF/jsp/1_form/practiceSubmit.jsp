<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Arrays"%>
<% 
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String address = request.getParameter("address");
	String edu = request.getParameter("edu");
	String[] hobby = request.getParameterValues("hobby");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습서브밋 페이지</title>
<style>
	h1{
		color: red; 
		text-align: center;
	}
	
	.info{
		padding-left: 45%;
	}
	
</style>
</head>
<body>
	
	<h1>정보 노출 위험</h1>
	<p>.JSP -> .JSP</p>
	<div class="info">
		<b>이름 : </b> <%=name %> <br />
		<br />
		<b>성별 : </b> <%=gender %> <br />
		<br />
		<b>주소 : </b> <%=address %> <br />
		<br />
		<b>학력 : </b> <%=edu %> <br />
		<br />
		<b>취미 : </b> <%=Arrays.toString(hobby) %> <br />
	</div>

</body>
</html>