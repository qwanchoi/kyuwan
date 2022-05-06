package co.dev.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUploadServlet")
public class FileUploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadServ() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String title = request.getParameter("title"); // 멀티파트 타입이라 읽을 수 없음
	String content = request.getParameter("content");
	System.out.println("title: "+ title + ", content: "+ content); // null, null 출력
	
	String saveDir = "upload";
	saveDir = getServletContext().getRealPath(saveDir);
	int maxSize = 1024 * 1024 * 10; // 10MB;
	String encoding = "UTF-8";
	
	// multipart 요청.
	// request, 저장위치, 최대사이즈, 인코딩, 리네임정책(file.jpg, file1.jpg)
	MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
	title = multi.getParameter("title");
	content = multi.getParameter("content");
	String profile = multi.getOriginalFileName("profile"); // 업로드 파일명
	String fileName = multi.getFilesystemName("profile"); // rename 정책 파일명
	System.out.println("title: "+ title + ", content: "+ content + ", profile: "+profile + ", file: " + fileName);
    }

}
