package com.prod;

public class ArrayExample {
	public static void main(String[] args) {
		long l1 = 99999999L; // 8byte
		int i1 = 100; // 4 byte
		byte b1 = 127; // 1 byte -128 ~ -1,0 ~ 127
		b1++;
		System.out.println(b1); // -128
		b1++;
		System.out.println(b1); // -127

		short s1 = 100; // (2byte) -32768~-1 , 0~32767
		System.out.println(Short.MAX_VALUE);

		int sum = 0;
		int score1 = 80;
		int score2 = 90;
		int score3 = 85;
		int score4 = 95;
		int score5 = 88;

		sum += score1;
		sum += score2;
		sum += score3;
		sum += score4;
		sum += score5;

		double avg = sum / (double) 5;
		System.out.println(avg);

		int[] scores = new int[5];
		scores[0] = 80;
		scores[1] = 90;
		scores[2] = 85;
		scores[3] = 95;
		scores[4] = 88;
		
		sum = 0;
		for (int i = 0; i < 5; i++) {
//			System.out.println(scores[i]);
			sum += scores[i];
		}
		avg = sum / (double) 5 ;
		System.out.println("평균은 " + avg);
	}
}
