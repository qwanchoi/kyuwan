package co.ckw.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	// 리스트.
	public List<TodoVO> getList() {
		List<TodoVO> list = new ArrayList<TodoVO>();
		String sql = "SELECT * FROM todo ORDER BY idx ASC";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				TodoVO vo = new TodoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setContent(rs.getString("content"));
				vo.setChecked(rs.getInt("checked"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return list;
	}
	// 
	public int getTodoIdx() {
		int idx = 0;
		String sql = "SELECT todo_seq.NEXTVAL FROM DUAL";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				idx = rs.getInt(1);
			}
			return idx;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	
	// 추가.
	public int insertTodo(String content) {
		String sql = "INSERT INTO todo(idx, content, checked) "
				+ "VALUES(todo_seq.NEXTVAL, ?, 0)";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql, new String[]{"idx"});
			psmt.setString(1, content);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 등록");
			
			rs = psmt.getGeneratedKeys();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	// 삭제.
	public boolean deleteTodo(int index) {
		String sql = "DELETE todo WHERE idx = ?";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, index);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제.");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
	// 수정.
	public boolean updateTodo(TodoVO vo) {
		String sql = "UPDATE todo SET "
				+ "content = ?, "
				+ "checked = ? "
				+ "WHERE idx = ?";
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setInt(2, vo.getChecked());
			psmt.setInt(3, vo.getIdx());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
	
	// DB연결
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
