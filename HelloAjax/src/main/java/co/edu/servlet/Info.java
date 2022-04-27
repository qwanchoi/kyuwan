package co.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Info  extends HttpServlet{
    
    // Info 페이지 요청 -> Init() -> Service() -> Destroy()
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/html;charset=UTF-8");
	
	PrintWriter out = resp.getWriter();
	
	out.print("<h3>서블릿 페이지</h3>");
	out.print("<h3>안녕하세요</h3>");
	out.print("<a href=\"../index.html\">index</a>");
    }
}
