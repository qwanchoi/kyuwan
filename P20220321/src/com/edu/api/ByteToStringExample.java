package com.edu.api;

public class ByteToStringExample {
	public static void main(String[] args) {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };
		
		// 배열 전체를 String 객체로 생성
		String str1 = new String(bytes);
		// 지정한 문자셋으로 디코딩
		System.out.println(str1);
		
		// 배열의 offset 인덱스 위치부터 length 만큼 String 객체로 생성
		String str2 = new String(bytes, 6, 4);
		// 지정한 문자셋으로 디코딩
		System.out.println(str2);
	}
}
