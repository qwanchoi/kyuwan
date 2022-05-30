package co.qwan.prj.student.service;

import java.util.List;

import co.qwan.prj.student.vo.StudentVO;

public interface StudentService { //dao에서 사용하는 인터페이스
	List<StudentVO> studentSelectList(); // 전체회원
	StudentVO studentSelect(StudentVO vo); // 한명조회 or 로그인 처리
	int studentInsert(StudentVO vo); // 회원추가
	int studentUpdate(StudentVO vo); // 회원수정
	int studentDelete(StudentVO vo); // 회원삭제
	
	boolean idCheck(String id); // 아이디 중복 체크
}
