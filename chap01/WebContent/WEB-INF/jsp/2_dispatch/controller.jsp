<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setCharacterEncoding("UTF-8");

	// request.getParameter()는 뭔가 잘못된 경우에 null이 반환된다.
	int page_num;
	try {
		page_num =Integer.parseInt(request.getParameter("page"));
	} catch (Exception e) {
		page_num = 0;
	}
	
	System.out.println("name : " + request.getParameter("name"));
	System.out.println("character : " + request.getParameter("character"));
	System.out.println("age : " + request.getParameter("age"));
	System.out.println("page number : " + page_num);
	
	// Controller : 사용자의 요청이 도착하면 어떤일을 할 지 결정하는 것
	// View : 사용자에게 이쁜 화면을 보여주기 위한 모든 소스들
	
	// ※ 컨트롤러와 뷰는 다른 파일로 분할하는 것이 유지보수 하기에 좋다.

	
	/*
		RequestDispatcher : 다른 페이지의 실행 결과를 응답 하거나 포함시키는 기능을 가지는 클래스
	*/
	// 가고 싶은 주소의 dispatcher 인스턴스를 생성
	RequestDispatcher dispatcher =
			request.getRequestDispatcher("view/page"+ page_num +".jsp");
	
	// # forward() : 컨트롤러에서 포워딩된 페이지의 결과를 응답 한다. 클라이언트의 브라우저에는 주소값이 바뀌지 않는다.
	dispatcher.forward(request, response);
	
	// # include() : 다른 페이지의 결과를 현재 페이지로 가져와서 포함시킨다.
	// dispatcher.include(request, response);
	
	
	
	/*
		리다이렉트 : 클라이언트에게 다른 페이지로 다시 요청을 보낼것을 명령한다. (데이터가 소멸)
	*/
	// response.sendRedirect("./view/page" + page_num + ".jsp");
%>

<h3>controller.jsp</h3>