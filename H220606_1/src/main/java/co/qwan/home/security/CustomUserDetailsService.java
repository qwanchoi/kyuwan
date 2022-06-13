package co.qwan.home.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.qwan.home.student.dao.StudentMapper;
import co.qwan.home.student.vo.StudentVO;
import lombok.Setter;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Setter(onMethod_ = { @Autowired })
	private StudentMapper studentMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//log.warn("Load User By UserName : " + username);
		System.out.println("Load User By UserName : " + username);
		// userName means userid
		StudentVO p_vo = new StudentVO();
		p_vo.setUsername(username);
		StudentVO vo = studentMapper.getOne(p_vo);
		
		System.out.println("queried by studnet mapper: "+vo);
		return vo == null ? null : new CustomUser(vo);
		
	}

}
