package kr.or.ddit.article.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.vo.ArticleFileVO;
import kr.or.ddit.article.vo.ArticleVO;

public interface ArticleService {
	int insertArticle(ArticleVO articleVO) throws Exception;

	List<ArticleVO> selectAllArticle(Map<String, Object> map) throws Exception;

	int totalArticle() throws Exception;
	
	int selectFileCount(ArticleVO articleVO);
	
	List<ArticleFileVO> selectFile(ArticleVO articleVO);

	
}
