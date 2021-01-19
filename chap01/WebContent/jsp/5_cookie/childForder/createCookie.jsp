<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Cookie handmade = new Cookie("car", "sonata");
	
	// 팝업창 하루안보기
	Cookie noMoreToday = new Cookie("nmt", "1");
	// 자동완성 기능
	Cookie autoComplete = new Cookie("ac", "1");
	
	// Path를 이용해 쿠키가 보이는 범위를 설정할 수 있다.
	handmade.setPath("/chap01/jsp/5_cookie/");
	noMoreToday.setPath("/chap01");
	autoComplete.setPath("/chap01");
	
	// setMaxAge를 이용해 쿠키의 만료시기를 설정할 수 있다. (기본값 : -1)
	noMoreToday.setMaxAge(60 * 60 * 24); //60초 x60 x24 => 하루
	autoComplete.setMaxAge(-1); // 브라우저를 끄면 쿠키가 함께 삭제된다. 정보창에 Session으로 표기됨
	
	// 쿠키는 사용자의 웹 브라우저에 저장된다.
	//  서버에서는 response에 쿠키를 실어 보내면 된다.
	String[] messages = {"새콤달콤", "마이쮸", "홀스", "아이셔", "말랑카우"};
	
	response.addCookie(new Cookie("candy", messages[(int)(Math.random() * messages.length)]));
	response.addCookie(handmade);
	response.addCookie(noMoreToday);
	response.addCookie(autoComplete);
	
	response.sendRedirect("../index.jsp");
%>