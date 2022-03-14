package com.edu;

import java.util.Scanner;

public class TemperatureExample {
	public static void main(String[] args) {
		// C = 5/9(F-32) 화씨온도를 섭씨온도로 변경하는 식
		Scanner scn = new Scanner(System.in);
		// Scanner cursor ctrl+shift+O => 임포트
		double fDeg, cDeg;
		
		System.out.println("온도(F˚)를 입력해 주세요");
		fDeg =  scn.nextDouble();
		
		cDeg = (double)5/9*(fDeg-32);
		
		// 30.0 보다 크면 "오늘은 더운 날씨네요" 그외는 "살만하네요."
		System.out.print("섭씨(C˚) "+cDeg+" 도 ");
		if(cDeg > 30.0) {
			System.out.println("오늘은 더운 날씨네요");
		} else {
			System.out.println("살만하네요.");
		}
		
		scn.close();
	}
}
