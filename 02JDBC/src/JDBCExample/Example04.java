package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Example04 {
	
	public static void main(String args[]) throws Exception{
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="scott";
		String pwd= "tiger";
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user,pwd);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT*FROM product");
		
		while(rs.next()) {
			
//			String productName = rs.getString();
//			int productPrice = rs.getInt();
			
//			System.out.println("��ǰ�� :"+productName);
			System.out.println("����");
		}
		
		String in = args[0];
		String no = args[1];
		String id = args[2];
		String pwd1 = args[3];
		
		//DML : INSERT
		String sql = "INSERT INTO member VALUES('('"+in+"')''=>'','��ȣ:'('"+no+"'),'id:'('"+id+"'),'pwd:'('"+pwd1+"')";
	//	String sql2 = "INSERT INTO member VALUES(2,'ȫ���','b@lycos.co.kr','�Ѿ�')";
	//	String sql3 = "INSERT INTO member VALUES(3,'�̼���','c@lycos.co.kr','�Ѿ�')";
	
		
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
