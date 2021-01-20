package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeContentCotroller implements Controller {

	@Override
	public String control(HttpServletRequest req, HttpServletResponse resp) {
		String path = req.getRequestURI().substring(req.getContextPath().length());	
		return "/WEB-INF/jsp/7_jdbc" + path + ".jsp";
	}
}
