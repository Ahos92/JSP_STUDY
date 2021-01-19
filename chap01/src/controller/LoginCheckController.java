package controller;

import java.sql.SQLSyntaxErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import myutil.CaesarCipher;
import myutil.MemberDAO;
import myutil.MemberVO;

public class LoginCheckController implements Controller {

	@Override
	public String control(HttpServletRequest req, HttpServletResponse resp) {	
		String id = req.getParameter("user_id");
		String pwd = req.getParameter("user_password");
		
		MemberVO member = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		member = dao.searchMember(id); // try catch
	
		HttpSession session = req.getSession();
		
		String confirm_pwd;
		try {
			confirm_pwd = new CaesarCipher(100).decryption(member.getUser_password());
			
		} catch(NullPointerException npe) {
			return "/WEB-INF/jsp/7_jdbc/loginfail.jsp";
		}
		// MessageDigest 적용해보기
		
//		System.out.println("넘겨받은 아이디 : " + id + " 저장된 아이디 : " + member.getUser_id());
//		System.out.println("넘겨받은 패스워드 : " + pwd + " 저장된 패스워드(복호화) : " + confirm_pwd);
		
		if (pwd.equals(confirm_pwd)) {
			session.setAttribute("user_name", member.getUser_name());
			return "/WEB-INF/jsp/7_jdbc/loginsuccess.jsp";
			
		} else {
			return "/WEB-INF/jsp/7_jdbc/loginfail.jsp";
		}
	}

}
