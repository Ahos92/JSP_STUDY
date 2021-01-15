<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="chap01.datamodel.Student" import ="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("login", false);

/* 	if(!(boolean)request.getAttribute("login")){
		response.sendRedirect(request.getContextPath() + "/attribute");
	} */
%>
<%-- 
페이지에 들어오기전에 조건을 체크해서 다른페이지로 리다이렉트
	<c:if test="${!login }">
		<c:redirect url="/attribute">
			<c:param name="fruits" value="banana"/>
			<c:param name="fruits" value="orange"/>
		</c:redirect>
	</c:if> 
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL (JSP Standard Tag Library)</title>
<style>
	p{
		color: green;
		font-weight: 700;
	}
	h5{
		color: red;
	}
	strong{
		color: blue;
	}
	table{
		border-top: 2px black teal;
		border-bottom: 2px black solid;
		border-spacing: 0px;
	}
	
	th{
		border-bottom: 2px black solid;
		border-right: 2px teal solid;
		border-left: 2px teal solid;
		background-color: teal;
		color: white;
	}
	
	td { 
		border-left: 2px black solid;
		border-right: 2px black solid;
		padding-top: 5px;
	}
	
	table > first-of-type(td){
		border-left: 2px black solid;
	}
	
</style>
</head>
<body>

<!-- jstl을 활용하려면 taglib import -->
<h3># c:set</h3>
<p>
	- scope.setAttribute를 축약한 태그
</p>

<!-- 영역을 지정하지 않으면 pageContext에 등록 된다 -->
<c:set var="a" value="10"/><!-- scope.setAttribute("a") a = 10; -->
<c:set var="b" value="20" scope="page"/><!-- page.setAttribute("b")  b = 20; -->
<c:set var="a" value="30" scope="request"/><!-- request.setAttribute("a") a = 30; -->
<c:set var="a" value="40" scope="session"/><!-- session.setAttribute("a")  a = 40; -->
<c:set var="a" value="50" scope="application"/><!-- application.setAttribute("a") a = 50; -->

${a }, ${requestScope.a }, ${sessionScope.a }, ${applicationScope.a } <br>
<%=pageContext.getAttribute("a") %>

<hr />

<h3># c:if</h3>
<p>
	- if문을 깔끔하게 사용할 수 있다. if문에 else if와 else가 없다.
</p>
<c:if test="${a ne 30 }">
	<h5>a = ${a }, 가장 가까운 영역(pageContext)의 a는 30이 아닙니다.</h5>
</c:if>

<hr />

<h3># c:choose, c:when, c:otherwise</h3>
<p>
	- switch-case문을 사용할 수 있다.
</p>
<c:choose>
	<c:when test="${applicationScope.a % 3 eq 0 }">
		<h5>서버에 저장된 a의 값은 3의 배수입니다.</h5>
	</c:when>
	<c:when test="${applicationScope.a % 4 eq 0 }">
		<h5>서버에 저장된 a의 값은 3의배수가 아니면서 4의 배수입니다.</h5>
	</c:when>
	<c:otherwise>
		<h5>서버에 저장된 a의 값은 3의 배수도 아니고, 4의 배수도 아닙니다.</h5>
	</c:otherwise>
</c:choose>

<hr />

<h3># c:url</h3>
<p>
	편리하게 원하는 url을 생성할 수 있다. <br />
</p>
<!-- .getContextPath()로 sever.xml에서 찾아갈 시작주소를 가져온다 -->

<a href="<%=application.getContextPath() %>/attribute">Attribute 테스트 하러가기~!</a><br />

<br />

<a href="<c:url value='/attribute'/>">Attribute 테스트 하러가기~!(c:url ver)</a> <br />

<br />

<!-- 같은 의미 -->
<%=application.getContextPath() %>/attribute?hobbies=${a }&hobbies=${a }&food=${a } <br />

<br />

<a href="<c:url value='/attribute'>
	<c:param name="hobbies" value="${a }"/>
	<c:param name="hobbies" value="${a }"/>
	<c:param name="food" value="${a }" />
</c:url>">a태그 안에 c:url태그를 사용 -> 과연 편한 것인가</a> <br />

<br />

<!-- 생성한 url을 변수에 저장후 사용하기(var="") -->
<c:url var="mylink" scope="session" value='/attribute'>
	<c:param name="hobbies" value="${a }"/>
	<c:param name="hobbies" value="${a }"/>
	<c:param name="food" value="${a }" />
</c:url>

<a href="${sessionScope.mylink }">mylink 변수로 만들어 편하게 사용하기</a>

<hr />

<h3># c:forEach</h3>
<p>
	for 문을 깔끔하게 사용할 수 있는 태그.
</p>

<% 
	pageContext.setAttribute("students", new Student[]{
		new Student("홍길동", 100),
		new Student("언더테이커", 10),
		new Student("리오넬메시", 5),
		new Student("세종대왕", 1000),
	});

	ArrayList<Student> student_list = new ArrayList<>();
	student_list.add(new Student("임종훈", 100));
	student_list.add(new Student("현태환", 100));
	student_list.add(new Student("임원영", 100));
	student_list.add(new Student("이원석", 100));
	pageContext.setAttribute("student_list", student_list);
%>

<!-- 1. c:forEach 향상된for문 버전 - begin속성과 end속성 사용 -->
<dl>
<c:forEach var="student" items="${students }" varStatus="forloop">
	<dt>
		<strong>
			${forloop.index }번째 반복 입니다. (index) / ${forloop.count }번째 반복입니다. (count)<br />
			첫 번째 반복인가? ${forloop.first }. / 마지막 반복인가? ${forloop.last }. <br />
		</strong>
	</dt>
	<dd>- [${student.name } / ${student.kor }]</dd>
	<br />
</c:forEach>
</dl>

<dl>
<c:forEach var="student" items="${student_list }" varStatus="forloop">
	<dt><strong>${forloop.index }번째 반복 입니다.</strong></dt>
	<dd>- [${student.name } / ${student.kor }]</dd>
</c:forEach>
</dl>

<!-- 2. c:forEach 기본 for문 버전 - begin속성과 end속성 사용 -->
<c:forEach var="i" begin="0" end="${student_list.size() - 1 }">
	<p>${student_list.get(i).name } / ${student_list.get(i).kor }</p>
</c:forEach>

<!-- c:forEacn를 이용해 구구단 테이블을 출력해보세요 -->
<table>
<tr>
	<c:forEach var="j" begin="2" end="9">
		<th>${j }단</th>		
	</c:forEach>
</tr>
<c:forEach var="i" begin="1" end="9">
	<tr>
		<c:forEach var="j" begin="2" end="9">
			<td>${j } x ${i } = ${i*j } &nbsp;&nbsp;</td>
		</c:forEach>
	</tr>
</c:forEach>
</table>

<hr />

<h3># c:forTokens</h3>
<p>
	split()을 적용한 뒤 하나씩 반복하는 반복문.
</p>
<c:set var="colors" value="red/blue/purple/skyblue/dodgerblue/navy/peru/lime"/>

<c:forTokens var="color" items="${colors }" delims="/">
	<div style="border: solid ${color} 3px;">${color } color div</div>
</c:forTokens>

</body>
</html>