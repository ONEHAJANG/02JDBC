package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Example02 {
	
	public static void main(String args[]) throws Exception{
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, "scott","tiger");
		
		Statement stmt = con.createStatement();
		
		String no = args[0];
		String id = args[1];
		String pwd = args[2];
		
		//DML : INSERT
		String sql = "INSERT INTO member VALUES('"+no+"', '"+id+"', '"+pwd+"')";
		
	
		
		//DML ����
		int i =stmt.executeUpdate(sql);
		System.out.println("INSERT���� : "+i+"���� ���� ����������ϴ�.");
		
	//	i = stmt.executeUpdate(sql1);
		//System.out.println("2�� insert ���� : "+i+" ���� ���� ����������ϴ�.");
		
	//	i = stmt.executeUpdate(sql1);
		//System.out.println("3�� insert ���� : "+i+" ���� ���� ����������ϴ�.");
		
		
		if(stmt != null)
			stmt.close();
		if( con != null)	
			con.close();
		
	}

}
