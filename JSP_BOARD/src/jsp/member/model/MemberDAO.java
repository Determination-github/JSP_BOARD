package jsp.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jsp.common.util.DBConnection;

public class MemberDAO {
	
	private static MemberDAO instance;
	
	private MemberDAO() {
		
	}
	
	//싱글톤 패턴
	public static MemberDAO getInstance() {
		if(instance==null) {
			instance = new MemberDAO();
		} return instance;
	}
	
	public MemberBean inquireData(String id) {
		DBConnection dbConnection = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean member = null;
		
		try {
			dbConnection = DBConnection.getInstance();			
			StringBuffer sql = new StringBuffer(); //멀티쓰레드에서는 StringBuffer가 안전
			sql.append("SELECT * FROM JSP_MEMBER WHERE MEMBER_ID=?");
			
			conn = dbConnection.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberBean();
				member.setMemberID(rs.getString("MEMBER_ID"));
				member.setMemberPWD(rs.getString("MEMBER_PWD"));
				member.setMemberName(rs.getString("MEMBER_NAME"));
				member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				member.setMemberReg(rs.getDate("MEMBER_REG"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.freeConnection(conn, pstmt, rs); //연결 종료
		}
		return member;
	}
	
	
	public int loginCheck(String id, String pwd) {
		
		int result = 0;
		DBConnection dbConnection = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbPWD = "";
		
		try {
			dbConnection = DBConnection.getInstance();			
			StringBuffer sql = new StringBuffer(); //멀티쓰레드에서는 StringBuffer가 안전
			sql.append("SELECT MEMBER_PWD FROM JSP_MEMBER WHERE MEMBER_ID=?");
			
			conn = dbConnection.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//MEMBER_PWD 컬럼의 String값 get해오기
				dbPWD = rs.getString("MEMBER_PWD"); //dbPWD는 데이터베이스 비밀번호
				System.out.println(dbPWD);
				
				if(dbPWD.equals(pwd)) { //넘겨받은 비번과 데이터베이스 비번이 같다면?
					result = 1; //넘겨 받은 비밀번호가 DB의 비밀번호가 같으면 1 반환
				} else {
					result = 0; //넘겨 받은 비밀번호가 DB의 비밀번호와 다르면 0 반환
				}
			} else {
				result = -1; // 해당 아이디가 없는 경우 -1 반환
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.freeConnection(conn, pstmt, rs); //연결 종료
		}
		return result;
	}
	
	public void joinMember(MemberBean member) throws SQLException{
		int result = 0;
		DBConnection dbConnection = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			dbConnection = DBConnection.getInstance();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO JSP_MEMBER(MEMBER_ID, MEMBER_PWD, MEMBER_EMAIL, MEMBER_NAME) VALUES (?, ?, ?, ?)");
			
			conn = dbConnection.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getMemberID());
			pstmt.setString(2, member.getMemberPWD());
			pstmt.setString(3, member.getMemberEmail());
			pstmt.setString(4, member.getMemberName());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.freeConnection(conn, pstmt); //conn, pstmt 닫기
		}
	}
	
	public void updateMember(MemberBean member) throws SQLException{
		DBConnection dbConnection = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE JSP_MEMBER SET MEMBER_PWD=?, MEMBER_EMAIL=?, MEMBER_NAME=? WHERE MEMBER_ID=?");
			
			dbConnection = DBConnection.getInstance();
			conn = dbConnection.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getMemberPWD());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberID());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.freeConnection(conn, pstmt);
		}
	}
	
	public void deleteMember(String id) {
		DBConnection dbConnection = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM JSP_MEMBER WHERE MEMBER_ID=?");
			
			dbConnection = DBConnection.getInstance();
			conn = dbConnection.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
						
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.freeConnection(conn, pstmt);
		}
	}
	
}
