package com.prod;

public class MemberExample {
	public static void main(String[] args) {
		// int num1 = 10;
		// String name = "홍길덩";
		// ?? member = "홍길동", 10;
		
		Member mem1 = new Member(); // name, age 속성 X
		mem1.name = "홍길동";
		mem1.age = 20;
		
		Member mem2 = new Member(); //
		mem2.name = "김민수";
		mem2.age = 25;
		
		System.out.println("mem1의 name 속성: " + mem1.name);
		System.out.println("mem1의 age 속성: " + mem1.age);
		
		Student st1 = new Student();
		st1.studentNo = "22-1234987";
		st1.studentName = "김영희";
		st1.korScore = 90;
		st1.engScore = 80;
		
		Student st2 = new Student();
		
		System.out.println("st1의 학번: " + st1.studentNo);
		System.out.println("st1의 이름: " + st1.studentName);
		System.out.println("st1의 국어점수 "+st1.korScore);
		System.out.println("st1의 영어점수 "+st1.engScore);
		
		System.out.println("end of prog..");
	}
}
