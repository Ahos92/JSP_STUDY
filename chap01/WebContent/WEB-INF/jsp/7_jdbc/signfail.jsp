<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.setAttribute("signCheck", false);

	response.sendRedirect("./signup_check");
%>