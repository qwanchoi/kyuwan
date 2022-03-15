package com.dev;

import java.util.Scanner;

public class IfExample3 {
	public static void main(String[] args) {
		int ranVal = (int) (Math.random() * 3) + 1; // 0 ~ 1
		Scanner scn = new Scanner(System.in);

		// System.out.println(ranVal);
		System.out.println("1~3사이의 정수를 입력해 주세요.");
		int inVal = scn.nextInt();

		System.out.print("무작위 숫자:" + ranVal);
		if (inVal == ranVal) {
			System.out.println(" 같은 수 입니다.");
		} else {
			System.out.println(" 다른 수 입니다.");
		}
		scn.close();

	}
}
