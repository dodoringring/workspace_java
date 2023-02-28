package com.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisCommonFactory {
	Logger logger = Logger.getLogger(MyBatisCommonFactory.class);
	
	public SqlSessionFactory sqlSessionFactory = null;
	
	public void init() {
		try {
		
			String resource = "com\\util\\MyBatisConfig.xml";
			System.out.println("resource");
			Reader reader = Resources.getResourceAsReader(resource);
			logger.info("before sqlSessionFactory : "+sqlSessionFactory);
			//싱글톤 패턴에서 객체 생성하기
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
			}
			logger.info("after sqlSessionFactory : "+sqlSessionFactory);
			System.out.println("after sqlSessionFactory : "+sqlSessionFactory);
		} catch (Exception e) {
			logger.info("[[ Exception ]] "+e.toString());
			System.out.println("[[ Exception ]] "+e.toString());
		}
	}// end of init
	public SqlSessionFactory getSqlSessionFactory() {
		System.out.println("11");
		init();
		return sqlSessionFactory;
	}
	public static void main(String[] args) {
		MyBatisCommonFactory mcf = new MyBatisCommonFactory();
		System.out.println("test");
		mcf.getSqlSessionFactory();
	}

}
