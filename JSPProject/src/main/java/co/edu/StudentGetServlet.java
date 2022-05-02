package co.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/StudentGetServlet")
public class StudentGetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public StudentGetServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
	// GET: cmd=search, cmd=null -> JSON 반환.
	response.setCharacterEncoding("UTF-8");
	
	String cmd = request.getParameter("cmd");
	System.out.println(cmd);
	
	if (cmd != null && cmd.equals("search")) {
	    String id = request.getParameter("user_id");
	    StudentDAO dao = new StudentDAO();
	    Student student = dao.searchStudent(id);
	    
	    response.setContentType("text/html;charset=UTF-8");
	    if(student != null) {
		response.getWriter().println("<form action='StudentGetServlet' method='POST'>");
		response.getWriter().println("<input type='hidden' name='cmd' value='modify'>");
		response.getWriter().println("<label name='user_id'>학생번호:</label> <input name='user_id' readonly value='" + student.getStudentNo() + "'><br>");
		response.getWriter().println("<label>이름:</label> <input name='user_name' readonly value='" + student.getStudentName() + "'><br>");
		response.getWriter().println("<label>영어: </label><input name='eng_score' type=text value='" + student.getEngScore() + "'><br>");
		response.getWriter().println("<label>국어: </label> <input name='kor_score' type=text value='" + student.getKorScore() + "'><br>");
		response.getWriter().println("<input type='submit' value='수정하기'></form>");
		response.getWriter().println("<a href='./studentList.jsp'>목록으로 이동</a>");
	    } else {
		response.getWriter().println("<h3>조회된 데이터가 없습니다.</h3>");
	    }
	} else {
	    
	    response.setContentType("text/json;charset=UTF-8");
	    StudentDAO dao = new StudentDAO();
	    List<Student> list = dao.studentList();
	    // [{}, {}, {}]
	    Gson gson = new GsonBuilder().create();
	    response.getWriter().print(gson.toJson(list));
	}
	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
	// 한글처리.
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");
	
	String cmd = request.getParameter("cmd");
	if(cmd != null && cmd.equals("add")) {
	    StudentDAO dao = new StudentDAO();
	    Student stud = new Student();
	    
	    String id = request.getParameter("user_id");
	    String name = request.getParameter("user_name");
	    String eng = request.getParameter("eng_score");
	    String kor = request.getParameter("kor_score");
	    
	    stud.setStudentNo(Integer.parseInt(id));
	    stud.setStudentName(name);
	    stud.setEngScore(Integer.parseInt(eng));
	    stud.setKorScore(Integer.parseInt(kor));
	    
	    if ( dao.addStudent(stud) ) {
		response.getWriter().print("입력성공");
	    } else {
		response.getWriter().print("입력실패");
	    }
	    
	} else if (cmd != null && cmd.equals("delete") ) {
	    StudentDAO dao = new StudentDAO();
	    String id = request.getParameter("user_id");
	    
	    if( dao.removeStudent(id)) {
		response.getWriter().print("<script>alert('삭제성공')</script>");
	    } else {
		response.getWriter().print("<script>alert('삭제실패')</script>");
	    }
	    
	} else if (cmd != null && cmd.equals("modify")) {
	    StudentDAO dao = new StudentDAO();
	    Student stud = new Student();
	    
	    String id = request.getParameter("user_id");
	    String name = request.getParameter("user_name");
	    String eng = request.getParameter("eng_score");
	    String kor = request.getParameter("kor_score");
	    
	    stud.setStudentNo(Integer.parseInt(id));
	    stud.setStudentName(name);
	    stud.setEngScore(Integer.parseInt(eng));
	    stud.setKorScore(Integer.parseInt(kor));
	    
	    dao.modifyStudent(stud);
	}
	
	response.sendRedirect("studentList.jsp");
    } // end of doPost();
}
