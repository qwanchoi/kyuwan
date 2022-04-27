package co.edu.student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO {
    
    // 전체조회.
    public List<Student> studentList() {
	conn = getConnect();
	List<Student> list = new ArrayList<Student>();
	try {
	    psmt = conn.prepareStatement("select * from student_info");
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
