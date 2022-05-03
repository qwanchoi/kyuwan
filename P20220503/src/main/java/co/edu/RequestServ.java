package co.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request1.do")
public class RequestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestServ() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	
	request.setAttribute("id", id);
	request.setAttribute("name", name);
	
	StudentDAO dao = new StudentDAO();
	Student result = dao.searchStudent(id);
	
	request.setAttribute("result", result);
	
	// response.jsp
	request.getRequestDispatcher("response.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	
    }
    
}
