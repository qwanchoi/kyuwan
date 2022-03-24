package com.edu.lambda;

interface Runnable2 {
    public void run(String animal);
}

public class RunExample2 {
    public static void main(String[] args) {
	Runnable2 runnable = (String animal) -> {
		System.out.println(animal + "이(가) 달립니다.");
	};
	runnable.run("호랑이");
    }
}
