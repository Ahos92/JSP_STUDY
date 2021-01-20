package controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HikariMemberDAO;
import dao.MemberDAO;
import domain.MemberVO;
import myutil.Hash;

public class SignupController implements Controller{

	private String doGet(HttpServletRequest req, HttpServletResponse resp) {
		// 회원가입 Form을 보여줌
		return "/WEB-INF/jsp/7_jdbc/signup.jsp";
	}
	
	private String doPost(HttpServletRequest req, HttpServletResponse resp) {
		Hash hash = new Hash(); 
		int SALT_SIZE = 16;
		byte[] salt = new byte[SALT_SIZE];

//		hash.setSHA256(req.getParameter("user_password"), salt);
		
		// 회원가입 체크
		MemberVO member = new MemberVO();
		MemberDAO dao = new HikariMemberDAO();
		
		try {
			member.setUser_id(req.getParameter("user_id"));
			member.setUser_password(hash.setSHA256(req.getParameter("user_password"), salt));
			member.setUser_name(req.getParameter("user_name"));
			member.setUser_age(Integer.parseInt(req.getParameter("user_age")));
			member.setUser_salt(String.format("%032x", new BigInteger(1, salt)));
			
		} catch (Exception e) {
			return "/WEB-INF/jsp/7_jdbc/signfail.jsp";
		}
		
		if (dao.saveMember(member)) {
			return "/WEB-INF/jsp/7_jdbc/signsuccess.jsp";
			
		} else {
			return "/WEB-INF/jsp/7_jdbc/signfail.jsp";
			
		}

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
