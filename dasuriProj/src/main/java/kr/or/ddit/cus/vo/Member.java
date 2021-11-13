package kr.or.ddit.cus.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
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

public class Member implements Serializable {
	//NotBlank : 문자열이 null이 아님, trim(공백제거)한 길이가 0보다 커야함
	//Size : 글자 수, 컬렉션의 요소 개수를 검사
	//Email : 이메일 주소 형식인지 검사
	//Past : 과거 날짜인지 검사
	@NotBlank
	private String userId;
	@NotBlank
	@Size(max=3)
	private String userName;
	@Email
	private String email;
	@NotBlank
	private String password;
	private String introduction;
	private List<String> hobbyList;	//취미
	private String developer;	//개발자여부(Y/N)
	private boolean foreigner;	//외국인여부(false/true)
	private String gender;	//성별
	private String nationality; 	//국적
	private List<String> carList;	//소유차량 목록
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;	//생년월일
	
	//중첩된 자바빈즈 컬렉션의 입력값 검증
	@Valid
	private List<CardVO> cardList;
	
	@Valid
	private AddressVO address;

	
}
