package member.model.service;

import member.model.dao.MemberDAO;

public class MemberServiceImpl implements MemberService {

	MemberDAO mDAO = MemberDAO.getInstance();

	@Override
	public void singUp(Member member) {
		// TODO Auto-generated method stub
		mDAO.insertMember(member);
	}
	
}
