package com.edu;

import java.util.Scanner;

public class MathExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1, num2;
		
		System.out.println("첫번째 숫자를 입력해 주세요.");
		num1 = scn.nextInt();
		System.out.println("두번째 숫자를 입력해 주세요.");
		num2 = scn.nextInt();
		
		System.out.println("두 수의 합 :" + num1+num2);
		System.out.println("두 수의 차 :" + (num1-num2));
		System.out.println("두 수의 곱 :" + num1*num2);
		System.out.println("두 수의 몫 :" + num1/num2);
		System.out.println("나눈 나머지 :" + num1%num2);
	}
}
