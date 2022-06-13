package co.qwan.home.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import co.qwan.home.student.vo.StudentVO;
import lombok.Getter;

@Getter
public class CustomUser extends User {
	private static final long serialVersionUID = 1L;
	
	private StudentVO student;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CustomUser(StudentVO vo) {
		super(vo.getUsername(), vo.getPassword(), 
				vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getRolename()))
				.collect(Collectors.toList()));
		this.student = vo;
	}

}
