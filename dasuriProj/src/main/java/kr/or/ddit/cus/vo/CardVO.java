package kr.or.ddit.cus.vo;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardVO {
	@NotBlank
	private String no;
	@Future
	@DateTimeFormat(pattern = "yyyy-MM")
	private Date validMonth;
}
