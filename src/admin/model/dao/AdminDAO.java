package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import member.model.dto.Member;
import util.DBManager;

public class AdminDAO {
	
	private static AdminDAO instance = new AdminDAO();;
	private AdminDAO() {}
	
	public static AdminDAO getInstance() {
		return instance;
	}
	
	// 가입 승인을 요청한 회원 목록 조회
	public ArrayList<Member> selectApprovalList() {
		// TODO Auto-generated method stub
		ArrayList<Member> list = new ArrayList<Member>();
		
		String sql = "SELECT * FROM member WHERE use='N'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				member.setId(rset.getString("id"));
				member.setPwd(rset.getString("pwd"));
				member.setName(rset.getString("name"));
				member.setPhone(rset.getString("phone"));
				member.setIndate(rset.getTimestamp("indate"));
				member.setUse(rset.getString("use"));
				member.setGrade(rset.getString("grade"));
				
				System.out.println(rset.getString("id"));
				list.add(member);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rset);
		}
		
		return list;
	}
	
	// 회원 가입 승인
	public void approvalMember(String chk) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE member set use='Y' WHERE id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chk);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
	
}
