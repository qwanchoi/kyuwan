package com.dev;

public class ForExample4 {
	public static void main(String[] args) {
		// 1 ~ 10 까지 수 중에서 짝수의 값 => evenSum, 홀수의 값 => oddSum
		
		int evenSum = 0;
		int oddSum = 0;
		
		for(int i = 0; i<=10; i++) {
			if(i%2 == 0) {
				evenSum+=i;
			} else {
				oddSum+=i;
			}
		}
		
		System.out.println("짝수 합"+evenSum+" 홀수 합"+oddSum);
	}
}
