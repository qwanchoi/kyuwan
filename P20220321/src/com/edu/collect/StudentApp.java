package com.edu.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

    List<Student> list = new ArrayList<Student>();
    Scanner scn = new Scanner(System.in);

    // 멤버 클래스
    class StudentServiceImpl implements StudentService {

	@Override
	public void insertStudent(Student student) {
	    list.add(student);
	}

	@Override
	public Student getStudet(int sno) { // 학생번호로 한건 조회.
	    for (int i = 0; i < list.size(); i++) {
		if (list.get(i).getNumber() == sno) {
		    return list.get(i);
		}
	    }
	    return null;
	}

	@Override
	public List<Student> studentList() { // 전체 리스트.
	    return list;
	}

	@Override
	public void modifyStudent(Student student) { // 수정.
	    for (int i = 0; i < list.size(); i++) {
		if(list.get(i).getNumber() == student.getNumber()) {
		    list.get(i).setEngScore(student.getEngScore()); // 영어점수
		    list.get(i).setKorScore(student.getKorScore()); // 국어점수
		}
	    }
	}

    } // end of StudentServiceImpl

    public void execute() {
	// 메뉴: 1.추가 2.리스트 3.한건조회 4.수정 9.종료
	while (true) {
	    System.out.println("1.추가 2.리스트 3.한건조회 4.수정 9.종료");
	    System.out.print("선택>> ");

	    int menu = scn.nextInt();
	    if (menu == 1) { // 추가
		
	    } else if (menu == 2) { // 리스트

	    } else if (menu == 3) { // 한건조회

	    } else if (menu == 4) { // 수정

	    } else if (menu == 9) { // 종료
		System.out.println("프로그램을 종료합니다.");
		break;
	    } else {
		// 잘못된 선택
	    }
	}

	System.out.println("end of program..");
    }

}
