package Test;


import java.sql.*;



public class CreateJDBC{
public static void main(String[] args){
	
	//JDBC ������ �ʿ��ν��Ͻ� �� ���� ����
   Connection con =null;
   Statement stmt = null;
   String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
  
   //1.connection :: login ������ �߻�ȭ�� interface
   try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("1. driver loaing OK");
   }catch(ClassNotFoundException e) {
      System.out.println("\n==> Driver Loading �� Exception �߻�\n");
      e.printStackTrace();
      
   }
   
   try {
      con = DriverManager.getConnection(url, "scott", "tiger");
      System.out.println("2. connection �ν��Ͻ� ���� �Ϸ�");
   }catch(SQLException e) {
      System.out.println("\n==> JDBC ���� �� Exception �߻�\n"+ e.getErrorCode());
      e.printStackTrace();
      
   }
   
   try {
      stmt = con.createStatement();
      System.out.println("3. statement��ü �����Ϸ�");
   }catch(SQLException e) {
      System.out.println("\n==> JDBC ���� �� Exception �߻� : " + e.getErrorCode());
      e.printStackTrace();
      
   }
   
   String createSql = 
         "Create TABLE firstJDBC"
         + "(no   NUMBER(3), "
         +   "name VARCHAR2(20), "
         +   "email VARCHAR2(30), "
         +   "address VARCHAR2(50) )";

   try {
      System.out.println("QUEREY ���� ��� : " + stmt.executeUpdate(createSql));
      System.out.println("4. query ���ۿϷ�");
   }catch(SQLException e) {
      System.out.println("\n==> JDBC ���� �� Exception �߻� : " + e.getErrorCode());
      e.printStackTrace();
      
   }
   
   try {
      if ( stmt != null)   stmt.close();
      if ( con != null)   con.close();
   }catch(SQLException e) {
      System.out.println("\n==> JDBC ���� �� Exception �߻� : " + e.getErrorCode());
      e.printStackTrace();
   }
}
//���� catech��
	//catch {
		
	//}
}
      
