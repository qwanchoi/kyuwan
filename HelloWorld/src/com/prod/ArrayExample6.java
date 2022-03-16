package com.prod;

public class ArrayExample6 {
	public static void main(String[] args) {
		int[] numbers = { 35, 22, 17, 40, 28, 33, 36 };
		int sum = 0;
		int cnt = 0;
		// 배열의 값이 30보다 크고 40보다 작은 값의 합, 평균...

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 30 && numbers[i] < 40) { // 홀 수 번째 값
				sum += numbers[i];
				cnt++;
			}
		}

		System.out.println("결과 값의 합 :" + sum);
		System.out.printf("결과 값 평균 : %.3f \n" , (sum / (double) cnt));
		System.out.println("end of prog");
	}
}
