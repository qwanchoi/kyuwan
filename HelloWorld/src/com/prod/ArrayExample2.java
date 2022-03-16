package com.prod;

public class ArrayExample2 {
	public static void main(String[] args) {
		int[] ages = new int[3];
		int sumAge = 0;
		double avgAge = 0.0;

		ages[0] = 20;
		ages[1] = 23;
		ages[2] = 27;

		ages[0] = 30;
		ages[1] = 32;
		ages[2] = 35;
		for (int i = 0; i < 3; i++) {
			sumAge += ages[i];
			System.out.println(ages[i] + "살 입니다.");
		}

		avgAge = sumAge / (double) 3;
		System.out.println("평균: " + avgAge + "살 입니다.");
		
		System.out.printf("평균: %.2f살 입니다.", avgAge); // 포멧팅 및 반올림
	}
}
