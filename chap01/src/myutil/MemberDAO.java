package myutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	
	static Connection conn;
	static PreparedStatement ps, ps2, ps3;
	static ResultSet rs;

	MemberVO member;
	
	public MemberDAO() {}
	
	public MemberVO searchMember(String user_id) {

		member = new MemberVO();

		conn = DBManager.getConnection();
		try {
			ps = conn.prepareStatement("select * from logintest where user_id = \'" + user_id + "\'");
			rs = ps.executeQuery();

			while (rs.next()) {
				member = new MemberVO();

				member.setUser_id(rs.getString("user_id"));
				member.setUser_password(rs.getString("user_password"));
				member.setUser_name(rs.getString("user_name"));
				member.setUser_age(rs.getInt("user_age"));

			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.r_p_c_Close(rs, ps, conn);
			} catch (SQLException e) {}

		}

		return member;
	}
	
}
