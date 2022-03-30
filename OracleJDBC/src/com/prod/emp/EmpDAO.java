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
	    while (rs.next()) {
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
    } // end of list

    // 한건조회
    public Employee searchEmp(int empNumber) {
	conn = getConnect();
	String sql = "SELECT * " 
		+ "FROM emp_java " 
		+ "WHERE employee_id = ?";
	Employee emp = null;
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setInt(1, empNumber);

	    rs = psmt.executeQuery();
	    while (rs.next()) {
		emp = new Employee();
		emp.setEmployeeId(rs.getInt("employee_id")); // employees.employee_id
		emp.setFirstName(rs.getString("first_name"));
		emp.setLastName(rs.getString("last_name"));
		emp.setEmail(rs.getString("email"));
		emp.setSalary(rs.getInt("salary"));
		emp.setHireDate(rs.getString("hire_date").substring(0, 10));
		emp.setJobId(rs.getString("job_id"));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	return emp;
    }

    // 입력처리 executeUpdate()
    public void insertEmp(Employee emp) {
	conn = getConnect();
	String sql = "insert into emp_java " + "(employee_id, last_name, email, hire_date, job_id)"
		+ "values(?, ?, ?, ?, ?)";
	try {
	    psmt = conn.prepareStatement(sql); // ? <= 매개변수중에서 employeeId 필드값.
	    psmt.setInt(1, emp.getEmployeeId());
	    psmt.setString(2, emp.getLastName());
	    psmt.setString(3, emp.getEmail());
	    psmt.setString(4, emp.getHireDate());
	    psmt.setString(5, emp.getJobId());
	    int r = psmt.executeUpdate(); // 실행된 건수 반환.
	    System.out.println(r + "건 입력됨.");

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    // 정상실행, 예외발생 => 반드시 실행코드.
	    disconnect();
	}
    } // end of update

    // 수정처리
    public void updateEmp(Employee emp) {
	conn = getConnect();
	String sql = "update emp_java " + "set first_name = ?, " + "phone_number=?, " + "salary = ? "
		+ "where employee_id = ?";
	try {
	    psmt = conn.prepareStatement(sql);
	    // 파라미터(?) 값을 지정.
	    psmt.setString(1, emp.getFirstName());
	    psmt.setString(2, emp.getPhoneNumber());
	    psmt.setInt(3, emp.getSalary());
	    psmt.setInt(4, emp.getEmployeeId());

	    int r = psmt.executeUpdate();
	    System.out.println(r + "건 수정됨.");
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}

    } // end of update

    // 삭제처리
    public void deleteEmp(int empId) {
	conn = getConnect();
	String sql = "delete from emp_java" + "where employee_id = ?";
	try {
	    psmt = conn.prepareStatement(sql);
	    // 파라미터('?') 값을 지정.
	    psmt.setInt(1, empId);

	    int r = psmt.executeUpdate();
	    System.out.println(r + "건 삭제됨.");
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
    }
}
