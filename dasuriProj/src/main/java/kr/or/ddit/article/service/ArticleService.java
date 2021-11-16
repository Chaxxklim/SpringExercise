package kr.or.ddit.article.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.vo.ArticleVO;

public interface ArticleService {
	int insertArticle(ArticleVO articleVO) throws Exception;

	List<Map<String, Object>> selectAllArticle() throws Exception;

	int totalArticle() throws Exception;

	
}
