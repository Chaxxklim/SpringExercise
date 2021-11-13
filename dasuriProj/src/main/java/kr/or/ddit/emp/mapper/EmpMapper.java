package kr.or.ddit.emp.mapper;

import java.util.List;

import kr.or.ddit.cus.vo.EmpVO;

public interface EmpMapper {
	List<EmpVO> list();
	
	int insert(EmpVO emp);

	//직원번호 자동생성
	String createEmpNo();
	//직원번호 상세
	EmpVO detail(String empNo);
	
	int update(String empNo);
}
