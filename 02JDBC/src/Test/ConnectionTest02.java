package Test;

import java.sql.*;
//import java.util.*;

//Oracle Driver ���
//import oracle.jdbc.driver.*;

/*
*	FileName : ConnectionTest01.java
*
*	1. JDBC Programming  ���� ����
 *   ==>DBMS ����(login����)			: Connection ��ü�� Object Modeling
 *   ==>SQL Prompt  & SQL����		: Statement  ��ü�� Object Modeling
 *   ==>SQL���� ���						: ResultSet ��ü�� Object Modeling
*/
public class ConnectionTest02{
   
	///Main Method
	public static void main(String[] args) throws Exception{

		//DB�� �α��� ��������
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //�� �����Ƿ� �ٲ㺸��
		//url- unoform resource location      �������ݷ� : �����϶� : ����̹��� �������� @ ��Ʈ������ : ������
		String user ="scott";
		String pwd = "tiger";

/*====DBMS �������� �Ʒ��� �κ��� �ּ� ���� ����===============
		//1.�ܰ�  connection :: login ����
		//1.1 OracleDriver  instance ����
		OracleDriver od = new OracleDriver();

		//1.2 oracle�� ���� ������ ����  properties instance ���� 
		Properties info = new Properties();
		info.put("user",user);                          //�� ������ �α������� �Ҵ�
		info.put("password",pwd);

		//1.3OracleDriver intance�� ���  Connection instance ����
		Connection con = od.connect(url,info);                  //Ŀ�ؼ� = �α��� ��
======================================================*/

		//Interface ��� Programing : java.sql.* �̿� DBMS ���������� DB
		//1�ܰ� connection :: login ����
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,user,pwd);

		//2�ܰ� QUERY (SELECT * FROM product) ���۴ܰ� 
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM product");           //�ͽ�ťƮ���� ���� API�� 

		//3�ܰ� ��� Ȯ��
		while(rs.next()){   //�ǹ̴�???????????  true�� DB���� ���� �ҷ���.

			String productName = rs.getString("p_name");
			//String productName = rs.getString(1); // ����ť���� �ε�����1���� ������ (����� �ȳ��̤�) �ڹٴ� 0���ͽ���
			int productPrice = rs.getInt("p_price");
			//int productPrice = rs.getInt(2);               //DBMS/ java ������ Ÿ�� ����

			System.out.print("��ǰ�� : "+productName);              // ���ڵ�� �ΰ��� �� �ϳ��� ����?? 
			System.out.print("��   �� : "+productPrice);
		}                // 

		//������ ��ü�� close�Ѵ�.
		rs.close();          
		stmt.close();
		con.close();

	}//end of main

}//end of class