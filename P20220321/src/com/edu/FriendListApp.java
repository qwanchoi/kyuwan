package com.edu;

public class FriendListApp {
	public static void main(String[] args) {
		Friend[] friends = new Friend[10];
		
		Friend f1 = new Friend();
		f1.setName("진휘용");
		f1.setAge(25);
		f1.setHeight(178.3);
		f1.setWeight(68.9);
		f1.setPhone("010-2323-9845");
		
		UnivFriend f2 = new UnivFriend("서현일", 29, 178.3, 69.2, "010-1111-2222");
		f2.setUniversity("대구대학교");
		f2.setMajor("컴퓨터공학과");
		
		ComFriend f3 = new ComFriend("최규완", 29, 179.3, 75.2, "010-1341-7349", "네이버", "지도app개발연구원");
		
		Friend f4 = new Friend();
		f4.setName("진휘드래곤");
		f4.setAge(300);
		f4.setHeight(378.3);
		f4.setWeight(3008.9);
		f4.setPhone("010-2323-9845");
		
		UnivFriend f5 = new UnivFriend("서현둘", 29, 172.2, 72.2, "010-1212-2222");
		f5.setUniversity("대구소학교");
		f5.setMajor("컴퓨터과학과");
		
		ComFriend f6 = new ComFriend("푸른폭풍", 20, 182.1, 82.2, "010-9999-9999", "나인킹스", "게임개발팀");
		
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		friends[3] = f4;
		friends[4] = f5;
		friends[5] = f6;
		
		for(int i=0; i < friends.length; i++) {
			if(friends[i] != null) {
//				System.out.println(friends[i].toString());
				if(friends[i] instanceof UnivFriend) {
					System.out.println(friends[i].toString()); // 동일하 ㄴ기능이지만 인스턴스종류에 따른 다른 결과 실행. => 다형성.
				}
			}
		}
		
		Friend friend = f2; // UnivFriend; getUniversity, getMajor
		// 자동 형변화 발생, (부모가 넓은 범위)
		//friend = f1;
		UnivFriend uni = null;
		if(friend instanceof UnivFriend) {// uni변수값이 UnivFriend의 인스턴스인지 확인 후
			uni = (UnivFriend) friend; // Casting 해야함. 
			System.out.println("인스턴스 확인 후: " + uni.getUniversity()); // 부모클래스의 참조변수 => 자식클래스의 참조변수 할당.
		}
		
		System.out.println("end of program..");
	
	}
	
	
}
