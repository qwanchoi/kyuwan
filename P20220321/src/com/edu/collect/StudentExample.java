package com.edu.collect;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    public static void main(String[] args) {
	List<Student> list = new ArrayList<Student>();
	
	Student s1 = new Student(101, "홍길동", 70, 73);
	Student s2 = new Student(102, "김주환", 80, 85);
	Student s3 = new Student(103, "이재학", 84, 78);
	
	list.add(s1);
	list.add(s2);
	list.add(s3);
	
	Student result = list.get(0); // 첫번째 학생정보 저장.
	System.out.println("첫번째 학생: "+result.toString());
	
	list.set(0, new Student(201, "서현일", 90, 92)); // 첫번째 인스턴스 변경.
	result = list.get(0);
	
	list.get(0).setKorScore(100); // 첫번째 인스턴스의 값 변경.
	list.get(0).setEngScore(100); // 
	
	list.remove(0); // 삭제처리.
	
	System.out.println("첫번재 학생: " + result.toString());
	
    }
}
