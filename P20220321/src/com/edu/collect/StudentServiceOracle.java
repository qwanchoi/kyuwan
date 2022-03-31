package com.edu.collect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceOracle extends DAO implements StudentService{

    @Override
    public void insertStudent(Student student) {
	conn = getConnect();
//	student_no, student_name, eng_score, kor_score
	String sql = "INSERT INTO student_info "
		+ "(student_no, student_name, eng_score, kor_score) "
		+ "VALUES (?, ?, ?, ?)";
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setInt(1, student.getNumber());
	    psmt.setString(2, student.getName());
	    psmt.setInt(3, student.getEngScore());
	    psmt.setInt(4, student.getKorScore());
	    
	    int r = psmt.executeUpdate();
	    System.out.println(r + "건 완료");
	} catch (SQLException e) {
//	    e.printStackTrace();
	    System.out.println("!!입력 실패!!");
	} finally {
	    disconnect();
	}
	
    }

    @Override
    public Student getStudent(int sno) {
	conn = getConnect();
	Student stud = null;
	
	String sql = "SELECT * FROM student_info "
		+ "WHERE student_no = ?";
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setInt(1, sno);
	    
	    rs = psmt.executeQuery();
	    if( rs.next() ) {
		stud = new Student();
//		student_no, student_name, eng_score, kor_score
		stud.setNumber(rs.getInt("student_no"));
		stud.setName(rs.getString("student_name"));
		stud.setEngScore(rs.getInt("eng_score"));
		stud.setKorScore(rs.getInt("kor_score"));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    System.out.println("!!조회 실패!!");
	} finally {
	    disconnect();
	}
	return stud;
	
    }

    @Override
    public List<Student> studentList() {
	List<Student> list = new ArrayList<Student>(); //조회된 결과값을 담기위한 컬렉션.
	conn = getConnect();
	String sql = "SELECT * FROM student_info ORDER BY student_no";
	try {
	    psmt = conn.prepareStatement(sql);
	    rs = psmt.executeQuery(); // 실행건수만큼 반복
	    while(rs.next()) { // 반복자를 통해 요소를 가지고 올 수 있는지 체크. 있으면 하나 가지고 옴.
		// student_no, student_name, eng_score, kor_score
		Student student = new Student();
		student.setNumber(rs.getInt("student_no"));
		student.setName(rs.getString("student_name"));
		student.setEngScore(rs.getInt("eng_score"));
		student.setKorScore(rs.getInt("kor_score"));
		
		list.add(student);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    System.out.println("!!목록 보기 실패!!");
	} finally {
	    disconnect();
	}
	
	return list;
    }

    @Override
    public void modifyStudent(Student student) {
	// 영어 국어만 eng_score / kor_score
	conn = getConnect();
	String sql = "UPDATE student_info "
		+ "SET eng_score = ?, "
		+ "	kor_score = ? "
		+ "WHERE student_no = ?";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setInt(1, student.getEngScore());
	    psmt.setInt(2, student.getKorScore());
	    psmt.setInt(3, student.getNumber());
	    int r = psmt.executeUpdate();
	    if ( r > 0 ) {
		
	    } else {
		
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
    }

    @Override
    public void removeStudent(int sno) {
	conn = getConnect();
	String sql = "DELETE FROM student_info "
		+ "WHERE student_no = ? ";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setInt(1, sno);
	    int r = psmt.executeUpdate();
	    
	    System.out.println(r + "건 삭제");
	} catch (SQLException e) {
	    e.printStackTrace();
	    System.out.println("삭제 실패");
	}  finally {
	    disconnect();
	}
    }

    @Override
    public List<Student> searchStudent(String name) {
	conn = getConnect();
	List<Student> list = new ArrayList<Student>();
	String sql = "SELECT * FROM student_info "
		+ "WHERE student_name LIKE '%'||?||'%' ";
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, name);
	    
	    rs = psmt.executeQuery();
	    
	    while(rs.next()) {
		Student stud = new Student(rs.getInt("student_no"), 
			rs.getString("student_name"),
			rs.getInt("eng_score"),
			rs.getInt("kor_score"));
		list.add(stud);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }

    @Override
    public void saveToFile() {
	//
    }

}
