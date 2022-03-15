package com.dev;

import java.util.Scanner;

public class ForExample5A {
	public static void main(String[] args) {
		// 두 수의 최대 공약수
		int num1, num2, result;
		
		num1 = num2 = result = 0;
		Scanner scn = new Scanner(System.in);
		
		
		System.out.println("첫번째 숫자를 입력해 주세요.");
		num1 = scn.nextInt();
		
		System.out.println("두번째 숫자를 입력해 주세요.");
		num2 = scn.nextInt();
		
		for(int i = num1; i > 0; i--) {
			if( num1 % i == 0) {
				for(int j = num2; j > 0; j--) {
					if( num2 % j == 0) {
						
						if( i == j ) {
							System.out.println("두 수의 최대 공약수 "+i);
							i = j = -1;
						}
					}
				}
				
			}
		}

	}
}
