package com.dev;

import java.util.Scanner;

public class ForExample3 {
	public static void main(String[] args) {
		// 입력받는 두 수를 num1, num2
		// num1 과 num2 사이의 값을 더해서 출력~

		int num1, num2, sum = 0;
		
		Scanner scn = new Scanner(System.in);

		System.out.println("첫번째 숫자를 입력해 주세요.");
		num1 = scn.nextInt();
		System.out.println("두번째 숫자를 입력해 주세요.");
		num2 = scn.nextInt();

		for (int i = num1; i <= num2; i++) {
			sum += i;
		}
		System.out.println(num1+"부터 "+num2+"까지 합: " + sum);

		scn.close();
	}
}
