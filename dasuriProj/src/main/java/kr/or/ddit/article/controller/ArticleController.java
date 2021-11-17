package kr.or.ddit.article.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.vo.ArticleContentVO;
import kr.or.ddit.article.vo.ArticlePage;
import kr.or.ddit.article.vo.ArticleVO;
import kr.or.ddit.article.vo.WriterVO;
import kr.or.ddit.emp.vo.EmpVO;

@RequestMapping("/article")
@Controller
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ArticleController.class);
	
	@RequestMapping("/newArticleForm")
	public String newArticeForm(Model model) {
		logger.info("newArticleForm");
		model.addAttribute("article", new ArticleVO());
//		model.addAttribute("article", new WriterVO());
		return "article/newArticleForm";
	}
	
	@RequestMapping(value = "/newArticlePost", method = RequestMethod.POST)
	public String newArticlePost(@ModelAttribute("article") ArticleVO article,
			HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		EmpVO empVO = (EmpVO)session.getAttribute("EMPVO");
		
		WriterVO writerVO = new WriterVO(empVO.getEmpNo(), empVO.getNm());
		article.setWriterVO(writerVO);
		
		logger.info("article : " + article.toString());
		
		int result = this.articleService.insertArticle(article);
		logger.info("result : " + result);
		
		if (result > 0) {
			return "article/newArticleSuccess";
			
		} else {
			return "article/newArticleFail";
		}
		
	}
	
	@RequestMapping("/listArticle")
	public String listArtice(Model model, @RequestParam(value="currentPage",
			defaultValue="1") String currentPage) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int total = this.articleService.totalArticle();
		int modVal = Integer.parseInt(currentPage) % 5;
		int startPage = Integer.parseInt(currentPage) / 5 * 5 + 1;
		if(modVal == 0) startPage -= 5;
		int endPage = startPage + 4;
		int totalPages = total / 10;
		if(endPage > totalPages) endPage = totalPages;
		
		map.put("currentPage", currentPage);
		
		List<ArticleVO> mapList = this.articleService.selectAllArticle(map);
		if(mapList != null) logger.info("mapList : " + mapList.get(0).toString());
		
		
	
		
//		for(Map<String, Object> map : mapList) {
//			WriterVO writerVo = new WriterVO(
//			(String)map.get("WRITER_ID"),
//			(String)map.get("WRITER_NAME"));
//
//			ArticleContentVO articleContentVO = new ArticleContentVO(
//			Integer.valueOf((String)map.get("ARTICLE_NO")),
//			(String)map.get("CONTENT"));
//			
//			ArticleVO articleVo = new ArticleVO(
//			Integer.valueOf((String)map.get("ARTICLE_NO")),
//			writerVo,
//			(String)map.get("TITLE"),
//			(String)map.get("REGDATE"),
//			(String)map.get("MODDATE"),
//			articleContentVO,
//			Integer.valueOf((String)map.get("READ_CNT"))
//			);
//			articleVOList.add(articleVo);
//		}
		model.addAttribute("articlePage", 
				new ArticlePage(total, Integer.parseInt(currentPage), 10, mapList));
		return "article/listArticle";
	}
	
}
