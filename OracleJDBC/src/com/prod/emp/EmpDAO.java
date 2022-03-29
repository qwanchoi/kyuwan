package com.prod.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {
    
    
    // 전체조회
    public List<Employee> empList() {
	List<Employee> employees = new ArrayList<Employee>();
	conn = getConnect();
	try {
	    psmt = conn.prepareStatement("select * from emp_java");
	    rs = psmt.executeQuery();
	    while(rs.next()) {
		Employee emp = new Employee();
		emp.setEmployeeId(rs.getInt("employee_id")); // employees.employee_id
		emp.setFirstName(rs.getString("first_name"));
		emp.setLastName(rs.getString("last_name"));
		emp.setEmail(rs.getString("email"));
		emp.setSalary(rs.getInt("salary"));
		emp.setHireDate(rs.getString("hire_date").substring(0, 10));
		emp.setJobId(rs.getString("job_id"));
		
		employees.add(emp);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	return employees;
    }
    // 한건조회
    
    // 입력처리
    
    // 수정처리
    
    // 삭제처리
    
    
}
