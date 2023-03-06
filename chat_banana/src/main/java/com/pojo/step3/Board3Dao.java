package com.pojo.step3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.pojo.step2.Board2Dao;
import com.util.MyBatisCommonFactory;

public class Board3Dao {
	Logger logger=Logger.getLogger(Board2Dao.class);
	//insert here-이종간인 MyBatis연동에 필요한 공통 클래스에 대한 객체주입이 필요
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList호출");
		List<Map<String, Object>> bList=null;
		SqlSessionFactory ssf = null;
		SqlSession ss = null;
		
		try {
			ssf = mcf.getSqlSessionFactory();
			ss = ssf.openSession();
//			Map<String, Object> pMap=new HashMap<>();
			bList = ss.selectList("boardList",pMap);
			logger.info(bList);
		} catch (Exception e) {
			e.printStackTrace();
		}return bList;
	}
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert호출");
		int result=0;
		SqlSessionFactory ssf = null;
		SqlSession ss = null;
		
		try {
			ssf = mcf.getSqlSessionFactory();
			ss = ssf.openSession();
			//insert이지만 update로 하는 이유는 리턴타입이 Object이기 때문이다.
			//메소드 이름은 상관 없이 해당 쿼리문을 id로 찾기 때문이다.
			result = ss.update("boardMInsert",pMap);
			logger.info(result);
			if(result==1){
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int getBGroup() {
		int result=0;
		Logger logger=Logger.getLogger(Board2Dao.class);
			logger.info("boardList호출");
			List<Map<String, Object>> bList=null;
			SqlSessionFactory ssf = null;
			SqlSession ss = null;
			
			try {
				ssf = mcf.getSqlSessionFactory();
				ss = ssf.openSession();
				result = ss.selectOne("getBGroup","");
				logger.info(result);//채번한 글 그룹번호
			} catch (Exception e) {
				e.printStackTrace();
			}
		return result;
	}
	public int getBNo() {
		int result=0;
		List<Map<String, Object>> pMap=null;
		SqlSessionFactory ssf = null;
		SqlSession ss = null;
			
			try {
				ssf = mcf.getSqlSessionFactory();
				ss = ssf.openSession();
				result = ss.selectOne("getBNo","");
				logger.info(result);//채번한 글 그룹번호
					if(result==1){
					ss.commit();
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return result;
	}
	public void bStepUpdate(Map<String, Object> pMap) {
		int result=0;
		Logger logger=Logger.getLogger(Board2Dao.class);
			logger.info("boardList호출");
			SqlSessionFactory ssf = null;
			SqlSession ss = null;
			
			try {
				ssf = mcf.getSqlSessionFactory();
				ss = ssf.openSession();
				result = ss.selectOne("bStepUpdate",pMap);
				logger.info(result);//채번한 글 그룹번호
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
