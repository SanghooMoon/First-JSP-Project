package admin.model.service;

import java.util.ArrayList;

import admin.model.dao.AdminDAO;
import member.model.dto.Member;

public class AdminServiceImpl implements AdminService {
	
	private AdminDAO aDAO = AdminDAO.getInstance();
	
	@Override
	public ArrayList<Member> approvalList() {
		// TODO Auto-generated method stub
		return aDAO.selectApprovalList();
		
	}

	@Override
	public void approvalMember(String chk) {
		// TODO Auto-generated method stub
		aDAO.approvalMember(chk);
	}

	@Override
	public void rejectMember(String chk) {
		// TODO Auto-generated method stub
		aDAO.rejectMember(chk);
	}
	
	
	
}
