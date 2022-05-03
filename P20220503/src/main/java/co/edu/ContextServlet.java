package co.edu;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextServlet
 */
@WebServlet("/ContextServlet")
public class ContextServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ServletContext sc = null; // sc (servlet에서) => application (jsp에서)
    
    public ContextServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
	sc = config.getServletContext(); // 프로젝트 정보?
	sc.setAttribute("name", "Hong");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	
    }

}
