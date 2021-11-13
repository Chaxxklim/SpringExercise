package kr.or.ddit.emp.vo;

import java.util.List;

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

public class Member {
	@NotBlank
	private String userId;
	@NotBlank
	@Size(max = 4)
	private String userName;
	private String email;
	private String password;
	private String introduction;
	private List<String> hobbyList;
	private String developer; //Y / N
	private boolean foreigner;
	private String gender;
	private String nationality;
	private List<String> carList;
	
}
