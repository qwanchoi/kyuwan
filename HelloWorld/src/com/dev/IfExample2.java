package com.dev;

import java.util.Scanner;

public class IfExample2 {
	public static void main(String[] args) {
		// 물건가격이 50000원이상이면 배송비 0,
		// 보다 적으면 배송비가 3000원

		// 결제할 금액이 얼마인지 보여주는 코드

		Scanner scn = new Scanner(System.in);
		int price, totalPrice, shippingFee = 3000;

		System.out.println("물건 가격을 입력해 주세요...");
		price = scn.nextInt();

		if (price < 50000) {
			totalPrice = price + shippingFee;
		} else {
			totalPrice = price;
		}

		// 3항 연산자
		totalPrice = (price >= 50000) ? price : price + shippingFee;

		System.out.print("결제할 금액은 " + totalPrice + "입니다.");
		scn.close();
	}
}
