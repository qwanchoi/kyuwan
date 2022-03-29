package home.prod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSample {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("connect complete..!");
		
		String sql = "";
		sql = "select * from emp_java";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.print("emp_no :" 
						+ rs.getInt("employee_id"));
				System.out.println(", name :" 
						+ rs.getString("first_name"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		try {
			if (conn != null) conn.close();
			if (psmt != null) psmt.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("disconnected...!");
		
	} // end of main.
}
