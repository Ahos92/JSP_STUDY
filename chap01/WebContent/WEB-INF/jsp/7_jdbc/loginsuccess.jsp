<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.setAttribute("login", true);
	session.setAttribute("logincheck", true);
	session.getAttribute("user_name");

	response.sendRedirect("./home");
%>