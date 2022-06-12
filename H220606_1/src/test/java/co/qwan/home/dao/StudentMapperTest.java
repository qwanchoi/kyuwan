package co.qwan.home.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import co.qwan.home.student.dao.StudentMapper;
import co.qwan.home.student.vo.StudentVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/dataSource-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class StudentMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private StudentMapper mapper;
	
	@Test
	public void getAdminTest() {
		StudentVO admin = new StudentVO();
		admin.setUsername("admin95");
		StudentVO vo = mapper.getOne(admin);
		log.info(vo.getName());
		vo.getAuthList().forEach(authVO -> {
			log.info(authVO);
			log.info(authVO.getRolename());
		});
	}
}
