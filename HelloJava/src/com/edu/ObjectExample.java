package com.edu;

// Object(객체) -> Class(도면, 틀) -> 인스턴스생성(초기화)
// 학생(객체:Object) -> Class Student -> instance(new Student())
public class ObjectExample {
	public static void main(String[] args) {
		int num1 = 10;
		double num2 = 12.34;
		double num3 = 20; // 자동 형변환(Promotion)
		int num4 = (int) 23.4; // 강제형변환(Casting)
		
		String str1 = "Hello"; // 인스턴스 생성 (heap영역에 생성.)
		Car car1 = new Car(); // 초기화(인스턴스 생성)
		car1.setModel("Sonata");
		car1.setPrice(10000000);
		
		Student s1 = new Student(); // 초기화시점에 값을 지정.
		s1.setStudNo(100);
		s1.setStudName("김판호");
		s1.setKorScore(90);
		s1.setEngScore(15);
		s1.setMathScore(85);
		
		System.out.println("영어점수 초기값: " + s1.getEngScore());
		System.out.println("이름의 초기값: " + s1.getStudName());
		System.out.println(s1.getStudName() + "의 합계: "+ s1.getSumScore());
		System.out.println(s1.getStudName() + "의 평균: "+ s1.getAvgScore());
	}
}
