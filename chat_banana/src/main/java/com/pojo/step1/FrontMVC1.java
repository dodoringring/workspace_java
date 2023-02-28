package com.pojo.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontMVC1 extends HttpServlet {
	Logger logger=Logger.getLogger(FrontMVC1.class);
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doServide호출");
		//http://localhost:9000/dept/getDeptList.st.1
	
		String uri=req.getRequestURI();
		logger.info(uri);// /dept.getDeptList.st1
		String context =req.getContextPath();// server.xml에 들어있다.
		logger.info(context);
		//http://localhost:9000/dept/getDeptList.st1
				//http://localhost:9000/업무명폴더명/getDeptList.st1
				//http://localhost:9000/member/getDeptList.st1
				//http://localhost:9000/board/getDeptList.st1
		//http://localhost:9000/board/boardInsert.st1
		//http://localhost:9000/board/boardUpdate.st1
		//http://localhost:9000/board/boardDelete.st1
	
		
		String command=uri.substring(context.length()+1);
		System.out.println(command);
		int end = command.lastIndexOf(".");//16-st1잘라내기위해 사용
		System.out.println(end);
		command=command.substring(0,end);
		System.out.println(command);
		String upmu[]=null;//upmu[0]=업무명|폴더명, upmu[1]=요청기능이름
		upmu=command.split("/");
		for(String imsi:upmu) {
			System.out.println(imsi);
		}
		ActionForward af=null;
		//게으른 인스턴스화- 아직 결정되지 않았다.
		//업무명이 Controller class의 접두어이다.
		DeptController deptController=null;
		EmpController empController=null;
		
		if("dept".equals(upmu[0])) {
			req.setAttribute("upmu",upmu);
			//인스턴스화->execute()호출할려고->안하면 NullpointerException이니까->500번오류이다.
			deptController=new DeptController();
			af=deptController.execute(req, res);
			//DeptController는 서블릿이 아니어서 http상속아니고 implement action을 했쟈나..
			//req와 res를 톰캣 서버로부터 주입 받을 수 없다.
			//httpServlet을 상속안받아서 못쓴다.
			//그래서 여기에 인스턴스화해서 주입해준다. execute로
		}else if("emp".equals(upmu[0])) {
			empController=new EmpController();
			af=empController.execute(req, res);
		}
		
		//페이지 이동처리 공통코드 만듦
		//1.res.sendRedirect("/dept/getDeptList.jsp");//jsp-->servlet->jsp
		//res.sendRedirect("/dept/getDeptList.st1");//jsp->servlet->servlet->jsp
		//새글쓰기의 경우처럼!! 입력받고 insert하고 select하고 다시화면뿌리고
		if(af!=null) {
			if(af.isRedirect()) {
				res.sendRedirect(af.getPath());
			}else {
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req,res);
			}
		}//end for page이동처리에 대한 공통 코드부분
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req,res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req,res);
	}

}
