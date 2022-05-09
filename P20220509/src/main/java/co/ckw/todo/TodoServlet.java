package co.ckw.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		TodoDAO dao = new TodoDAO();
		List<TodoVO> list = dao.getList();
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=UTF-8");
		String job = request.getParameter("job");
		
		TodoDAO dao = new TodoDAO();
		
		if(job.equals("insert")) {
			String content = request.getParameter("content");
			
			int idx = dao.insertTodo(content);
			response.getWriter().print(idx);
		} else if (job.equals("update")) {
			TodoVO vo = new TodoVO();
			vo.setIdx(Integer.parseInt(request.getParameter("idx")));
			vo.setContent(request.getParameter("content"));
			vo.setChecked(Integer.parseInt(request.getParameter("check")));
			boolean flag = dao.updateTodo(vo);
			
			response.getWriter().print(flag);
		} else if (job.equals("delete")) {
			String idxStr = request.getParameter("idx");
			int idx = Integer.parseInt(idxStr);
			boolean flag = dao.deleteTodo(idx);
			
			response.getWriter().print(flag);
		}
	}

}
