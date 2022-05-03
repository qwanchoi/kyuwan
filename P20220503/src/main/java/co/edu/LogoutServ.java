package co.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServ
 */
@WebServlet("/logout.do")
public class LogoutServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServ() {
        super();
    }
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	session.invalidate(); // 세션 삭제.
	response.sendRedirect("session.jsp");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	doGet(request, response);
    }

}
