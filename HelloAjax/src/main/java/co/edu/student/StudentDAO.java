package co.edu.student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO {
    // 한건수정.
    public boolean modifyStudent(Student stud) {
	conn = getConnect();
	String sql = "UPDATE student_info SET student_name=?, eng_score=?, kor_score=? WHERE student_no = ?";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, stud.getStudentName());
	    psmt.setInt(2, stud.getEngScore());
	    psmt.setInt(3, stud.getKorScore());
	    psmt.setInt(4, stud.getStudentNo());
	    
	    int r = psmt.executeUpdate();
	    System.out.println(r + "건 변경.");
	    if(r > 0) {
		return true;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return false;
    }
    
    // 한건삭제.
    public boolean removeStudent(String id) {
	conn = getConnect();
	String sql = "DELETE FROM student_info WHERE student_no = ?";
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, id);
	    int r = psmt.executeUpdate();
	    System.out.println(r + "건 삭제.");
	    
	    if( r > 0 ) {
		return true;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	return false;
    }
    
    // 한건입력.
    public boolean addStudent(Student stud) {
	conn = getConnect(); // Connection 객체.
	String sql = "INSERT INTO student_info "
		+ "VALUES (?, ?, ?, ?)";
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setInt(1, stud.getStudentNo());
	    psmt.setString(2, stud.getStudentName());
	    psmt.setInt(3, stud.getEngScore());
	    psmt.setInt(4, stud.getKorScore());
	    int r = psmt.executeUpdate();
	    System.out.println(r + " 입력.");
	    if (r > 0) {
		return true;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	return false;
    }
    
    // 전체조회.
    public List<Student> studentList() {
	conn = getConnect();
	List<Student> list = new ArrayList<Student>();
	try {
	    psmt = conn.prepareStatement("SELECT * FROM student_info ORDER BY student_no");
	    rs = psmt.executeQuery();
	    while(rs.next()) {
		Student student = new Student();
		student.setStudentNo(rs.getInt("student_no"));
		student.setStudentName(rs.getString("student_name"));
		student.setEngScore(rs.getInt("eng_score"));
		student.setKorScore(rs.getInt("kor_score"));
		list.add(student);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    this.disconnect();
	}
	return list;
    }
    
    
}
