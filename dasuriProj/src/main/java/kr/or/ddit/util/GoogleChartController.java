package kr.or.ddit.util;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.util.service.UtilService;

@RestController
public class GoogleChartController {
	
	@Autowired
	UtilService utilService;
	
	// /chart/chart02_money 
	@RequestMapping("/chart/chart02_money")
	public JSONObject chart02_money() throws Exception {
		return this.utilService.cartMoney();
	}
}
