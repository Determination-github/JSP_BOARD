package jsp.member.model.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
}
