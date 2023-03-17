package com.pojo.step3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ViewResolver {
	Logger logger = Logger.getLogger(ViewResolver.class);
	
	public ViewResolver() {
	}

	public ViewResolver(HttpServletRequest req, HttpServletResponse res, String[] pageMove) throws ServletException, IOException{
		String path = pageMove[1];
		
		// pageMove[0]이 redirect -> webapp
		if ("redirect".equals(pageMove[0])) {
			logger.info(pageMove[0] + ", " + pageMove[1]);
			res.sendRedirect(path);
		}
		// pageMove[0]이 forward -> webapp
		else if ("forward".equals(pageMove[0])) {
			logger.info(pageMove[0] + ", " + pageMove[1]);
			RequestDispatcher view = req.getRequestDispatcher("/" + path + ".jsp");
			view.forward(req, res);
		}
		// 그외 forward 처리 -> WEB-INF
		// setViewName(XXX);
		// WEB-INF/views/XXX.jsp
		else {
			logger.info(pageMove[0] + ", " + pageMove[1]);
			if(pageMove[0] != null && pageMove[0].length() > 0) {
				path = pageMove[0] + "/" + pageMove[1];
			} else {
				path = pageMove[1];
			}
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/" + path + ".jsp");
			view.forward(req, res);
		}
	} // end of ViewResolver(req, res, pageMove)
}