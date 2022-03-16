package com.prod;

public class ArrayExample5 {
	public static void main(String[] args) {
		int[] numbers = { 35, 22, 17, 40, 28, 33, 36 };
		int sum = 0;
		int cnt = 0;

		for (int i = 0; i < numbers.length; i += 2) {
			sum += numbers[i];
			cnt++;
		}
		System.out.println("배열의 홀수번째 합 :" + sum);
		System.out.println("합의 평균 :" + (sum / (double) cnt));

	}
}
