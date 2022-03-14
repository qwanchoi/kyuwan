package com.edu;

import java.util.Scanner;

public class ScannerExample { // com.edu.ScannerExample 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력하세요...");
		int val = scn.nextInt();
		System.out.println("두번째 숫자를 입력하세요...");
		int val2 = scn.nextInt();
		// val1, val2의 값을 합한 결과를 담을 변수 선언하고 결과를 저장.
		int sum = val+val2;
		
		System.out.println("두 수의 합은 "+ sum +"입니다.");
		
//		if(val % 2 == 0) {
//			System.out.println("짝수 입니디.");
//		}
//		if(val % 2 == 1) {
//			System.out.println("홀수 입니디.");
//		}
		
		
		scn.close();
	}
}
