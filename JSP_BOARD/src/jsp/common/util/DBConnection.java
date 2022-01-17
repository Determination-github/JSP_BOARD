package jsp.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	//물리적으로 떨어져 있는 오라클 서버에 연결통로를 확보
	Connection conn = null;
	//자바코드에서 작성한 select문을 전달함
	Statement  stmt = null;
	//오라클에게 전달된 select문을 처리한 결과를 꺼내기 위해서 커서를 조작해야 하는데
	//그 때 커서를 이동하는데 필요한 메소드를 선언한 인터페이스
	ResultSet  rs   = null;
	public static final String _DRIVER = "oracle.jdbc.OracleDriver";//ojdbc8.jar  의존관계, 의존성 주입 제조사
	//서버측 아이피, 서버측 포트번호, 오라클 SID
	public static final String _URL    = "jdbc:oracle:thin:@127.0.0.1:1522:ORCL";
	public static final String _USER   = "jsp_board";
	public static final String _PW     = "1234";
	private static DBConnection db= null;
	
	//싱글톤 패턴
	private DBConnection() {}
	public static DBConnection getInstance() {
		if(db == null) {
			db = new DBConnection();
		}
		return db;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(_DRIVER);
			conn = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (Exception e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			System.out.println(e.toString());
		}
		return conn;
	}
/*
 * 사용한 자원 반납하기 
 * 생성된 역순으로 반납
 */
	
	public void freeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) {//select일때
		try {
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//PreparedStatement 동적쿼리에서 사용(권장사항) SELECT * FROM member WHERE id=?
	public void freeConnection(Connection conn, PreparedStatement pstmt) {//INSERT|UPDATE|DELETE
		try {
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
