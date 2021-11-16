package kr.or.ddit.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	@RequestMapping("/error/error404")
	public String error404() {
		//forwarding
		return "error/error404";
	}
	@RequestMapping("/error/error500")
	public String error500() {
		
		return "error/error500";
	}
}
