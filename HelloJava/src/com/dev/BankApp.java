package com.dev;

import java.util.Scanner;

// BankApp(main method), Account(계좌번호, 예금주, 잔액)
public class BankApp {
	static Account[] banks = new Account[100];
	static Scanner scn = new Scanner(System.in);
	
	// 메뉴: 1. 계좌생성)(번호, 예금주, 에금액)
	//		2. 에금(번호, 예금액) -> 최고예금액 10만원.
	//		3. 출금(번호, 출금액) -> 잔액보다 큰 금액 출금 못하도록.
	//		4. 잔액조회(번호)
	//		5. 종료.
	
	public static void main(String[] args) {
		while(true) {			
			printMenu();
			int menu = scn.nextInt();
			if(menu == 1) {
				createAccount();
				// 게좌생성
			} else if(menu == 2) {
				deposit();
			} else if (menu == 3) {
				withdraw();
			} else if (menu == 4) {
				findAccountMoney();
			} else if (menu == 5) {
				transferAmount();
			} else if (menu == 6) {
				break;
			} else if (menu == 9) {
				showList();
			}
		}
		System.out.println("=== End of Prog ===");
	} // end of main()
	
	// 메뉴출력 기능.
	public static void printMenu() {
		String menu = "======================================== \n"
				+"1. 계좌생성 (번호, 에금주, 예금액) \n"
				+ "2. 에금(번호, 예금액) -> 최고예금액 10만원. \n"
				+ "3. 출금 (번호, 출금액) \n"
				+ "4. 잔액조회 (번호) \n"
				+ "5. 송금(송금번호, 금액, 입금번호)"
				+ "6. 종료 \n"
				+ "======================================== \n"
				+ "선택> ";
		System.out.print(menu);
	}
	
	// 계좌생성 메소드.
	public static void createAccount() {
		System.out.println("계좌생성기능.");
		String accNo;
		while(true) {
			System.out.print("계좌번호입력>> ");
			accNo = scn.next();
			
			// 계좌번호 있는지 체크.
			if(searchAccountNo(accNo) != null) {
				System.out.println("이미 있는 계좌번호 입니다.");
			} else {
				break;
			}
		}
		System.out.print("예금주입력>> ");
		String accName = scn.next();
		System.out.print("예금액입력>> ");
		int accMoney = scn.nextInt();
		
		
		Account accnt = new Account(accNo, accName, accMoney);
		
		for(int i = 0; i < banks.length; i++) {
			if(banks[i] == null) {
				banks[i] = accnt;
				break;
			}
		}
		
	}
	// 예금 메소드
	public static void deposit() {
		System.out.println("==[예금기능]==");
		
		String ano;
		Account acc = null;
		while(true) {
			System.out.print("계좌번호 >> ");
			ano = scn.next();
			
			// 계좌번호 있는지 체크.
			acc = searchAccountNo(ano);
			
			if(acc == null) {
				System.out.println("없는 계좌번호 입니다.");
				continue;
			}
			
			break;
		}
		
		while(true) {
			System.out.print("예금액 입력 >> ");
			int amt = scn.nextInt();
			int currAmt = acc.getMoney();
			if(currAmt + amt > 100000) {
				System.out.println("한도 금액을 초과했습니다.");
				continue;
			}
			acc.setMoney(currAmt + amt);
			break;
		}
	}
	// 출금 메소드.
	public static void withdraw() {
		System.out.println("[출금기능]");
		String ano;
		Account acc = null;
		while(true) {
			System.out.print("계좌번호>> ");
			ano = scn.next();
			acc = searchAccountNo(ano);
			if ( acc == null) {
				System.out.println("* 없는 계좌 입니다.");
			} else {
				break;
			}
		}
		
		while(true) {
			System.out.println("출금액 입력 >> ");
			
			int amt = scn.nextInt();
			int currAmt = acc.getMoney();
			if(currAmt - amt < 0) {
				System.out.println("* 잔액이 부족합니다.");
			} else {
				acc.setMoney(currAmt - amt);
				break;
			}
		}
		
		System.out.println("* 정상적으로 처리되었습니다.");
	}
	// 잔액조회 메소드.
	public static void findAccountMoney() {
		System.out.println("[조회기능]");
		
		Account acc = null;
		String ano;
		while(true) {
			System.out.print("계좌번호>> ");
			ano = scn.next();
			acc = searchAccountNo(ano);
			
			if(acc == null) {
				System.out.println("* 없는 계좌 입니다.");
			} else {
				break;
			}
		}
		System.out.println(acc.toString());
		

	}
	// 전체리스트 출력.
	public static void showList() {
		for(int i = 0; i < banks.length; i++) {
			if(banks[i] != null) {
				System.out.println(banks[i].toString());
			}
		}
	}
	
	// 계좌번호를 입력하면 배열(banks)에서 그 계좌를 반환 없으면 null
	public static Account searchAccountNo(String accNo) {
		for (int i = 0; i < banks.length; i++) {
			if(banks[i] != null && banks[i].getAccNo().equals(accNo)) {
				return banks[i];
			}
		}
		return null; // 클래스 -> null(Student, Car)
	}
	
	public static void transferAmount() {
		System.out.println("[송금기능]");
		
		System.out.print("송금 계좌번호 >>");
		String myAccNo = scn.next();
		Account myAcc = searchAccountNo(myAccNo);
		System.out.print("송금할 금액 >>");
		int amount = scn.nextInt();
		System.out.print("입금 계좌번호 >>");
		String tarAccNo = scn.next();
		Account targetAcc = searchAccountNo(tarAccNo);
		int countNum = 0;
		
		if( myAcc == null ) {
			System.out.println("* 없는 송금 계좌 입니다.");
			return;
		}
		if( targetAcc == null ) {
			System.out.println("* 없는 입금 계좌 입니다.");
			return;
		}
		
		int myCurAmount = myAcc.getMoney();
		int tarCurAmount = targetAcc.getMoney();
		
		if( myCurAmount - amount < 0 ) {
			countNum = 1; // 잔액부족
		} else if( tarCurAmount + amount > 100000 ){
			countNum = 2;
		}
		
		if (countNum == 0) {
			myAcc.setMoney(myCurAmount - amount);
			targetAcc.setMoney(tarCurAmount + amount);
			System.out.println("* 정상처리 되었습니다.");
		} else if ( countNum == 1) {
			System.out.println("* 송금할 계좌의 잔액이 부족합니다.");
		} else if( countNum == 2) {
			System.out.println("* 받을 계좌의 예금한계가 초과했습니다.");
		}
		
	}
	
}
