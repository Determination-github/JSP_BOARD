package jsp.common.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	//물리적으로 떨어져 있는 오라클 서버에 연결통로를 확보
	Connection con = null;
	//자바코드에서 작성한 select문을 전달함
	Statement  stmt = null;
	//프로시저를 전담하는 인터페이스 선언
	CallableStatement cstmt = null;
	//오라클에게 전달된 select문을 처리한 결과를 꺼내기 위해서 커서를 조작해야 하는데
	//그 때 커서를 이동하는데 필요한 메소드를 선언한 인터페이스
	ResultSet  rs   = null;
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";//ojdbc6.jar  의존관계, 의존성 주입 제조사
	//서버측 아이피, 서버측 포트번호, 오라클 SID
	public static final String _URL    = "jdbc:oracle:thin:@127.0.0.1:1522:orcl";
	public static final String _USER   = "scott";
	public static final String _PW     = "tiger";
	private static DBConnection dbMgr = null;
	
	//싱글톤 패턴
	private DBConnection() {}
	public static DBConnection getInstance() {
		if(dbMgr == null) {
			dbMgr = new DBConnection();
		}
		return dbMgr;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (Exception e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			System.out.println(e.toString());
		}
		return con;
	}
/*
 * 사용한 자원 반납하기 
 * 생성된 역순으로 반납
 */
	
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {//select일때
		try {
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//PreparedStatement 동적쿼리에서 사용(권장사항) SELECT * FROM member WHERE id=?
	public void freeConnection(Connection con, PreparedStatement pstmt) {//INSERT|UPDATE|DELETE
		try {
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//CallableStatement 프로시저에 사용
	public void freeConnection(Connection con, CallableStatement cstmt) {//INSERT|UPDATE|DELETE
		try {
			if(cstmt !=null) cstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Statement 정적쿼리 처리에 사용
	public void freeConnection(Connection con, Statement stmt) {//INSERT|UPDATE|DELETE
		try {
			if(stmt !=null) stmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
