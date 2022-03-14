package com.edu;

public class BitExample {
	public static void main(String[] args) {
		int num = 10;
		int result = num << 3;
		
		System.out.println(result);
		
		int val = 100;
		val = val + 10;
		System.out.println(val); // 110
		val += 20;
		System.out.println(val); // 130
		
		val = val - 5; // 125
		val -= 10; // 115
		
		val = val * 2; // 230
		val *=2;	// 460
		System.out.println(val); // 460
		
		String message = "반갑습니다";
		System.out.println(message);
		
		message = message + " 최규완입니다.";
		System.out.println(message);
		
		message += " 좋은 하루 되세요!";
		System.out.println(message);
		
		int cnt = 0;
		cnt = cnt + 1;
		cnt += 1;
		cnt++;
		
		System.out.println(cnt);
	}
}
