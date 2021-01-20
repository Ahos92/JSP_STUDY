package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.MemberVO;
import myutil.DBManager;

// 인터페이스를 만들어 놓고 DAO를 구현하면 좋은점
//	- 나중에 DAO를 다른소스로 바꾸더라도 이 인터페이스를 가져다 쓴곳은 수정하지 않아도 된다. ( 느슨한 결합 )

public class HikariMemberDAO implements MemberDAO {
	
	static Connection conn;
	static PreparedStatement ps, ps2, ps3;
	static ResultSet rs;

	MemberVO member;
	
	public HikariMemberDAO() {}
	
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
				member.setUser_salt(rs.getString("user_salt"));
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

	public boolean saveMember(MemberVO member2) {
		conn = DBManager.getConnection();
		
		try {
			String sql = "insert into logintest "
					+ "values(?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member2.getUser_id());
			ps.setString(2, member2.getUser_password()); 
			ps.setString(3, member2.getUser_name()); 
			ps.setInt(4, member2.getUser_age()); 
			ps.setString(5, member2.getUser_salt());
		
			ps.addBatch();
			
			int[] rows = ps.executeBatch();
			
			if (rows.length <= 0) {
				return false;
			} else {
				System.out.println("logintest 테이블의 " + rows.length + "행이 변경되었습니다.");
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.r_p_c_Close(rs, ps, conn);
			} catch (SQLException e) {}
		}		
		return false;
	}
		
}
	

