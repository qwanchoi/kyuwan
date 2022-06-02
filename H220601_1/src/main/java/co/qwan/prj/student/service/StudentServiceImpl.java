package co.qwan.prj.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.qwan.prj.student.dao.StudentMapper;
import co.qwan.prj.student.vo.StudentVO;

@Service("studentBiz")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper map;
	
	@Override
	public List<StudentVO> selectStudentList() {
		return map.selectStudentList();
	}

	@Override
	public StudentVO selectStudent(StudentVO vo) {
		return null;
	}

	@Override
	public int insertStudent(StudentVO vo) {
		return 0;
	}

	@Override
	public int updateStudent(StudentVO vo) {
		return 0;
	}

	@Override
	public int deleteStudent(StudentVO vo) {
		return 0;
	}

	@Override
	public boolean checkId(String id) {
		return false;
	}

}
