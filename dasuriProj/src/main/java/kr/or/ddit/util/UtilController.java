package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilController {
	private static final Logger logger = LoggerFactory.getLogger(UtilController.class);
	
	@RequestMapping("/chart/charts")
	public ModelAndView charts(ModelAndView mav) {
		
		 mav.setViewName("/chart/charts");
		 
		 return mav;
		
	}
	
	@RequestMapping("/chart/chart01")
	public String chart01() {
		
		return "chart/chart01";
	}
	
	//구글 멀티차트
	@RequestMapping("/chart/chart01Multi")
	public String chart01Multi() {
		
		return "chart/chart01Multi";
	}
	
	//구글 차트(오라클 DBMS)
	
	@RequestMapping("/chart/chart02")
	public String chart02() {
		
		return "chart/chart02";
	}
	
}
