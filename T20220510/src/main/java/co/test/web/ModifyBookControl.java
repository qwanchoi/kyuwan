package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class ModifyBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    BookVO vo = new BookVO();
	    vo.setBookCode(request.getParameter("code"));
	    vo.setBookCode(request.getParameter("title"));
	    vo.setBookCode(request.getParameter("author"));
	    vo.setBookCode(request.getParameter("press"));
	    vo.setBookCode(request.getParameter("price"));
	    BookService service = new BookService();
	    service.modifyBook(vo);
	    
	    request.getRequestDispatcher("result/modifyOutput.jsp").forward(request, response);
	}

}
