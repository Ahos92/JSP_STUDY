<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// 간이 Servlet
	application.setAttribute("top", "가렌");
	session.setAttribute("top", "오른");
	request.setAttribute("top", "피오라");
	
	// pageContext : JSP페이지에서만 사용할 수 있는 영역. 이페이지를 벗어나면 수명이 다한다. (forward, include도 불가능)
	pageContext.setAttribute("top", "말파이트");
	
	// 범위 page < request < session < application 
%>

<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
<style>
th {
	background-color: teal;
	font-size: 20px;
	color: yellow;
}
</style>
</head>
<body>

<h3># JSP EL (Expression Language)</h3>
<ul>
	<li>Attribute에 저장된 값을 변수처럼 손쉽게 꺼낼 수 있는 문법이다.</li>
	<li>모든 scope의 데이터를 꺼낼 수 있다. (application, session, request, page)</li>
	<li>만약 모든 scope에같은 name을 지는 attribute가 있다면 가장 좁은 범위의 것을 먼저 사용한다.</li>
</ul>

<h3># EL로 Attribute의 값 꺼내보기</h3>
<dl>
	<dt>그냥 사용 : <a style="background-color: black; color: white;">${top }</a></dt>
	<dd>- 가장 가까운 범위의 값을 사용한다.</dd>
	<dt>pageScope : <a style="background-color: teal; color: white;">${pageScope.top }</a></dt>
	<dd>- page영역의 값을 사용한다.</dd>
	<dt>requestScope : <a style="background-color: red; color: white;">${requestScope.top }</a></dt>
	<dd>- request영역의 값을 사용한다.</dd>
	<dt>sessionScope : <a style="background-color: blue; color: white;">${sessionScope.top }</a></dt>
	<dd>- session영역의 값을 사용한다.</dd>
	<dt>applicationScope: <a style="background-color: purple; color: white;">${applicationScope.top }</a></dt>
    <dd>- application영역의 값을 사용한다.</dd>
</dl>


<h3># EL의 리터럴</h3>
<ul>
	<li>boolean : ${true }, ${false }</li>
	<li>int : ${123 }</li>
	<li>실수 : ${123.123 }</li>
	<li>문자열 : ${"string" }, ${'spring' }</li>
</ul>

<h3># EL의 연산자</h3>
<table border="1">
	<tr>
		<th>Name</th>
		<th>Operator</th>
		<th>Example</th>
	</tr>
	<tr>
		<td>산술</td>
		<td>+, -, *, /, %, mod</td>
		<td>${"${10 mod 7 }"} = ${10 mod 7 }</td>
	</tr>
	<tr>
		<td>비교</td>
		<td>==, !=, &lt;, &gt;, &le;, &ge;, eq, ne, lt, gt, le, ge</td>
		<td>
			${'${10 eq 10}' } = ${10 eq 10 } <br>
			${"${top eq '말파이트' }" } = ${top eq '말파이트' }
		</td>
	</tr>
	<tr>
		<td>논리</td>
		<td>and, or, not, &&, ||, !</td>
		<td>
			${"${true and true }" } = ${true and true } <br>
			${"${true or false }" } = ${true or false } <br>
		</td>
	</tr>
	<tr>
		<td>유효성 체크</td>
		<td>empty (var1 = "", var2 = null, var3= " ")</td>
		<td>
			<%
				// EL의 empty연산은 ""와  null을 모두 걸러낼 수 있다.
				pageContext.setAttribute("var1", "");
				pageContext.setAttribute("var2", null);
				pageContext.setAttribute("var3", " ");
			%>
			${"${empty var1}" } = ${empty var1 } <br>
			${"${empty var2}" } = ${empty var2 } <br>
			${"${empty var3}" } = ${empty var3 } <br>
		</td>
	</tr>
</table>

</body>
</html>