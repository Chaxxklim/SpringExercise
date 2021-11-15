package kr.or.ddit.article.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본 생성자 있어야함
@AllArgsConstructor // 기본 생성자 있어야함
public class ArticleContentVO {

	private int articleNo;
	private String content;
}
