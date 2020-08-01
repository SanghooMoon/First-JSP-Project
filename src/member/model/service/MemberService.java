package member.model.service;

import member.model.dto.Member;

public interface MemberService {

	void singUp(Member member);	// 최종 회원가입

	boolean idDuplicateChk(String id);	// 아이디 중복확인
	
	Member signIn(String id);	// 로그인
}
