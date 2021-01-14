package chap01.servlet;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		urlPatterns = { "/attribute" }
)
public class AttributeTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 3.
		// ServletContext 서버당 한개인 객체 .jsp페이지에서는 application 내장객체로 생성되어있다.
		ServletContext application = getServletContext();
		application.setAttribute("message", "서버가 꺼지기 전까지 유지되는 메세지");
		application.setAttribute("id", "user_id");
		
		// 2.
		// Session : 사용자의 브라우저에 저장된 세션값이 있으면 그 세션값을 이용해 세션 객체를 꺼내준다.
		HttpSession session = req.getSession();
		// ex: 로그인 입력값이 서블릿으로 들어옴 -> 서블릿에서 DB조회로 회원 여부 -> true/false로 세션에 저장
		// 다른 Attribute도 비슷한 흐름
		session.setAttribute("login", true);
		session.setAttribute("no_more_today", false);
		
		// 1.
		// Attribute에 데이터를 실어보내면 forward 대상 페이지에서도 실려있는 데이터를 확인할 수 있다.
		// 보통, Servlet에서 미리 처리를 다한 데이터를 실어놓기만 하고 JSP페이지에서는 꺼내쓰기만 하는것이 좋다.
		// Parameter에는 String만 실려 올 수 있었던 것과는다르게, Attribute에는 모든 자바 객체를 실어놓고 JSP페이지로 전달할 수 있다.
		req.setAttribute("key", "value");
		req.setAttribute("favcolor", Color.RED);
		req.setAttribute("emplist", new String[] {"Smith", "King", "Alen"});
		
//		req.getRequestDispatcher("/jsp/3_attribute/index.jsp").forward(req, resp);
		resp.sendRedirect("/chap01/jsp/3_attribute/index.jsp");
	}
}
