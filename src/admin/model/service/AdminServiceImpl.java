package admin.model.service;

import java.util.ArrayList;

import admin.model.dao.AdminDAO;
import member.model.dto.Member;

public class AdminServiceImpl implements AdminService{
	
	private AdminDAO aDAO = AdminDAO.getInstance();
	
	@Override
	public ArrayList<Member> approvalList() {
		// TODO Auto-generated method stub
		return aDAO.selectApprovalList();
		
	}
	
	
	
}
