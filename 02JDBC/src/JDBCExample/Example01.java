package JDBCExample;

import java.sql.*;

public class Example01 {
	
	
			
	public static void main(String args[]) throws Exception{
		
		Connection con= null;
		Statement stmt = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1. 드라이버 연결 OK");
		
		con = DriverManager.getConnection(url, "scott","tiger");
		System.out.println("2.connection 인스턴스 생성 OK");
		
		stmt=con.createStatement();
		System.out.println("3. statement객체 생성 OK");
		
		String createSql=
				"Create TABLE member"
				+"(no NUMBER,"
				+ "id VARCHAR2(10),"
				+ "pwd VARCHAR2(10) )";
		
		System.out.println("쿼리 전송결과:"+stmt.executeUpdate(createSql));
		System.out.println("4.쿼리 전송 완료");
			
		if(stmt != null)	stmt.close();
		if( con != null)	con.close();
	}
	

}
