<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap, java.util.HashSet, myutil.Calculator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
<h1 style="color: white; background-color: teal;">일주일 후 날짜: <%= Calculator.nextWeek()%></h1>
<h1><%= Calculator.plus(10, 15)%></h1>
<h3># HTTP 통신 순서</h3>
<ol>
	<li>서버는 항상 켜져있고, 클라이언트의 요청을 기다린다</li>
	<li>클라이언트는 서버로 요청(보고싶은 페이지의 주소와 각종 요청 정보들)을 보낸다.</li>
	<li>서버는 요청 정보를 보고 알맞은 응답을 생성해주어야 한다.</li>
	<li>클라이언트의 웹 브라우저가 응답을 받아 클라이언트에게 웹 페이지를 보여준다.</li>
</ol>
<%-- .JSP  ---compile---> .HTML --%>

<h3># JSP와 Servlet의 관계</h3>
<ul>
	<li>
		Servlet : request를 받고 response를 응답하는 클래스<br>
			어떤 방식으로 요청했느냐에 따라서 도착하는 메서드가 다르다.<br>
	</li>
	<li>JSP : Servlet과 똑같은 일을 하지만, .html을 생성할 때 편하도록 만들어진 것</li>
	<li>JSP에서 최대한 자바를 다루지 않는것이 훨씬 편리하다.</li>
</ul>

<h3># JSP (Java Sever Page)</h3>
<ul>
	<li>HTML에 자바 문법을 사용할 수 있는 페이지</li>
	<li>JAVA를 활용 하여 여러 계산을 통해 상황마다 결과가 달라지는 웹 페이지를 만들 수 있다.</li>
</ul>

<%-- JSP script --%>
<%--
	<%	%> : 모든 자바 코드를 사용할 수 있는 영역
	<%!	%> : 함수를 선언할 수 있는 영역
	<%=	%> : 원하는 자바 값를 HTML에 간편하게 출력할 수 있다.
	<%@	%> : 페이지 설정 문법이 적용되는 영역
 --%>


<%!
	private String createDiv(String content) {
		return String.format("<div>%s</div>", content);
	}
%>

<%
	out.print(createDiv("AAAA"));
	out.print(createDiv("BBBB"));
	out.print(createDiv("CCCC"));
	out.print(createDiv("DDDD"));
%>

<%=createDiv("ABCD") %>
</body>
</html>