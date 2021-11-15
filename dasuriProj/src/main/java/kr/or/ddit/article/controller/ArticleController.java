package kr.or.ddit.article.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.article.vo.ArticleVO;

@RequestMapping("/article")
@Controller
public class ArticleController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ArticleController.class);
	
	@RequestMapping("/newArticleForm")
	public String newArticeForm(Model model) {
		logger.info("newArticleForm");
		model.addAttribute("article", new ArticleVO());
		return "article/newArticleForm";
	}
	
	@RequestMapping(value = "/newArticlePost", method = RequestMethod.POST)
	public String newArticlePost(@ModelAttribute("article") ArticleVO article) {
		logger.info("article : " + article.toString());
		
		return "article/newArticleSuccess";
	}
	
}
