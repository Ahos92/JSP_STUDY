<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Arrays"%>
<% 
	request.setCharacterEncoding("UTF-8");
	// JSP에는 기본적으로 만들어져있는 내장객체들이존재한다. (request, out ...)
	String customer_name = request.getParameter("customer_name");
	String topping = request.getParameter("topping");
	String[] side = request.getParameterValues("side");
	String cs = request.getParameter("cs");
%>
<!DOCTYPE html>
<html><%--out.print("<html>"); --%>
<head>
<meta charset="UTF-8">
<title>pizzaSubmit Page</title>
</head>
<body>

	<strong>고객명 : </strong> <%=customer_name %> <br />
	<strong>피자 : </strong> <%=topping %> <br />
	<strong>추가옵션 : </strong> <%=Arrays.toString(side) %> <br />
	<%--
		for (int i = 0; i < side.length; ++i) {
			out.print(side[i]);
			if (i != side.length - 1){
				out.print(", ");
			} else{
				out.print("<br>");
			}
		}
	--%>
	<strong>고객명 : </strong> <%=cs %> <br />
	
</body>
</html>