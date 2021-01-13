package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class SubmitServlet extends HttpServlet {

	/*
	 	Get방식의 요청은 서블릿의 doGet()
	 	Post방식의 요청은 서블릿의 doPost()
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트에서 form을 통해 실려온 데이터는 req객체의 parameter라는 곳에 포함되어 있다.
		
		// (1) 파라미터를 Enumeration객체로 꺼내기
		
		// 모든 이름을 반복 돌리기 편한 형태로 담아놓은 객체를 꺼낸다
		Enumeration<String> names = req.getParameterNames();
		
		// Writer를 꺼내기전에 인코딩 타입을 설정해 두어야 한다.
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head><meta charset='utf-8'</head><body>");
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = req.getParameter(name);
			
			out.print("<b>" + name + ":</b> " + value + "<br>" );
		}
		out.print("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		// (2) 그냥 꺼내기
		//	- 여러개의 값(체크박스)을 꺼낼 때에는 getparameterValues()를 이용한다.
		System.out.println("이름 : " + req.getParameter("customer_name"));
		System.out.println("피자 : " + req.getParameter("topping"));
		System.out.print("사이드 : ");
		for (String extra : req.getParameterValues("side")) {
			System.out.print(extra + " ");
		}
		System.out.println();
		
		System.out.println("요구 : " + req.getParameter("cs"));
		
		// (3) 맵으로 꺼내기
		//	- 기본적으로 value쪽이 String[]로 설정되어 있다.
		Map<String, String[]> params = req.getParameterMap();
		System.out.println("Map으로 꺼낸 배열[0] : " + params.get("customer_name")[0]);
	}
	
}
