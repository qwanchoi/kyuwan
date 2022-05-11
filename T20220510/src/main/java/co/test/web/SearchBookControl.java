package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class SearchBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("UTF-8");
	    	
		String path = "result/searchOutput.jsp";

		String bookCode = request.getParameter("bookCode");
		String job = request.getParameter("job");
		
		BookService service = null;
		BookVO book = null;

		// 조회 도서코드가 없을 경우 결과를 보여주는 페이지 지정.
		if (job.equals("search")) {
			path = "view/search.jsp";
		} else if (job.equals("modify")) {
			path = "view/modify.jsp";
		} else if (job.equals("remove")) {
			path = "view/remove.jsp";
		} else {
		    request.setAttribute("error", "잘못된 입력.");
		    request.getRequestDispatcher(path).forward(request, response);
		    return;
		}

		if (bookCode.isBlank()) {
		    request.setAttribute("error", "도서코드를 입력하세요.");
		    request.getRequestDispatcher(path).forward(request, response);
		    return;
		}
		
		service = new BookService();
		book = service.findBook(bookCode);
		request.setAttribute("book", book);

		// 정상적인 처리가 진행될 경우 페이지 지정.
		if (job.equals("search")) {
		    path = "result/searchOutput.jsp";
		    request.getRequestDispatcher(path).forward(request, response);
		} else if(job.equals("remove") || job.equals("modify")) {
		    Gson gson = new GsonBuilder().create();
		    response.setCharacterEncoding("UTF-8");
		    response.setContentType("text/json;charset=UTF-8");
		    response.getWriter().print(gson.toJson(book));
		}

	}

}
