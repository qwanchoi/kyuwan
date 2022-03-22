package com.edu.interfaces;

public class MYSqlDao implements Dao {

    @Override
    public void select() {
	System.out.println("MySQLDB에서 조회힙니다.");
    }

    @Override
    public void insert() {
	System.out.println("MySQLDB에서 입력합니다.");
    }

    @Override
    public void update() {
	System.out.println("MySQLDB에서 수정합니다.");
    }

    @Override
    public void delete() {
	System.out.println("MySQLDB에서 삭제합니다.");
    }

    @Override
    public void powerOn() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void powerOff() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void start() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void end() {
	// TODO Auto-generated method stub
	
    }
    
}
