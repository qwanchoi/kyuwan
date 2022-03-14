package com.edu;

import java.util.Scanner;

public class CashExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// 2개 값을 입력.
		int price, cash;
		int change;
		double tax;
		
		// 가격을 입력하세요...
		System.out.println("가격을 입력하세요...");
		price = scn.nextInt(); // 5500원은 10%가 포함된 금액
		
		// 손님이 낸 금액
		System.out.println("손님이 낸 금액...");
		cash = scn.nextInt();
		
		// 하나는 상품의 부가세, 하나는 거스름돈
		tax = (price/110.0)*10;
		change = cash - price;
		System.out.println("부가세: "+tax+"원 /거스름돈: "+change+"원");
		
		scn.close();
	}
}
