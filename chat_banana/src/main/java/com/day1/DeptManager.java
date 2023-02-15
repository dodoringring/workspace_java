package com.day1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/*
 * 자바로는 웹 서비스가 불가하다.->request와 response가 없어서 안된다.
 * 왜? http(s : security+인증서)프로토콜을 지원하는 API가 없으니까
 * 또하나는 
 * 자바에는 URL을 등록 할 수 없다.
 * uniform resource locator(프로토콜://도메인:포트번호/경로/페이지이름 or 서블릿)을 등록 할 수 없다.
 * 톰캣도 자바 가상머신이 없으면 기동이 안된다.
 * JSP엔진 Servlet엔진 둘다 있어야 한다.
 * a.jsp -> jsp-api.jar->톰캣[자바]->a_jsp.java->(컴파일 : servlet이 해준다-api.jar)a_jsp.class
 * 
 * 웹페이지의 출력이란? 쓰기이다.
 * request-쿼리스트링-get방식-RESTful API 4가지방식[get, post, put, delete]
 * 요청객체로 
 * response
 * document.write()
 * 서블렛에서 출력
 * PrintWriter out = res.getWriter();
 * out.print("<b></b>")
 * 
 * */

public class DeptManager extends HttpServlet{//반드시 서블릿을 상속 받아야 한다.
	Logger logger = Logger.getLogger(DeptManager.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
		logger.info("[[ doGet호출 성공]]");
		String u_deptno=req.getParameter("deptno");
		String u_dname=req.getParameter("dname");
		String u_loc=req.getParameter("loc");
		res.setContentType("text/plain;charset=UTF-8");
		PrintWriter out =res.getWriter();
		out.print(u_deptno+","+u_dname+","+u_loc);
		}
		@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
		}
}











