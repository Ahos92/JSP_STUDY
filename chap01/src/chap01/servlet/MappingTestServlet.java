package chap01.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml에서 등록할 Servlet은 @WebServlet을 적지 않는다. ( @WebServlet이 web.xml의 servlet태그를 대신해준다 )
public class MappingTestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("<html><h1>Mapping test...</h1></html>");
	}
	
}
