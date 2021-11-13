package kr.or.ddit.cus.vo;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressVO {
	@NotBlank
	
	private String postCode; // 우편번호
	
	@NotBlank
	private String location; //주소
	
	@NotBlank
	private String location2; // 상세주소
	
	
}
