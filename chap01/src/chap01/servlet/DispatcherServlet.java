package chap01.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("DispatcherServlet-URL : " + req.getRequestURL());
		System.out.println("DispatcherServlet-Method : " + req.getMethod());
		
		super.service(req, resp);
	}
	
}
