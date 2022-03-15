package com.dev;

public class WhileExample2 {
	public static void main(String[] args) {
		// 1 ~ 10 까지 수 중에서 짝수만 출력.
		// while 문으로 작성.

		int i = 1; // 초기화...
		while (i <= 10) { // 조건식...
			if (i % 2 == 0) {
				System.out.println("짝수 :"+i);
			}
			i++; // 증감식...
		}
	}
}
