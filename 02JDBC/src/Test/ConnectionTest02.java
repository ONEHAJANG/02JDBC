package Test;

import java.sql.*;
//import java.util.*;

//Oracle Driver 사용
//import oracle.jdbc.driver.*;

/*
*	FileName : ConnectionTest01.java
*
*	1. JDBC Programming  절차 이해
 *   ==>DBMS 접근(login과정)			: Connection 객체로 Object Modeling
 *   ==>SQL Prompt  & SQL전송		: Statement  객체로 Object Modeling
 *   ==>SQL문의 결과						: ResultSet 객체로 Object Modeling
*/
public class ConnectionTest02{
   
	///Main Method
	public static void main(String[] args) throws Exception{

		//DB에 로그인 접속정보
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //내 아이피로 바꿔보기
		//url- unoform resource location      프로토콜로 : 접근하라 : 드라이버를 쓰기위해 @ 포트정보로 : 만나라
		String user ="scott";
		String pwd = "tiger";

/*====DBMS 종속적인 아래의 부분을 주석 이유 이해===============
		//1.단계  connection :: login 과정
		//1.1 OracleDriver  instance 생성
		OracleDriver od = new OracleDriver();

		//1.2 oracle에 접속 정보를 갖는  properties instance 생성 
		Properties info = new Properties();
		info.put("user",user);                          //맵 구조에 로그인정보 할당
		info.put("password",pwd);

		//1.3OracleDriver intance를 사용  Connection instance 생성
		Connection con = od.connect(url,info);                  //커넥션 = 로그인 끝
======================================================*/

		//Interface 기반 Programing : java.sql.* 이용 DBMS 비종속적인 DB
		//1단계 connection :: login 과정
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,user,pwd);

		//2단계 QUERY (SELECT * FROM product) 전송단계 
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM product");           //익스큐트쿼리 보기 API로 

		//3단계 결과 확인
		while(rs.next()){   //의미는???????????  true면 DB에서 값을 불러옴.

			String productName = rs.getString("p_name");
			//String productName = rs.getString(1); // 에스큐엘의 인덱스는1부터 시작함 (기억이 안나ㅜㅜ) 자바는 0부터시작
			int productPrice = rs.getInt("p_price");
			//int productPrice = rs.getInt(2);               //DBMS/ java 데이터 타입 연결

			System.out.print("상품명 : "+productName);              // 레코드는 두갠데 왜 하나만 나옴?? 
			System.out.print("가   격 : "+productPrice);
		}                // 

		//각각의 객체를 close한다.
		rs.close();          
		stmt.close();
		con.close();

	}//end of main

}//end of class