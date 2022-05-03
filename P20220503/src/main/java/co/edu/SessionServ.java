package co.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session.do")
public class SessionServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionServ() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pass");
	
	HttpSession session = null;
	
	session = request.getSession();
	session.setAttribute("id", id);
	session.setAttribute("pass", pw);
	
	response.sendRedirect("session2.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	
    }

}
