package kr.or.ddit.article.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//게시글 작성자 정보를 담음
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WriterVO {
	private String writerId;
	private String writerName;

	
}
