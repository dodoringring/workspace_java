package com.pojo.step3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojo.step2.Board2Controller;

public class ActionSupport extends HttpServlet {
	Logger logger = Logger.getLogger(ActionSupport.class);
	
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService호출");
		String uri = req.getRequestURI();
		logger.info(uri);
		String context = req.getContextPath();// GUI -> tomcat -> modules의 path
		logger.info(context);
		String command = uri.substring(context.length() + 1);
		System.out.println(command);
		int end = command.lastIndexOf(".");// 16 - st1잘라내기위해 사용 ~ 확장자 제거
		System.out.println(end);
		command = command.substring(0, end);
		System.out.println(command);
		String upmu[] = null;
		upmu = command.split("/");
		logger.info(upmu[0] + ", " + upmu[1]);// 테스트 URL : http://localhost:9000/board/getBoardList.st2
		req.setAttribute("upmu", upmu);
		
		Object obj = "";
		try {
			obj=HandlerMapping.getController(upmu,req,res);
		} catch (Exception e) {
			logger.info("Exception"+e.toString());
		}
		
		if (obj != null) {// redirect:XXX.jsp or forward:XXX.jsp
			String pageMove[] = null;
			ModelAndView mav=null;
			if (obj instanceof String) {
				if (((String) obj).contains(":")) { // contain은 안에 이거 들어있나 없나 확인하고 T/F로 반환
					logger.info(":포함되어 있어요.");
					pageMove = obj.toString().split(":");
				} else {
					logger.info("포함되어있지 않아요.");
					pageMove = obj.toString().split("/");
				}
				logger.info(pageMove[0] + "," + pageMove[1]);
			}else if(obj instanceof ModelAndView) {
				mav=(ModelAndView)obj;
				pageMove=new String[2];
				pageMove[0]="forward";
				pageMove[1]=mav.getViewName();
			}

			if (pageMove != null) {
				String path = pageMove[1];
				if ("redirect".equals(pageMove[0])) {
					res.sendRedirect(path);
				} else if ("forward".equals(pageMove[0])) {
					RequestDispatcher view = req.getRequestDispatcher("/" + path + ".jsp");
					view.forward(req, res);
				} else {
					path = pageMove[0] + "/" + pageMove[1];
					RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/view/" + path + ".jsp");
					view.forward(req, res);
				}
			} // end for page이동처리에 대한 공통 코드부분
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("deGet호출");
		doService(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res);
	}
}
