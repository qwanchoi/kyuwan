package com.prod;

public class ArrayExample7 {
	public static void main(String[] args) {
		int num1 = 15;
		int num2 = 20;

		int temp = num1;

		num1 = num2;
		num2 = temp;

		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);

//		int[] numbers = { 15, 20 };
		int[] numbers = new int[2];
		numbers[0] = 15;
		numbers[1] = 15;
		
		temp = numbers[0];
		numbers[0] = numbers[1];
		numbers[1] = temp;

		System.out.println("바뀐 첫번째 : " + numbers[0]);
		System.out.println("바뀐 두번재 : " + numbers[1]);

	}
}
