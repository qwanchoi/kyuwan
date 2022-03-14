package com.edu;

import java.util.Scanner;

public class RectangleExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int xLength, yLength, area;
		
		System.out.println("가로 길이: ");
		xLength = scn.nextInt();
		
		System.out.println("세로 길이: ");
		yLength = scn.nextInt();
		
		area = xLength * yLength;
		System.out.println("계산(너비) 결과: "+area);
		
		scn.close();
	}
}
