package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeCotroller implements Controller{

	@Override
	public String control(HttpServletRequest req, HttpServletResponse resp) {
		return "/WEB-INF/jsp/7_jdbc/home.jsp";
	}
	
}
