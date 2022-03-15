package com.dev;

import java.util.Scanner;

public class Work2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1, num2, num3;
		int temp = 0;
		
		System.out.println("첫번째 수를 입력해 주세요.");
		num1 = scn.nextInt();
		
		System.out.println("두번째 수를 입력해 주세요.");
		temp = scn.nextInt();
		if(num1 > temp) {
			num2 = num1;
			num1 = temp;
		} else {
			num2 = temp;
		}
		
		System.out.println("세번째 수를 입력해 주세요.");
		temp = scn.nextInt();
		if(num2 > temp) {
			num3 = num2;
			num2 = temp;
			if(num1 > temp) {
				num2 = num1;
				num1 = temp;
			}
		} else {
			num3 = temp;
		}
		
		
		System.out.println("수 정렬: "+num1+", "+num2+", "+num3);
		scn.close();
		System.out.println("end of prog");
	}
}
