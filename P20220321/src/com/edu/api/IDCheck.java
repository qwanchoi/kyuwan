package com.edu.api;

public class IDCheck {
    // 주민번호 입력 -> 950304-1234567, 000205-4567890
    // 950304-1234567, 950304 1234567, 9503041234567
    /// 남 녀 췍~
    
    // String getGender() -> 남, 여.
    public String getGender(String inputSSN) {
	String ssn = inputSSN.trim(); // 앞뒤공백제거
	ssn = ssn.replace("-", "");
	ssn = ssn.replace(" ", "");
//	System.out.println(ssn);
	char genderNum = ssn.charAt(6);
	String result = "";
	switch (genderNum) {
	case '1':
	case '3':
	    result = "남자";
	    break;
	case '2':
	case '4':
	    result = "여자";
	    break;
	default:
	    result = "없음";
	    break;
	}
	
	return result;
    }
}
