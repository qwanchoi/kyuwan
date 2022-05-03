package co.dev.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberListControl implements Control {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	MemberService service = new MemberService();
	List<MemberVO> list = service.memberList();
	
	request.setAttribute("all", list);
	
	request.getRequestDispatcher("memberResult/memberListOutput.jsp").forward(request, response);
    }

}
