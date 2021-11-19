package kr.or.ddit.article.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.vo.ArticleContentVO;
import kr.or.ddit.article.vo.ArticleFileVO;
import kr.or.ddit.article.vo.ArticlePage;
import kr.or.ddit.article.vo.ArticleVO;
import kr.or.ddit.article.vo.WriterVO;
import kr.or.ddit.emp.vo.EmpVO;
import kr.or.ddit.util.FileUploadUtil;

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
			HttpServletRequest request, MultipartFile[] uploadFile) throws Exception {
		//업로드처리해봄
		ArticleFileVO afvo = new ArticleFileVO();
		String uploadFolder 
		= "C:\\A_TeachingMaterial\\6.JspSpring\\workspace\\dasuriProj\\src\\main\\webapp\\resources\\upload";
		
		//날짜 계층형 폴더 생성 시작 -----------------
		File uploadPath = new File(uploadFolder, FileUploadUtil.getFolder());
		//...webapp_resources_upload_2021_11_02
		logger.info("uploadPath : " + uploadPath);
		//생성될 폴더가 존재하지 않으면
		if(uploadPath.exists() == false) {
			//해당 폴더들을 생성 => 연도 > 월 > 일 
			uploadPath.mkdirs();
		}
		//날짜 계층형 폴더 생성 끝 -----------------
		
		List<String> list = new ArrayList<String>();
		String fileName;
		
		for(MultipartFile multipartFile : uploadFile) {
			logger.info("---------------------");
			logger.info("업로드 파일명 : " + multipartFile.getOriginalFilename());
			logger.info("업로드 파일 크기 : " + multipartFile.getSize());
			//파일 객체를 통해 이렇게 하겠다..
			UUID uuid = UUID.randomUUID();
			fileName = multipartFile.getOriginalFilename();
			afvo.setFileOriginalName(fileName);
			fileName = uuid.toString() + "_" + fileName;
			File saveFile 
			= new File(uploadPath, fileName);
			afvo.setFileName(fileName);
			afvo.setFilePath(uploadPath.getAbsolutePath());
			logger.info("fileName : " + fileName + "fileUploadPath : "  + uploadPath.getAbsolutePath());
			try {
				//transferTo() 메서드의 파라미터 : java.io.File의 객체
				multipartFile.transferTo(saveFile);
				//파일명을 리스트에 담음
				list.add(fileName);
			}catch(Exception ex) {
				logger.error(ex.getMessage());
			}//end catch
		}//end for
		
		
		
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
		// 파일 업로드 처리도 해야함
		
		
		
	}
	
	@RequestMapping("/listArticle")
	public String listArtice(Model model, @RequestParam(value="currentPage",
			defaultValue="1") String currentPage) throws Exception {
		List<Integer> fileChkList = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> fileChkMap = new HashMap<String, Object>();
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
		
		for (ArticleVO articleVO : mapList) {
			int fileChkResult = this.articleService.selectFileCount(articleVO);
			logger.info("chk : " + articleVO + "chkres : " + fileChkResult);
			
			if (fileChkResult > 0 ) {
				fileChkMap.put("fileChkArticleNo", articleVO.getArticleNo());
				fileChkList.add(articleVO.getArticleNo());
			}
		}
	
		
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
		model.addAttribute("fileChkMap", fileChkMap);
		model.addAttribute("fileChkList", fileChkList);
		logger.info("fileChkList : " + fileChkList);
//		logger.info("fileChkMap : " + fileChkMap);
		model.addAttribute("articlePage", 
				new ArticlePage(total, Integer.parseInt(currentPage), 10, mapList));
		return "article/listArticle";
	}
	@RequestMapping(value = "/chkFiles" )
	public String checkFiles(@RequestParam Map<String, Object> map, Model model) {
		int intArticleNo = Integer.parseInt((String) map.get("articleNo"));
//		Map<String, Object> resultMap = new HashMap<String, Object>();
		ArticleVO articleVO = new ArticleVO();
		articleVO.setArticleNo(intArticleNo);
		int result = this.articleService.selectFileCount(articleVO);
		
		logger.info("articleNo chk : " + map.get("articleNo") + " " + result);
		model.addAttribute("result", result);
		
		
		return "article/listArticle";
		
	}
	
}
