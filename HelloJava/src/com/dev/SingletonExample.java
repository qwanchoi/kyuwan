package com.dev;

public class SingletonExample {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance(); // new Singleton();
		Singleton s2 = Singleton.getInstance(); // new Singleton()
		
		System.out.println(s1 == s2);
		System.out.println(s2);
	}
}
