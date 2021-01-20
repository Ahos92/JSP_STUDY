package controller;

import java.math.BigInteger;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HikariMemberDAO;
import dao.MemberDAO;
import domain.MemberVO;
import myutil.Hash;

public class LoginController implements Controller {

	private String doGet(HttpServletRequest req, HttpServletResponse resp) {
		// 로그인 Form
		return "/WEB-INF/jsp/7_jdbc/loginpage.jsp";
	}
	
	private String doPost(HttpServletRequest req, HttpServletResponse resp) {
		// 로그인 체크
		MemberVO member = new MemberVO();
		MemberDAO dao = new HikariMemberDAO();
		HttpSession session = req.getSession();
		Hash hash = new Hash();
		
		String id = req.getParameter("user_id");
		String pwd = req.getParameter("user_password");

		member = dao.searchMember(id);
		
		String confirm_pwd;
		try {
			// 문제
			confirm_pwd = hash.setSHA256(pwd, member.getUser_salt().getBytes());

//			System.out.println("user pwd -> hash : " + confirm_pwd);
//			System.out.println("DB saved pwd : " + member.getUser_password());
			
			if (member.getUser_password().equals(confirm_pwd)) {
				session.setAttribute("user_name", member.getUser_name());
				return "/WEB-INF/jsp/7_jdbc/loginsuccess.jsp";
				
			} else {
				return "/WEB-INF/jsp/7_jdbc/loginfail.jsp";
			}
			
		} catch(NullPointerException npe) {
			return "/WEB-INF/jsp/7_jdbc/loginfail.jsp";
		}
	}

	
	@Override
	public String control(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getMethod()) {
		case "GET":
			return doGet(req, resp);
			
		case "POST":
			return doPost(req, resp);
		}
		
		return "redirect:" + req.getContextPath() + "/home";
	}

}
