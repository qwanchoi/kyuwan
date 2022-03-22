package com.edu.interfaces;

public interface RemoteControl {
    // ㄴ 인터페이스를 사용한 클래스 : 구현 클래스, 구현 객체
    // 필드 불가.
    // private String maxVolume;
    
    public static final int MAX_VOLUME = 10; // 상수로 선언. 
    public static final int MIN_VOLUME = 0; // 상수로 선언.
    // 생성자 불가.
    
    public void powerOn(); // 추상메소드.
    public void powerOff(); // 추상메소드.
    
}
