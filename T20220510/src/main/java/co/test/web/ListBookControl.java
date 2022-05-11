package co.test.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class ListBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookService service = new BookService();
		List<BookVO> list = service.bookList();

		request.setAttribute("list", list);
		
		request.getRequestDispatcher("result/listOutput.jsp").forward(request, response);

	}

}
