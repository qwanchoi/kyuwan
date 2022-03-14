package com.edu;

public class Variables {
	public static void main(String[] args) {
		// 변수 : 메모리공간 이름지정 값을 할당.
		int age = 20; // 20 == 30
		System.out.println("age변수 : " + age);
		int num1 = 60;
		int num2 = 50;
		int result = num1 + num2;

		System.out.println(num1 + "+" + num2 + " = " + result);
		System.out.println("20 + 10 = 30");
		
		String name = "홍길동"; // 문자열
		name = "훙길둥";
		System.out.println(name + "의 나이는 "+ age + "입니다.");
		
		final String myName = "최규완"; // 상수(Copnstance)
//		myName = "푸른폭풍";
		
		// 전화번호, 이메일 값을 담을 수 있는 변수. 010-0001, ckw@mail.com
		
		String myPhone = "010-3614-9414";
		String myEmail = "rbdhks2002@gmail.com";
		
		System.out.println(myName+"의 전화번호: "+myPhone+", 이메일 :"+myEmail);
	}
}
