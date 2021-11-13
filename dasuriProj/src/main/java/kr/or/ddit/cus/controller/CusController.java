package kr.or.ddit.cus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.cus.vo.Member;

@Controller
public class CusController {
	private static final Logger logger = 
			LoggerFactory.getLogger(CusController.class);
	
	
	@RequestMapping("/cus/registerForm01")
	public String list(Model model) throws Exception {
		
		model.addAttribute("member", new Member());
		
		return "cus/registerForm";
	}
	
	//입력값 검증을 할 도메인 클래스에 Validated 어노테이션을 지정하면 됨
	@RequestMapping(value="/cus/register", method=RequestMethod.POST)
	public String register(@Validated Member member,BindingResult result) {
		logger.info("register");
		
		logger.info("result.hasErrors() : " + result.hasErrors());
		//validation 한 결과, 오류가 있을 시 forwarding
		if(result.hasErrors()) {
			return "cus/registerForm";
		}
		
		return "cus/success";
	}
}




