package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.model.dto.Member;
import util.DBManager;

public class MemberDAO {
	
	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 데이터베이스에 회원을 추가하는 메서드
	public void insertMember(Member member) {
		
		String sql = "INSERT INTO member VALUES(?, ?, ?, ?, SYSDATE, 'Y')";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 데이터베이스에서 존재하는 id인지 판별하는 메서드(중복확인용)
	public boolean selectID(String id) {
		
		boolean hasId = false;	// 존재하는 아이디인지, 기본값 false : 존재하지 않다.(사용가능)
		
		String sql = "SELECT * FROM member WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			// 존재하는 아이디라면
			if(rset.next()) {
				hasId = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rset);
		}
		
		return hasId;
	}
	
	
	// 회원을 조회하는 메서드(로그인시 사용)
	public Member selectMember(String id) {
		// TODO Auto-generated method stub
		
		String sql = "select * from member where id=?";
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;

		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			// 존재하는 아이디라면
			if(rset.next()) {
				member = new Member();
				member.setId(rset.getString("id"));
				member.setPwd(rset.getString("pwd"));
				member.setName(rset.getString("name"));
				member.setPhone(rset.getString("phone"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rset);
		}
		
		return member;
	}

	
}
