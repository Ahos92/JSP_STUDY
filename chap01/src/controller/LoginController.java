package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {

	@Override
	public String control(HttpServletRequest req, HttpServletResponse resp) {
		return "/WEB-INF/jsp/7_jdbc/loginpage.jsp";
	}
}
