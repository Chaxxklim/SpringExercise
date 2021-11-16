package kr.or.ddit.article.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.article.mapper.ArticleMapper;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.vo.ArticleVO;

@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public int insertArticle(ArticleVO articleVO) throws Exception {
		int result = this.articleMapper.insertArticle(articleVO);
		result = this.articleMapper.insertArticleContent(articleVO);
		return result;
	}

	@Override
	public List<Map<String, Object>> selectAllArticle(){
		return this.articleMapper.selectAllArticle();
	}

	@Override
	public int totalArticle() {
		return this.articleMapper.totalArticle();
	}


}
