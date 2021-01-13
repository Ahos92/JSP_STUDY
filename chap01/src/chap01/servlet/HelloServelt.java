package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 서블릿으로 접속하려면 어떤 주소로 접속해야하는지 설정하는 어노테이션
@WebServlet("/hello")
public class HelloServelt extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
							throws ServletException, IOException {
		// HttpServletRequest : 클라이언트(사용자)로 부터 전송된 요청 정보들이 담겨 있는 객체
		// HttpServletResponse : 받은 요청을 통해 알맞은 응답(페이지 or 데이터)을 생성해서 응답해야하는 응답 객체
		// req --처리--> = resp;
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		// 자바가 메인 / html이 보조
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>"
				+ "<meta charset='utf-8'>");
		out.print("<title>This is Title</title>");
		out.print("<style> div { background-color: red; color:white; width: 100px; height: 100px; margin: 5px;}</style>");
		out.print("</head>");
		out.print("<body>");
		for (int i = 0; i < 5; i++) {
			out.print("<div> 디브 텍스트 "+ i +"</div>");
		}
		out.print("</body>");
		out.print("</html>");
		
	}
	
}
