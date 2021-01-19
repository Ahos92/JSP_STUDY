<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.setAttribute("logincheck", false);

	response.sendRedirect("./loginpage");
%>