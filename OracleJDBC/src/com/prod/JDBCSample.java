package com.prod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ojdbc 라이브러리, 오라클DB 연결 (db접속주소, hr ,hr), Connection 객체,
// query 실행(Statement, PreparedStatement)
public class JDBCSample {
//	DriverManager
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;
	private static PreparedStatement psmt;

	public static Connection getConnection() {
		// DB 연결부
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection( //
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// "...:@주소:포트:DB명","계정","PW");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("연결성공!!");
		return conn;
	}

	public static void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("disconnected...");
	}

	public static void main(String[] args) {
		conn = getConnection();

		// Statement 생성
		try {
//	    stmt = conn.createStatement(); // 실제 쿼리 실행 하는 statement 생성

			// 입력. 사원번호, last_name, 입사일자, 이메일, job_id
			int emp_id = 302;
			String last_name = "홍길동";
			String hire_date = "2020-03-05";
			String email = "kdong@email.com";
			String job = "IT_PROG";

			String fn = "kildong";
			String pn = "010-xxxx-7xx4";
			int salary = 8000;

			String sql = "";

			sql = "delete from emp_java " + "where employee_id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp_id);

			// PreparedStatement 활용 update
//	    sql = "update emp_java "
//	    	+ "set	first_name = ?, " //
//	    	+ "	phone_number = ?, " //
//	    	+ "	salary = ? " //
//	    	+ "where employee_id = ? ";

//	    psmt = conn.prepareStatement(sql);
//	    psmt.setString(1, fn);
//	    psmt.setString(2, pn);
//	    psmt.setInt(3, salary);
//	    psmt.setInt(4, emp_id);

			// 수정 쿼리
//	    sql = "update emp_java \r\n"
//	    	+ "set first_name = '"+fn+"', "
//	    	+ "	phone_number='"+pn+"', "
//	    	+ "	email = '"+email+"', "
//	    	+ "	salary = "+salary+" \r\n"
//	    	+ "where employee_id = "+emp_id+"";
			// 입력 쿼리
//	    sql = "insert into emp_java (employee_id, last_name, email, hire_date, job_id) " + "values ("
//		    + emp_id + ", '" + last_name + "', '" + email + "', '" + hire_date + "','" + job + "')";

			int r = psmt.executeUpdate(); // 입력, 수정, 삭제
			System.out.println(r + "건 입력됨.");

			// 조회
//	    rs = stmt.executeQuery("select * from emp_java order by employee_id"); // 쿼리 실행
//	    while(rs.next()) { // 데이터를 1건 가져오기
//		System.out.print("사원번호: " + rs.getInt("employee_id")); // 가져온 값 중에 "컬럼명"에 해당하는 값
//		System.out.println(" 이름: " +rs.getString("first_name"));
//	    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		disconnect();
	} // end of main();
}
