package com.prod.emp;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmpExe {
    public static void main(String[] args) {
	Scanner scn = new Scanner(System.in);
	
	EmpDAO dao = new EmpDAO();
	
	// 메뉴: 1.리스트 2.입력 3.수정 4.삭제 5.한건조회 9.종료
	while(true) {
	    System.out.println("1.리스트 2.입력 3.수정 4.삭제 5.한건조회 9.종료");
	    System.out.print("메뉴선택>> ");
	    
	    int menu = scn.nextInt();
	    if(menu == 1) { //리스트.
		List<Employee> list = dao.empList(); // 전체조회기능.

		for (Employee emp : list) {
		    System.out.println(emp.toString());
		}
	    } else if(menu == 2) { //입력.
		// 사원번호, lastName, email, hireDate, jobId
//		Employee emp = new Employee();
		Employee emp = null;
		try {
		    System.out.print("사원번호 >>");
		    int empId = scn.nextInt();
//		    emp.setEmployeeId(scn.nextInt());
		    System.out.print("이름 >>");
		    String lastName = scn.next();
//		    emp.setLastName(scn.next());
		    System.out.print("이메일 >>");
		    String email = scn.next();
//		    emp.setEmail(scn.next());
		    System.out.print("입사일 >>");
		    String hireDate = scn.next();
//		    emp.setHireDate(scn.next());
		    System.out.print("업무코드 >>");
		    String jobId = scn.next();
//		    emp.setJobId(scn.next());
		    emp = new Employee(empId, lastName, email, hireDate, jobId);
		} catch (InputMismatchException e) {
		    System.out.println("!!!잘못된 입력!!!");
		    scn.next();
		    continue;
		}
		boolean tOrF = dao.insertEmp(emp); // boolean 타입으로 결과값을 받음
		if(tOrF) {
		    System.out.println("사원입력 정상");
		} else {
		    System.out.println("!! 사원입력 오류 !!");
		}
	    } else if(menu == 3) { // 수정
		// 사원번호, 전화번호, firstName, salary
		
//		Employee emp = new Employee();
		Employee emp = null;
		// 생성자, set메소드.
		try {
		    System.out.print("수정할 사원번호 >>");
//		    emp.setEmployeeId(scn.nextInt());
		    int empNo = scn.nextInt();
		    System.out.print("전화번호 >>");
//		    emp.setPhoneNumber(scn.next());
		    String phoneNum = scn.next();
		    System.out.print("이름 >>");
//		    emp.setFirstName(scn.next());
		    String firstName = scn.next();
		    System.out.print("급여 >>");
//		    emp.setSalary(scn.nextInt());
		    int salary = scn.nextInt();
		    
		    if ( dao.searchEmp(empNo) == null ) {
			System.out.println("!!! 없는 사원번호!!!");
			continue;
		    }
		    emp = new Employee(empNo, phoneNum, firstName, salary);
		} catch (InputMismatchException e) {
		    System.out.println("!!!잘못된 입력!!!");
		    scn.next();
		    continue;
		}
		if ( dao.updateEmp(emp) ) {
		    System.out.println("정상적으로 처리.");
		} else {
		    System.out.println("정상처리 안됐습니다.");
		}
	    } else if(menu == 4) { // 삭제
		// 삭제할 사원번호
		try {
		    System.out.print("삭제할 사원번호 >>");
		    int empNumber = scn.nextInt();
		    dao.deleteEmp(empNumber);
		} catch (InputMismatchException e) {
		    System.out.println("!!!잘못된 입력!!!");
		    scn.next();
		    continue;
		}
	    } else if(menu == 5) { // 조회
		//
		Employee emp = null;
		try {
		    System.out.print("조회할 사원번호 >>");
		    int empNum = scn.nextInt();
		    emp = dao.searchEmp(empNum);
		    if (emp != null) 		
			System.out.println(emp.toString());
		    else 
			System.out.println("!!!없는 사원 번호!!!");
		    
		}  catch (InputMismatchException e) {
		    System.out.println("!!!잘못된 입력!!!");
		    scn.next();
		    continue;
		}
	    } else if(menu == 9) { // 종료
		System.out.println("프로그램을 종료합니다.");
		break;
	    } else { // 없는 메뉴
		System.out.println("!!!없는 메뉴 번호 입니다!!!");
	    }
	} // end of while
	
	System.out.println("end of program...");
	scn.close();
	
    } // end of main
}
