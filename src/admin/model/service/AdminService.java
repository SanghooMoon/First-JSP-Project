package admin.model.service;

import java.util.ArrayList;

import member.model.dto.Member;

public interface AdminService {

	// 가입 요청이 온 회원들을 조회합니다.
	ArrayList<Member> approvalList();
	
}
