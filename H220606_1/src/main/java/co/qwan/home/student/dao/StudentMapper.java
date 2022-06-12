package co.qwan.home.student.dao;

import java.util.List;

import co.qwan.home.student.vo.StudentVO;

public interface StudentMapper {
	public StudentVO getOne(StudentVO vo);
	public List<StudentVO> getList();
}
