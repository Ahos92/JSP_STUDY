package dao;

import domain.MemberVO;

public interface MemberDAO {

	public MemberVO searchMember(String user_id);
	
	public boolean saveMember(MemberVO member);
	
}
