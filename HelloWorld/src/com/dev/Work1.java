package com.dev;

import java.util.Scanner;

public class Work1 {
	public static void main(String[] args) {
		int num1, num2, gap;

		Scanner scn = new Scanner(System.in);

		System.out.println("첫번째 수를 입력해 주세요.");
		num1 = scn.nextInt();
		System.out.println("두번째 수를 입력해 주세요.");
		num2 = scn.nextInt();

		if (num2 > num1) {
			gap = num2 - num1;
		} else {
			gap = num1 - num2;
		}
		System.out.println("두 수의 차이는 :"+gap);
		scn.close();
		System.out.println("end of prog");
	}
}
