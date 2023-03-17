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
		// MyBatisConfig.xml문서를 통해 스캔한 오라클 서버정보로 연결통로 확보
		SqlSessionFactory sqlSessionFactory = null;
		// 위에서 SqlSessionFactory가 생성되면 쿼리문을 요청하는 selectOne 메소드가 필요한데
		// 그 메소드를 제공하는 클래스 및 commit, rollback 지원
		SqlSession sqlSession = null;
		try {
			// 공통코드에서 연결통로 확보
			sqlSessionFactory = mcf.getSqlSessionFactory();
			// 연결통로 확보로 생성된 객체로 SqlSession 로딩하기
			sqlSession = sqlSessionFactory.openSession();
			rMap = sqlSession.selectOne("login", pMap);
			logger.info(rMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rMap;
	}
}