package com.dev;

public class ForExample5 {
	public static void main(String[] args) {
		//
		int num = 48; // 약수의 모든 숫자를 구하는 프로그램
		
		System.out.println(num+ "의 약수");
		for(int i = 1; i < num; i++) {
			if( num % i == 0 ) {
				System.out.print(i +" ");
			}
		}
		
		
	}
}
