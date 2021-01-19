package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeContentCotroller implements Controller {

	int num;
	
	public HomeContentCotroller(int num) {
		this.num = num;
	}
	
	@Override
	public String control(HttpServletRequest req, HttpServletResponse resp) {
		return "/WEB-INF/jsp/7_jdbc/homeContent" + num + ".jsp";
	}
}
