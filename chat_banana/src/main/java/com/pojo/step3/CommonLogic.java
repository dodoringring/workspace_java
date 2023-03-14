package com.pojo.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
//@Service-여기는 서비스만 쓴다. 이종간일때만 @Repository쓴다.
public class CommonLogic {
	Logger logger=Logger.getLogger(CommonLogic.class);
	private CommonDao commonDao=new CommonDao();
	//@Autowired
	public List<Map<String, Object>> zipcodeList(Map<String, Object> pMap) {
			logger.info("zipcodeList호출 :"+pMap);
			List<Map<String,Object>> zList=null;
			zList=commonDao.zipcodeList(pMap);
			return zList;
	}
	
}
