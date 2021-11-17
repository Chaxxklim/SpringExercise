package kr.or.ddit.article.vo;


import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
	private int rnum;
	private int articleNo;
	private WriterVO writerVO;
	@NotBlank
	private String title;
	private String regDate;
	private String modDate;
	private ArticleContentVO articleContentVO;
	private int readCnt;
}
