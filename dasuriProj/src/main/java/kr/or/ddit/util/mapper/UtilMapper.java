package kr.or.ddit.util.mapper;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

public interface UtilMapper {
	//상품별 판매금액의 합계목록
	List<Map<String, Object>> cartMoney();
}
