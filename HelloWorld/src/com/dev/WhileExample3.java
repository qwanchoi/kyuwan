package com.dev;

import java.util.Scanner;

public class WhileExample3 {
	public static void main(String[] args) {
		// 입력을 계속 입력할 수 ...
		// -1 값을 입력하면 입력 멈춤.
		// sum 값에 입력...
		
		Scanner scn = new Scanner(System.in);		
		
		int sum = 0;
		int inputVal = 0;
		
		while(true) {
			
			System.out.println("정수를 입력해 주세요.");
			inputVal = scn.nextInt();
			
			if(inputVal == -1)  {
				scn.close();
				
				System.out.println("합계 값 :"+sum);
				break;
			}
			sum += inputVal;

		}
		
	}
}
