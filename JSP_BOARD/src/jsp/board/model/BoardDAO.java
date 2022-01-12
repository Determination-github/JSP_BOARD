package jsp.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import jsp.common.util.DBConnection;

public class BoardDAO {
	private static BoardDAO instance;
	
	private BoardDAO() {
		
	}
	
	//싱글톤 패턴
	public static BoardDAO getInstance() {
		if(instance==null) {
			instance = new BoardDAO();
		} return instance;
	}
	
	public int getSeq() {
		DBConnection dbConnection = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 1;
		
		try {
			dbConnection = DBConnection.getInstance();
			StringBuffer sql = new StringBuffer(); //멀티쓰레드에서는 StringBuffer가 안전
			sql.append("SELECT BOARD_NUM.NEXTVAL FROM DUAL");
			
			conn = dbConnection.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.freeConnection(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public boolean boardInsert(BoardBean board) {
		
		DBConnection dbConnection = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean result = false;
		
		try {
			dbConnection = DBConnection.getInstance();
			conn = dbConnection.getConnection();
			
			StringBuffer sql = new StringBuffer(); //멀티쓰레드에서는 StringBuffer가 안전
			sql.append("INSERT INTO BOARD");
			sql.append("(BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_COUNT)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?)");
			
			int num = board.getBoardNum();
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getBoardID());
			pstmt.setString(3, board.getBoardSubject());
			pstmt.setString(4, board.getBoardContent());
			pstmt.setString(5, board.getBoardFile());
			pstmt.setInt(6, board.getBoardCount());
			
			int updateCount = pstmt.executeUpdate();
			if(updateCount > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.freeConnection(conn, pstmt);
			return result;
		}
	}
	
	public ArrayList<BoardBean> getBoardList(HashMap<String, Object> list) {
		DBConnection dbConnection = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardBean> arrayList = new ArrayList<BoardBean>();
		
		String option = (String)list.get("option");
		String condition = (String)list.get("condition");
		int start = (Integer)list.get("start");
		
		try {
			dbConnection = DBConnection.getInstance();
			conn = dbConnection.getConnection();
			StringBuffer sql = new StringBuffer(); //멀티쓰레드에서는 StringBuffer가 안전
			
			if(option == null) {
				sql.append("SELECT * FROM ");
				sql.append("( SELECT ROWNUM rNUM, N.* FROM ");
				sql.append("( SELECT * FROM BOARD ORDER BY BOARD_NUM DESC) N) ");
				sql.append("WHERE rNUM BETWEEN ? AND ?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, start+9);
				
				//StringBuffer 비우기
				sql.delete(0, sql.toString().length());
			}
			else if(option.equals("0")) { //제목 검색
				sql.append("SELECT * FROM ");
				sql.append("( SELECT ROWNUM rNUM, N.* FROM ");
				sql.append("( SELECT * FROM BOARD WHERE BOARD_SUBJECT LIKE ? ORDER BY BOARD_NUM DESC) N) ");
				sql.append(" WHERE rNUM BETWEEN ? AND ?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				
				sql.delete(0, sql.toString().length());
			}	
			else if(option.equals("1")) { //내용 검색
				sql.append("SELECT * FROM ");
				sql.append("( SELECT ROWNUM rNUM, N.* FROM ");
				sql.append("( SELECT * FROM BOARD WHERE BOARD_CONTENT LIKE ? ORDER BY BOARD_NUM DESC) N) ");
				sql.append(" WHERE rNUM BETWEEN ? AND ?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				
				sql.delete(0, sql.toString().length());
			}	
			else if(option.equals("2")) { //제목+내용 검색
				sql.append("SELECT * FROM ");
				sql.append("( SELECT ROWNUM rNUM, N.* FROM ");
				sql.append("( SELECT * FROM BOARD WHERE BOARD_SUBJECT LIKE ? OR BOARD_CONTENT LIKE ?");
				sql.append(" ORDER BY BOARD_NUM DESC) N) ");
				sql.append(" WHERE rNUM BETWEEN ? AND ?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, start+9);
				
				sql.delete(0, sql.toString().length());
			}	
			else if(option.equals("3")) { //아이디 검색
				sql.append("SELECT * FROM ");
				sql.append("( SELECT ROWNUM rNUM, N.* FROM ");
				sql.append("( SELECT * FROM BOARD WHERE BOARD_ID LIKE ?");
				sql.append(" ORDER BY BOARD_NUM DESC) N) ");
				sql.append(" WHERE rNUM BETWEEN ? AND ?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				
				sql.delete(0, sql.toString().length());
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardBean board = new BoardBean();
				board.setBoardNum(rs.getInt("BOARD_NUM"));
				board.setBoardID(rs.getString("BOARD_ID"));
				board.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setBoardFile(rs.getString("BOARD_FILE"));
				board.setBoardCount(rs.getInt("BOARD_COUNT"));
				board.setBoardDate(rs.getDate("BOARD_DATE"));
				
				arrayList.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.freeConnection(conn, pstmt, rs);
		}
		
		return arrayList;
	}
	
	public int getBoardListCount(HashMap<String, Object> list) {
		DBConnection dbConnection = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		String option = (String)list.get("option");
		String condition = (String)list.get("condition");
		
		try {
			dbConnection = DBConnection.getInstance();
			conn = dbConnection.getConnection();
			StringBuffer sql = new StringBuffer(); //멀티쓰레드에서는 StringBuffer가 안전
			
			if(option == null) { //전체 글의 개수
				sql.append("SELECT COUNT(*) FROM BOARD");
				pstmt = conn.prepareStatement(sql.toString());
				
				sql.delete(0, sql.toString().length());
			} else if(option.equals("0")) { //제목으로 검색한 글의 개수
				sql.append("SELECT COUNT(*) FROM BOARD WHERE BOARD_SUBJECT LIKE ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				
				sql.delete(0, sql.toString().length());
			} else if(option.equals("1")) { //내용으로 검색한 글의 개수
				sql.append("SELECT COUNT(*) FROM BOARD WHERE BOARD_CONTENT LIKE ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				
				sql.delete(0, sql.toString().length());
			} else if(option.equals("2")) { //제목+내용으로 검색한 글의 개수
				sql.append("SELECT COUNT(*) FROM BOARD WHERE BOARD_SUBJECT LIKE ? OR BOARD_CONTENT LIKE ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				
				sql.delete(0, sql.toString().length());
			} else if(option.equals("3")) { //아이디로 검색한 글의 개수
				sql.append("SELECT COUNT(*) FROM BOARD WHERE BOARD_ID LIKE ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				
				sql.delete(0, sql.toString().length());
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnection.freeConnection(conn, pstmt, rs);
		}
		
		return result;
	}
}
