package com.pojo.step3;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	
	public Map<String, Object> login(Map<String, Object> pMap) {
		Map<String, Object> rMap = null;
		//MyBatisConfig.xml문서를 통해 스캔한 오라클 서버 정보로 연결통로 확보
		SqlSessionFactory ssf = null;
		//위에서 SqlSessionFactory생성되면 쿼리문을 요청하는 selectOne메소드가 필요한데
		//그 메소드를 제공하는 클래스 및 commit, rollback지원
		SqlSession ss = null;
		try {
			//공통코드에서 연결통로 확보
			ssf = mcf.getSqlSessionFactory();
			//연결 통로 확보로 생성된 객체로 SqlSession 메모리에 로딩
			ss = ssf.openSession();
//			pmap = new HashMap<>();
//			pmap.put("mem_id", "lemon");
//			pmap.put("mem_pw", "1234");
			rMap = ss.selectOne("Login", pMap);
			logger.info(rMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rMap;
	}

}