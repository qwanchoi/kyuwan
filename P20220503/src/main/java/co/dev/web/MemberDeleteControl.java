package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;

public class MemberDeleteControl implements Control {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	String id = request.getParameter("id");
	
	if(id.isEmpty()) {
	    request.setAttribute("error", "아이디를 검색해 주세요");
	    request.getRequestDispatcher("memberView/memberDelete.jsp").forward(request, response);
	    return;
	}
	
	MemberService service = new MemberService();
	service.memberDelete(id);
	request.setAttribute("id", id);
	
	request.getRequestDispatcher("memberResult/memberDeleteOutput.jsp").forward(request, response);
    }

}
