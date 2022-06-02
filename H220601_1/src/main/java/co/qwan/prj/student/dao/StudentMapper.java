package co.qwan.prj.student.dao;

import java.util.List;

import co.qwan.prj.student.vo.StudentVO;

public interface StudentMapper {
	public List<StudentVO> selectStudentList();
	public StudentVO selectStudent(StudentVO vo);
	public int insertStudent(StudentVO vo);
	public int updateStudent(StudentVO vo);
	public int deleteStudent(StudentVO vo);
	
	public boolean checkId(String id);
}
