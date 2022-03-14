package com.edu;

import java.util.Scanner;

// 이름을 입력받도록...(String)	-> scn.nextLine(); || scn.next();
// 연락처 입력...(String) 		-> scn.nextLine(); 
// 나이 입력...(int) 			-> scn.nextInt();
// 키 입력...(double) 			-> scn.nextDouble();

// 이름은 : ???
// 연락처 : ???-????-????
// 나이 : ??
// 키 : ???.?
// 몸무게 : ??.?
// 적정몸무게: (키 - 100) * 0.9 => 60.3 +- 5키로그램.... (55.3 < 적정 < 65.3)
// 적정 몸무게 보다 클경우 과체중 작으면 저체중
public class TodayExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String name, phone;
		int age;
		double height, weight;
		
		double standard;
		
		System.out.println("이름을 입력해 주세요...");
		name = scn.nextLine();
		System.out.println("연락처를 입력해 주세요...");
		phone = scn.nextLine();
		System.out.println("나이를 입력해 주세요...");
		age = scn.nextInt();
		System.out.println("키를 입력해 주세요...");
		height = scn.nextDouble();
		System.out.println("몸무게를 입력해 주세요...");
		weight = scn.nextDouble();
		
		System.out.println("이름 : "+name);
		System.out.println("번호 : "+phone);
		System.out.println("나이 : "+age);
		System.out.println("신장 : "+height);
		System.out.println("체중 : "+weight);
		
		standard = (height - 100)*0.9;
		System.out.println("기준 값 :"+standard);
		if(standard < weight) {
			System.out.println("과체중 입니다.");
		} else {
			System.out.println("저체중 입니다.");
		}
		
		if(standard+5 > weight && standard-5 < weight) {
			System.out.println("적정 몸무게 입니다.");
		} else {
			System.out.println("비정상입니다.");
		}
		
		scn.close();
	}
}
