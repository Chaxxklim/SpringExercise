package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.cus.vo.EmpVO;

public interface EmpService {
	public List<EmpVO> list() throws Exception;
	
	public int insert(EmpVO emp) throws Exception;
	
	public String createEmpNo() throws Exception;

	EmpVO detail(String empNo) throws Exception;

	int update(String empNo) throws Exception;
}
