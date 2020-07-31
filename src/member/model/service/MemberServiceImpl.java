package member.model.service;

import member.model.dao.MemberDAO;
import member.model.dto.Member;

public class MemberServiceImpl implements MemberService {

	MemberDAO mDAO = MemberDAO.getInstance();

	@Override
	public void singUp(Member member) {
		// TODO Auto-generated method stub
		mDAO.insertMember(member);	// 데이터베이스에 회원 삽입
	}

	@Override
	public boolean idDuplicateChk(String id) {
		// TODO Auto-generated method stub
		return mDAO.selectID(id);		// 존재하는 회원인지 검색
	}

	@Override
	public Member signIn(String id) {
		// TODO Auto-generated method stub
		return mDAO.selectMember(id);
	}
	
}
