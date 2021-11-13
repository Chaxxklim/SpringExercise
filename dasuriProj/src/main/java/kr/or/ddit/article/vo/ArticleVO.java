package kr.or.ddit.article.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
	private int articleNo;
	private String writerId;
	private String writerName;
	private String title;
	private Date regdate;
	private Date moddate;
	private int readCnt;
		
}
