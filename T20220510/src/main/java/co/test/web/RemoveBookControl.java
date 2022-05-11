package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;

public class RemoveBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    BookService service = new BookService();
	    String code = (String) request.getParameter("rBookCode");
	    service.removeBook(code);
	    
	    request.getRequestDispatcher("result/removeOutput.jsp").forward(request, response);
	}

}
