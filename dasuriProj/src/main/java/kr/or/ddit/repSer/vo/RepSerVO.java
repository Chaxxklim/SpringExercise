package kr.or.ddit.repSer.vo;

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
public class RepSerVO {
	private String serNo;
	private String empNo;
	private String cusNo;
	private int repPay;
	private int repTm;
}
