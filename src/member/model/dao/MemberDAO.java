package member.model.dao;

import member.model.dto.Member;

public class MemberDAO {
	
	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public void insertMember(Member member) {
		
	}
	
}
