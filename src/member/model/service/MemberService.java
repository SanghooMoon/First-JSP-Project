package member.model.service;

import member.model.dto.Member;

public interface MemberService {

	public void singUp(Member member);	// 최종 회원가입

	public boolean idDuplicateChk(String id);	// 아이디 중복확인
	
	public Member signIn(String id);	// 로그인
}
