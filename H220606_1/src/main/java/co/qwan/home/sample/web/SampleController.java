package co.qwan.home.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping("/all")
	public void doAll() {
		System.out.println("do all...");
	}
	
	@GetMapping("/member")
	public void doMemeber() {
		System.out.println("*logined mamber...");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		System.out.println("*admin only...");
	}
}
