package com.dev;

public class SwitchExample2 {
	public static void main(String[] args) {
		// 90점 이상 A, 80점 이상 B, 70점 C, 60점 D, 그외 F;
		int score = 75;
		int mScore = score/10;
		
		switch(mScore) {
		case 10:
		case 9:
			System.out.println("A 학점"); break;
		case 8:
			System.out.println("B 학점"); break;
		case 7:
			System.out.println("C 학점"); break;
		case 6:
			System.out.println("D 학점"); break;
		default:
			System.out.println("F 학점");
		}
	}
}
