package com.edu.interfaces;

public class Computer implements RemoteControl {
    private String cpu;
    private String memory;
    
    @Override
    public void powerOn() {
	System.out.println("컴퓨터를 켭니다.");
    }

    @Override
    public void powerOff() {
	System.out.println("컴퓨터를 끕니다.");
    }
    
}
