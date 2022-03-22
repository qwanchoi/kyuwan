package com.edu.api;

import java.util.ArrayList;

public class WrapperExample {
    public static void main(String[] args) {
	
	// 기본타입(int, long, double, boolean...)
	// 참조타입(Integer, Long, Double, Boolean...)
	// int -> Integer (boxing), Integer -> int (unboxing)
	ArrayList<Integer> ary = new ArrayList<Integer>();
	ary.add(100);
	ary.add(new Integer(200)); // Deprecated. 향후 자바에서 제거할 예정.
	
	new Integer(100).floatValue(); // 100.0
	
    }
}
