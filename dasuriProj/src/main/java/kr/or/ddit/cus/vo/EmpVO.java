package kr.or.ddit.cus.vo;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpVO implements Serializable{
	@NotBlank
	private String empNo;
	@NotBlank @Size(max=4)
	private String nm;
	@NotBlank
	private String addr;
	@NotBlank
	private String hp;
	@NotBlank
	private String postNo;
	@NotBlank
	private String addr2;
	@NotBlank
	private String password;
	private String fireYn;
	
	
}
