package admin.model.service;

import java.util.ArrayList;

import member.model.dto.Member;

public interface AdminService {

	// 가입 요청이 온 회원들을 조회합니다.
	ArrayList<Member> approvalList();
	
	// 가입 요청 승인
	void approvalMember(String chk);
	
	// 가입 요청 거절
	void rejectMember(String chk);
	
	// 가입 승인된 회원 리스트 조회
	ArrayList<Member> MemberList();
	
}
