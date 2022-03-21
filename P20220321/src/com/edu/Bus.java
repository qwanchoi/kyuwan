package com.edu;

public class Bus extends Vehicle {
    
    public Bus() {
	super.setMaxSpeed(110);
    }

    @Override
    public void run() {
	System.out.println("Bus 가 달립니다.");
    }

    @Override
    public void stop() {
	System.out.println("Bus 가 멈춥니다.");
    }
    
    @Override
    public String toString() {
	return "버스의 최고속도는 "+this.getMaxSpeed()+ " 입니다.";
    }
}
