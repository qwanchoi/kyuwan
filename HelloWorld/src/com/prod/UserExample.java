package com.prod;

public class UserExample {
	public static void main(String[] args) {
		User[] users = new User[5];
		
		users[0] = new User();
		users[0].setName("blue");
		users[0].setGrade("A");
		users[0].setPhone("010-3614-9414");
		users[0].setPoint(50000);
		
		users[1] = new User();
		users[1].setName("storm");
		users[1].setGrade("A");
		users[1].setPhone("011-3614-9414");
		users[1].setPoint(2000);
		
		users[2] = new User();
		users[2].setName("red");
		users[2].setGrade("C");
		users[2].setPhone("012-3614-9414");
		users[2].setPoint(900);
		
		users[3] = new User();
		users[3].setName("green");
		users[3].setGrade("C");
		users[3].setPhone("013-3614-9414");
		users[3].setPoint(4000);
		
		users[4] = new User();
		users[4].setName("white");
		users[4].setGrade("A");
		users[4].setPhone("014-3614-9414");
		users[4].setPoint(2400);
		
		for(int i=0; i < users.length; i++) {
			if(users[i].getGrade() == "A" && users[i].getPoint() >= 1000) {
				System.out.println(users[i].getUserInfo());
			}
		}
	}
}
