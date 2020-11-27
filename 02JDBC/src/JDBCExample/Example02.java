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
		
	
		
		//DML 전송
		int i =stmt.executeUpdate(sql);
		System.out.println("INSERT유무 : "+i+"개의 행이 만들어졌습니다.");
		
	//	i = stmt.executeUpdate(sql1);
		//System.out.println("2번 insert 유무 : "+i+" 개의 행이 만들어졌습니다.");
		
	//	i = stmt.executeUpdate(sql1);
		//System.out.println("3번 insert 유무 : "+i+" 개의 행이 만들어졌습니다.");
		
		
		if(stmt != null)
			stmt.close();
		if( con != null)	
			con.close();
		
	}

}
