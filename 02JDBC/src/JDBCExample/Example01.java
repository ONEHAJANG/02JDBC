package JDBCExample;

import java.sql.*;

public class Example01 {
	
	
			
	public static void main(String args[]) throws Exception{
		
		Connection con= null;
		Statement stmt = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1. ����̹� ���� OK");
		
		con = DriverManager.getConnection(url, "scott","tiger");
		System.out.println("2.connection �ν��Ͻ� ���� OK");
		
		stmt=con.createStatement();
		System.out.println("3. statement��ü ���� OK");
		
		String createSql=
				"Create TABLE member"
				+"(no NUMBER,"
				+ "id VARCHAR2(10),"
				+ "pwd VARCHAR2(10) )";
		
		System.out.println("���� ���۰��:"+stmt.executeUpdate(createSql));
		System.out.println("4.���� ���� �Ϸ�");
			
		if(stmt != null)	stmt.close();
		if( con != null)	con.close();
	}
	

}
