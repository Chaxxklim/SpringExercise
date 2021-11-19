package kr.or.ddit.article.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.vo.ArticleFileVO;
import kr.or.ddit.article.vo.ArticleVO;

public interface ArticleMapper {

	int insertArticle(ArticleVO articleVO);
	
	int insertArticleContent(ArticleVO articleVO);
	
	List<ArticleVO> selectAllArticle(Map<String, Object> map);
	
	int totalArticle();
	
	int selectFileCount(ArticleVO articleVO);
	
	List<ArticleFileVO> selectFile(ArticleVO articleVO);
	
	
}
