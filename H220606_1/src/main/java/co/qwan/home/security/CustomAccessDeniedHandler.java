package co.qwan.home.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		System.out.println("*Access Denied Handler*");
		System.out.println("*Request method :"+request.getMethod());
		System.out.println("*Request path1 :"+request.getPathInfo());
		System.out.println("*Request path2 :"+request.getContextPath());
		System.out.println("*Request path3 :"+request.getPathTranslated());
		System.out.println("*Request url :"+request.getRequestURL());
		System.out.println("*Request uri :"+request.getRequestURI());
		System.out.println("*Request auth:"+request.getAuthType());
		System.out.println("*AccessEx :"+accessDeniedException.getMessage());
		
		System.out.println("*Redirect...*");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath+"/accessError");
	}

}
