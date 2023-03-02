package com.pojo.step2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class Board2Dao {
	Logger logger=Logger.getLogger(Board2Dao.class);
	//insert here-이종간인 MyBatis연동에 필요한 공통 클래스에 대한 객체주입이 필요
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	public List<Map<String, Object>> boardList() {
		logger.info("boardList호출");
		List<Map<String, Object>> bList=null;
		SqlSessionFactory ssf = null;
		SqlSession ss = null;
		
		try {
			ssf = mcf.getSqlSessionFactory();
			ss = ssf.openSession();
			Map<String, Object> pMap=new HashMap<>();
			bList = ss.selectList("boardList",pMap);
			logger.info(bList);
		} catch (Exception e) {
			e.printStackTrace();
		}return bList;
	}
		
	}


/*
 * 순서!!
 * ActionServlet(페이지이동)-XXXController-XXXLogic-XXXDao-MyBatis Layer
 * */
