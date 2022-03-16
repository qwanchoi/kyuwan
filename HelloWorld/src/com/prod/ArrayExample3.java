package com.prod;

public class ArrayExample3 {
	public static void main(String[] args) {
		String[] names = new String[5];

		names[0] = "홍길동";
		names[1] = "234";
		names[2] = "최규완";
		names[3] = "푸른폭풍";

		names[1] = "1강의실";
		names[4] = "CHOI";

		names[0] = null;
		String searchName = "최규완";

		for (int i = 0; i < 5; i++) {
//			if(names[i] != null) {				
//				System.out.println("이름: "+names[i]);
//			}

			if (names[i] != null && names[i].equals(searchName)) {
				System.out.println( i+1 +"번째 위치에 있습니다.");
			}
		}
	}
}
