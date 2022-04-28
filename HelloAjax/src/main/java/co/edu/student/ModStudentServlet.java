package co.edu.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModStudentServlet
 */
@WebServlet("/ajax/modStudentServlet")
public class ModStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/html;charset=utf-8");
	
	String studentNo = req.getParameter("sno");
	String studentName = req.getParameter("sname");
	String engScore = req.getParameter("eScore");
	String korScore = req.getParameter("kScore");

	Student std = new Student();
	std.setStudentNo(Integer.parseInt(studentNo));
	std.setStudentName(studentName);
	std.setEngScore(Integer.parseInt(engScore));
	std.setKorScore(Integer.parseInt(korScore));
	
	StudentDAO dao = new StudentDAO();
	boolean success = dao.modifyStudent(std);
	
	if(success) {
	    // {"retCode":"OK", "studentNo": ?, "studentName": "?", "engScore":?, "korScore":?} 
	    resp.getWriter().println("{\"retCode\":\"OK\", \"studentNo\": "+std.getStudentNo()+", \"studentName\": \""+std.getStudentName()+"\", \"engScore\":"+std.getEngScore()+", \"korScore\":"+std.getKorScore()+"}");
	} else {
	    // {"retCode":"NG"}
	    resp.getWriter().println("{\"retCode\":\"NG\"}");
	}
    }
}
