package controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HikariMemberDAO;
import dao.MemberDAO;
import domain.MemberVO;
import util.hash.MemberPassword;
import util.hash.MemberPasswordImpl;

public class SignupController implements Controller{

	private MemberVO member = new MemberVO();
	private MemberDAO dao = new HikariMemberDAO();
	private MemberPassword hash = MemberPasswordImpl.getInstance();

	// 회원가입 Form
	private String doGet(HttpServletRequest req, HttpServletResponse resp) {
		return "/WEB-INF/jsp/7_jdbc/member/signup.jsp";
	}
	
	
	private String doPost(HttpServletRequest req, HttpServletResponse resp) {	
		byte[] salt = hash.getSalt();
		String pwd = hash.digestPassword(req.getParameter("user_password"), salt);
		
		try {
			member.setUser_id(req.getParameter("user_id"));
			member.setUser_password(pwd);
			member.setUser_name(req.getParameter("user_name"));
			member.setUser_age(Integer.parseInt(req.getParameter("user_age")));
			member.setUser_salt(String.format("%032X", new BigInteger(1, salt)));
			
		} catch (Exception e) {
			return "/WEB-INF/jsp/7_jdbc/member/signfail.jsp";
		}
		
		boolean result = dao.saveMember(member);
		
		return result ? "/WEB-INF/jsp/7_jdbc/member/signsuccess.jsp" 
						: "/WEB-INF/jsp/7_jdbc/member/signfail.jsp";

	}
	
	@Override
	public String control(HttpServletRequest req, HttpServletResponse resp) {
		
		switch (req.getMethod()) {
		case "GET":
			return doGet(req, resp);
			
		case "POST":
			return doPost(req, resp);
			
		}

		return "redirect:" + req.getContextPath() + "/home";
	}
}
