package chap01.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test/controltest")
public class ControllerTestServlet extends HttpServlet {
	
	int page_num;
	RequestDispatcher dispatcher;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		dispatcher = request.getRequestDispatcher("/jsp/2_dispatch/select_page.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		try {
			page_num = Integer.parseInt(request.getParameter("page"));			
		} catch (NumberFormatException nfe) {
			page_num = 0;
		}

		dispatcher = request.getRequestDispatcher("/jsp/2_dispatch/view/page"+ page_num +".jsp");
		
		dispatcher.forward(request, response);	
	}

}
