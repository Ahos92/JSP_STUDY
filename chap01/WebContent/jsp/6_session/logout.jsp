<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("login"); // 해당 어트리뷰트만 삭제시키기
	// session.invalidate(); // 세션 만료 시키기
	
	response.sendRedirect("./index.jsp");
%>