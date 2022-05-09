package co.edu.full;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullDAO {
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    
    // 리스트.
    public List<FullVO> getList() {
	String sql = "SELECT * FROM full_calendar";
	List<FullVO> list = new ArrayList<FullVO>();
	getConnect();
	try {
	    psmt = conn.prepareStatement(sql);
	    rs = psmt.executeQuery();
	    while (rs.next()) {
		FullVO vo = new FullVO(rs.getString("title")
			, rs.getString("start_date")
			, rs.getString("end_date")
		);
		list.add(vo);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disConnect();
	}
	return list;
    }
    
    // 한건입력.
    public void insertSchedule(FullVO vo) {
	String sql = "INSERT INTO full_calendar(title, start_date, end_date) "
		+ "VALUES(?, ?, ?)";
	getConnect();
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, vo.getTitle());
	    psmt.setString(2, vo.getStartDate());
	    psmt.setString(3, vo.getEndDate());
	    int r = psmt.executeUpdate();
	    System.out.println(r + "건 입력.");
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disConnect();
	}
    }
    
    // 한건삭제.
    public void deleteSchedule(String title) {
	String sql = "DELETE FROM full_calendar WHERE title = ?";
	getConnect();
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, title);
	    int r = psmt.executeUpdate();
	    System.out.println(r + "건 삭제.");
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disConnect();
	}
    }
    
    
    public void getConnect() {
	try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	} catch (ClassNotFoundException | SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public void disConnect() {
	if (rs != null) {
	    try {
		rs.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	
	if (psmt != null) {
	    try {
		psmt.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	
	if (conn != null) {
	    try {
		conn.close();
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
}
