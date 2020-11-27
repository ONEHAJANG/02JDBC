package Test;


import java.sql.*;



public class CreateJDBC{
public static void main(String[] args){
	
	//JDBC 절차에 필요인스턴스 및 정보 선언
   Connection con =null;
   Statement stmt = null;
   String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
  
   //1.connection :: login 과정을 추상화한 interface
   try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("1. driver loaing OK");
   }catch(ClassNotFoundException e) {
      System.out.println("\n==> Driver Loading 시 Exception 발생\n");
      e.printStackTrace();
      
   }
   
   try {
      con = DriverManager.getConnection(url, "scott", "tiger");
      System.out.println("2. connection 인스턴스 생성 완료");
   }catch(SQLException e) {
      System.out.println("\n==> JDBC 절차 중 Exception 발생\n"+ e.getErrorCode());
      e.printStackTrace();
      
   }
   
   try {
      stmt = con.createStatement();
      System.out.println("3. statement객체 생성완료");
   }catch(SQLException e) {
      System.out.println("\n==> JDBC 절차 중 Exception 발생 : " + e.getErrorCode());
      e.printStackTrace();
      
   }
   
   String createSql = 
         "Create TABLE firstJDBC"
         + "(no   NUMBER(3), "
         +   "name VARCHAR2(20), "
         +   "email VARCHAR2(30), "
         +   "address VARCHAR2(50) )";

   try {
      System.out.println("QUEREY 전송 결과 : " + stmt.executeUpdate(createSql));
      System.out.println("4. query 전송완료");
   }catch(SQLException e) {
      System.out.println("\n==> JDBC 절차 중 Exception 발생 : " + e.getErrorCode());
      e.printStackTrace();
      
   }
   
   try {
      if ( stmt != null)   stmt.close();
      if ( con != null)   con.close();
   }catch(SQLException e) {
      System.out.println("\n==> JDBC 절차 중 Exception 발생 : " + e.getErrorCode());
      e.printStackTrace();
   }
}
//다중 catech문
	//catch {
		
	//}
}
      
