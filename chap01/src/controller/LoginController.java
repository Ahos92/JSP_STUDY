package controller;

import java.math.BigInteger;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HikariMemberDAO;
import dao.MemberDAO;
import domain.MemberVO;
import util.hash.MemberPassword;
import util.hash.MemberPasswordImpl;

public class LoginController implements Controller {

	private MemberVO member = new MemberVO();
	private MemberDAO dao = new HikariMemberDAO();
	private MemberPassword hash = MemberPasswordImpl.getInstance();
	
	//로그인 Form
	private String doGet(HttpServletRequest req, HttpServletResponse resp) {
		return "/WEB-INF/jsp/7_jdbc/login/loginpage.jsp";
	}
	
	// 로그인 체크
	private String doPost(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String id = req.getParameter("user_id");
		String pwd = req.getParameter("user_password");

		if(id == null || id == "" || pwd == null || pwd =="") {
			return "/WEB-INF/jsp/7_jdbc/login/loginfail.jsp";
		}
		
		// 로그인 체크 searchMember
		member = dao.get(id);
		
		// salt 값 바이트 배열로 바꾸기 (HexString -> Byte[]) 수동
		String salt = member.getUser_salt();
		byte[] salt_arr = new byte[salt.length() / 2];
		
		for (int i = 0; i < salt_arr.length; i++) {
			   int index = i * 2;
			   int j = Integer.parseInt(salt.substring(index, index + 2), 16);
			   salt_arr[i] = (byte) j;
		}
		
		String user_hash = member.getUser_password();
		String confirm_hash = hash.digestPassword(pwd, salt_arr);
	
		if (user_hash.equals(confirm_hash)) {
			session.setAttribute("user_name", member.getUser_name());
			return "/WEB-INF/jsp/7_jdbc/login/loginsuccess.jsp";
			
		} else {
			return "/WEB-INF/jsp/7_jdbc/login/loginfail.jsp";
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
