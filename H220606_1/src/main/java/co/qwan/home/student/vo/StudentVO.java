package co.qwan.home.student.vo;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO {
	private String username; // 로그인 정보
	private String password; // 로그인 정보
	private String name;
	private String enabled;
	private String phone;
	
	private Date joindate;
	private Date lastlogin;
	private List<AuthVO> authList;
}
