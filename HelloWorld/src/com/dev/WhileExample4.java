package com.dev;

import java.util.Scanner;

public class WhileExample4 {
	public static void main(String[] args) {
		// 은행 계좌를 만들어서 1:입금, 2:출금, 3:종료
		// 입금일 경우: 입금액을 입력하세요... account 누적.
		// 출금일 경우: 출금액을 입력하세요... account 차감.
		// 종료일 경우: 프로그램 종료.
		
		int account = 0;
		int menu = 0;
		Scanner scn = new Scanner(System.in);
		
		while( true ) {
			System.out.println("1:입금, 2:출금, 3:종료");
			menu = scn.nextInt();
			
			if(menu == 1) {
				System.out.println("1.입금 금액 입력..");
				account += scn.nextInt();
				System.out.println("계좌 잔액 :"+account);
			} else if (menu == 2) {
				System.out.println("2.출금 금액 입력..");
				int amt = scn.nextInt(); 
				if (amt > account) {
					System.out.println("출금 금액이 잔액보다 큽니다.");
					System.out.println("계좌 잔액 :"+account);
					continue; // 구문 아래를 무시하고 다음 순번으로 넘어감.					
				}
				// 정상 출금..
				account -= amt; 
				System.out.println("계좌 잔액 :"+account);
			} else if(menu == 3) {
				System.out.println("프로그램 종료.");
				scn.close();
				break;
			} else {
				System.out.println("잘못된 입력.");
			}
		}
		
		System.out.println("end of program");
	}
}
