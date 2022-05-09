package co.edu.full;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/FullCalendarServlet")
public class FullCalendarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public FullCalendarServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 전체조회.
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/json;charset=UTF-8");
	
	FullDAO dao = new FullDAO();
	List<FullVO> list = dao.getList();
	
	Gson gson = new GsonBuilder().create();
	response.getWriter().print(gson.toJson(list)); // json 타입 생성.
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 입력, 삭제.
	request.setCharacterEncoding("UTF-8");
	
	String job = request.getParameter("job");
	
	FullDAO dao = new FullDAO();
	
	if(job.equals("insert")) { // 삽입
	    String title = request.getParameter("title");
	    String start = request.getParameter("start");
	    String end = request.getParameter("end");
	    
	    FullVO vo = new FullVO(title, start, end);
	    dao.insertSchedule(vo);
	} else if(job.equals("delete")) { // 삭제
	    String title = request.getParameter("title");
	    dao.deleteSchedule(title);
	}
	
    }

}
