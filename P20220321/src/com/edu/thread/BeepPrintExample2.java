package com.edu.thread;

import java.awt.Toolkit;

class BeepThread extends Thread {
    @Override
    public void run() {
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	for (int i = 0; i < 5; i++) {
	    toolkit.beep();
	    System.out.println("((sound))");
	    try {
		Thread.sleep(300);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }
}

public class BeepPrintExample2 {
    public static void main(String[] args) {
	// 비프음..생성
	// Thread클래스를 상속받는 클래스를 선언. run메소드를 override 기능구현.
	Thread thread = new BeepThread();
	thread.start();
	
	// 비프 출력.
	for (int i = 0; i < 5; i++) {
	    System.out.println("beep");
	    try {
		Thread.sleep(300);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
}
