package home.prod.emp;

import java.util.List;

public class EmpExe {
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		List<Employee> list = dao.empList();
		
		for(Employee emp : list) {
			System.out.println(emp.toString());
		}
	}
}
