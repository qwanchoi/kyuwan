package co.qwan.home;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		System.out.println("access Denied : " + auth);
		
		model.addAttribute("msg", "Access Denied");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		System.out.println("error: "+error);
		System.out.println("logout: "+logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error..!");
		}
		if(logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}
	
}
