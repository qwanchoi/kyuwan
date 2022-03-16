package com.prod;

public class FriendExample {
	public static void main(String[] args) {
		// 친구의 정보(이름, 전화번호, 이메일, 키, 몸무게)
		Friend f1 = new Friend();
		f1.name = "최규완";
		f1.phone = "010-3614-9414";
		f1.email = "rbdhks2002@gmail.com";
		f1.height = 177.7;
		f1.weight = 82.5;

		Friend f2 = new Friend();
		f2.name = "완규최";
		f2.phone = "011-3614-9414";
		f2.email = "chlrbdhks92@gmail.com";
		f2.height = 184.1;
		f2.weight = 80.5;

		Friend f3 = new Friend();
		f3.name = "최완규";
		f3.phone = "012-3614-9414";
		f3.email = "rbdhks2002@naver.com";
		f3.height = 167.5;
		f3.weight = 79.8;

		System.out.println(f1);

		Friend[] friends = { f1, f2, f3 };

		for (int i = 0; i < friends.length; i++) {
			if(friends[i].height < 170) {				
				System.out.println("이름: " + friends[i].name);
				System.out.println("전화번호: "+ friends[i].phone);
				System.out.println("키: "+ friends[i].height);
				System.out.println("==============================");
			}
		}

		System.out.println("end of prog");
	}
}
