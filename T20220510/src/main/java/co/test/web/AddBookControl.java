package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class AddBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    
	    String title = request.getParameter("title");
	    String author = request.getParameter("author");
	    String press = request.getParameter("press");
	    int price = Integer.parseInt(request.getParameter("price"));
	    
	    BookVO book = new BookVO();
	    book.setBookTitle(title);
	    book.setBookAuthor(author);
	    book.setBookPress(press);
	    book.setBookPrice(price);
	    
	    BookService service = new BookService();
	    service.addBook(book);
	    
	    request.getRequestDispatcher("result/addOutput.jsp").forward(request, response);
	}

}
