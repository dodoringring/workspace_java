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
		logger.info("boardInsert호출"+pMap);
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
	public int boardSInsert(Map<String, Object> pMap) {
		logger.info("boardSInsert호출"+pMap);
		int result=0;
		SqlSessionFactory ssf = null;
		SqlSession ss = null;
		
		try {
			ssf = mcf.getSqlSessionFactory();
			ss = ssf.openSession();
			//insert이지만 update로 하는 이유는 리턴타입이 Object이기 때문이다.
			//메소드 이름은 상관 없이 해당 쿼리문을 id로 찾기 때문이다.
			result = ss.update("boardSInsert",pMap);
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
	/*
	 * 글 수정하기 구현
	 * @param pMap - 사용자가 입력한 값 받아옴
	 * 
	 * */
	public int boardMUpdate(Map<String, Object> pMap) {
		int result=0;
			SqlSessionFactory ssf = null;
			SqlSession ss = null;
			
			try {
				ssf = mcf.getSqlSessionFactory();
				ss = ssf.openSession();
				result = ss.update("boardMUpdate",pMap);
				logger.info(result);//채번한 글 그룹번호
			} catch (Exception e) {
				e.printStackTrace();
			}
	return result;
}
	public void bStepUpdate(Map<String, Object> pMap) {
		int result=0;
			logger.info("bStepUpdate호출");
			SqlSessionFactory ssf = null;
			SqlSession ss = null;
			try {
				ssf = mcf.getSqlSessionFactory();
				ss = ssf.openSession();
				result = ss.update("bStepUpdate",pMap);
				logger.info(result);//채번한 글 그룹번호
				if(result==1){
					ss.commit();
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	/*글 조회수 수정하기
	 * @param int - 글 번호 가져오기
	 * */
	public void hitCount(int bm_no) {
		int result=0;
			logger.info("hitCount호출");
			SqlSessionFactory ssf = null;
			SqlSession ss = null;
			try {
				ssf = mcf.getSqlSessionFactory();
				ss = ssf.openSession();
				result = ss.update("hitCount",bm_no);
				logger.info(result);//채번한 글 그룹번호
				if(result==1){
					ss.commit();
					}
				logger.info(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public int boardMDelete(Map<String, Object> pMap) {
		int result=0;
		logger.info("호출");
		SqlSessionFactory ssf = null;
		SqlSession ss = null;
		try {
			ssf = mcf.getSqlSessionFactory();
			ss = ssf.openSession();
			int bm_no=0;
			if(pMap.get("bm_no")!=null) {
				bm_no=Integer.parseInt(pMap.get("bm_no").toString());
			}
			result=ss.update("boardMDelete",bm_no);
			if(result==1){
				ss.commit();
			}
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
