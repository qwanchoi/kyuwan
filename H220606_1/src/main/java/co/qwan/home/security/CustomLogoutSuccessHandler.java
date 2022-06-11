package co.qwan.home.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		System.out.println("*Logout success");
		System.out.println("Request url:"+request.getRequestURL());
		System.out.println("Request uri:"+request.getRequestURI());
		
		response.sendRedirect(request.getContextPath()+"/customLogin");
	}

}
