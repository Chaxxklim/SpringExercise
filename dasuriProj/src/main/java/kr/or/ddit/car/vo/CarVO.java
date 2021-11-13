package kr.or.ddit.car.vo;

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
public class CarVO {

	private String carNo;
	private String manuf;
	private int yy;
	private int driDis;
	private String cusNo;
}
