package co.qwan.home.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/dataSource-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/security-context.xml"})
@Log4j
public class StudentTest {
	@Setter(onMethod_ = @Autowired)
	private CustomPasswordEncoder pwencoder;
	
	@Setter(onMethod_ = @Autowired)
	private BasicDataSource ds;
	
	@Test
	public void testInsertMember() {
		String sql = "INSERT INTO student_main (s_username, s_password, s_name) "
				+ "VALUES( ?, ?, ? )";
		
		for(int i = 0; i < 100; i++) {
			Connection conn = null;
			PreparedStatement psmt = null;
			
			try {
				conn = ds.getConnection();
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(2, pwencoder.encode("pw"+i) );
				if(i < 95) {
					psmt.setString(1, "user"+i);
					psmt.setString(3, "학생"+i);
				} else {
					psmt.setString(1, "admin"+i);
					psmt.setString(3, "관리자"+i);
				}
				psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(psmt != null) { try { psmt.close(); } catch (Exception e) { e.printStackTrace(); } }
				if(conn != null) { try { conn.close(); } catch (Exception e) { e.printStackTrace(); } }
			}
			
		} // end for
	} // end testInsertMember()
	
	@Test
	public void testInsertStudentRole() {
		String sql = "INSERT INTO student_role( username, rolename ) VALUES ( ?, ? )";
		
		for(int i = 0; i < 100; i++) {
			Connection conn = null;
			PreparedStatement psmt = null;
			
			try {
				conn = ds.getConnection();
				psmt = conn.prepareStatement(sql);
				
				if(i < 95) {
					psmt.setString(1, "user"+i);
					psmt.setString(2, "ROLE_USER");
				} else {
					psmt.setString(1, "admin"+i);
					psmt.setString(2, "ROLE_ADMIN");
				}
				psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(psmt != null) { try { psmt.close(); } catch (Exception e) { e.printStackTrace(); } }
				if(conn != null) { try { conn.close(); } catch (Exception e) { e.printStackTrace(); } }
			}
			
		} // end for
	} // end testInsertStudentRole()
	
}
