package chap01.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 어떤 방식의 요청인지 판별하기 전
		System.out.println("Seivce가 호출됨.");
		System.out.println("init-param 정보들 >");
		System.out.println(getInitParameter("myName"));
		System.out.println(getInitParameter("myTel"));
		System.out.println(getInitParameter("username"));
		System.out.println(getInitParameter("password"));
		System.out.println(getInitParameter("jdbcurl"));
		
		// super.service(req, resp) : req를 통해 어떤 방식인지 판별하고 doMethod()를 호출한다.
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet이 호출됨!");
	}
}
