package admin.model.service;

import java.util.ArrayList;

import admin.model.dao.AdminDAO;
import member.model.dto.Member;

public class AdminServiceImpl implements AdminService {
	
	private AdminDAO aDAO = AdminDAO.getInstance();
	
	@Override
	public ArrayList<Member> approvalList() {
		// TODO Auto-generated method stub
		return aDAO.selectApprovalList();	// 가입요청한 회원들
		
	}

	@Override
	public void approvalMember(String chk) {
		// TODO Auto-generated method stub
		aDAO.approvalMember(chk);			// 가입 승인
	}

	@Override
	public void rejectMember(String chk) {
		// TODO Auto-generated method stub
		aDAO.rejectMember(chk);				// 가입 거절
	}

	@Override
	public ArrayList<Member> MemberList() {
		// TODO Auto-generated method stub
		return aDAO.selectMemberList();		// 가입승인된 회원 목록
	}

	@Override
	public void modifyGrade(String grade, String id) {
		// TODO Auto-generated method stub
		aDAO.updateGrade(grade, id);
	}
	
	
	
}
