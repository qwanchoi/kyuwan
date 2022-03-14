package com.edu;

import java.util.Scanner;

public class CalExample {
	public static void main(String[] args) {
		// 초(ex: 100초) 입력 -> 시/분/초 로 변경하기.
		Scanner scn = new Scanner(System.in);
		int hour, minute, second, inputVal;
		
		final int CON_MIN = 60;
		final int CON_HOUR = 60*60;
		
		System.out.println("초 단위 입력(ex; 150)");
		inputVal = scn.nextInt();
		
		hour = inputVal / CON_HOUR;
		minute = (inputVal % CON_HOUR) / CON_MIN;
		second = inputVal % CON_MIN;
		
		System.out.println("초 -> 시/분/초 변경 결과");
		System.out.println(inputVal+" -> "+hour+"/"+minute+"/"+second);
		scn.close();
	}
}
