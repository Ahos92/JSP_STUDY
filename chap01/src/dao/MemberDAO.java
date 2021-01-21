package dao;

import domain.MemberVO;

public interface MemberDAO {

	public MemberVO get(String user_id);
	
	public boolean saveMember(MemberVO member);
	
}
