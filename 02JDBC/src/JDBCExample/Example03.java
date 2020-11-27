package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Example03 {
	
	public static void main(String args[]) throws Exception{
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, "scott","tiger");
		
		Statement stmt = con.createStatement();
		
		String id=args[0];
		
		//DML : DELETE
		String sql = "DELETE FROM member WHERE id=('"+id+"')";
		
	
		
		//DML 전송
		int i =stmt.executeUpdate(sql);
		System.out.println("DELETE된 레코드 수는 : "+i+"개의 행이 삭제되었습니다.");
		
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