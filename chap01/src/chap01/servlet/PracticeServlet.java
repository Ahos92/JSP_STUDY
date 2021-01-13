package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice")
public class PracticeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");

		PrintWriter out = resp.getWriter();
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String edu = request.getParameter("edu");
		String[] hobby = request.getParameterValues("hobby");
		
		out.print("<html>");
		out.print("<head><meta charset='utf-8'></head><body>");
		out.print("<p>.jsp -> servlet 요청</p>");
		out.print("<b>이름 :</b> " + name + "<br>" );
		out.print("<b>성별 :</b> " + gender + "<br>" );
		out.print("<b>주소 :</b> " + address + "<br>" );
		out.print("<b>학력 :</b> " + edu + "<br>" );
		out.print("<b>취미 :</b> " + Arrays.toString(hobby) + "<br>" );
		out.print("</body></html>");
	}
}
