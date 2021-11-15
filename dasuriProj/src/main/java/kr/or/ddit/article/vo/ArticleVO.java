package kr.or.ddit.article.vo;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
	private int articleNo;
	private WriterVO writerVO;
	@NotBlank
	private String title;
	private Date regDate;
	private Date modDate;
	private ArticleContentVO articleContentVO;
	private int readCnt;
}
