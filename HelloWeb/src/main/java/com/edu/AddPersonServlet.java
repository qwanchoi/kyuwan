package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPersonServlet
 */
@WebServlet("/addPersonServlet")
public class AddPersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public AddPersonServlet() {
        super();
    }
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
//	doGet(request, response);
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	
	String id = request.getParameter("uid"); // 
	String name = request.getParameter("uname"); //
	String score = request.getParameter("uscore");
	String age = request.getParameter("uage");

	System.out.println("아이디: " + id);
	System.out.println("이름: " + name);
	System.out.println("점수: " + score);
	System.out.println("나이: " + age);
	
	PrintWriter out = response.getWriter(); // InputStream, OutputStream, Reader, Writer;

	out.println("<h3>응답결과</h3>");
	out.println("<h4>아이디: "+ id + "</h4>");
	out.println("<h4>이름: "+ name + "</h4>");
	out.println("<h4>점수: "+ score + "</h4>");
	out.println("<h4>나이: "+ age + "</h4>");
    }

}
