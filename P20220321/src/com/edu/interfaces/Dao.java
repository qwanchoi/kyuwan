package com.edu.interfaces;

public interface Dao extends RemoteControl, Run{
    // 인터페이스는 클래스와 다르게 다중상속 가능
    public void select();
    public void insert();
    public void update();
    public void delete();
}
