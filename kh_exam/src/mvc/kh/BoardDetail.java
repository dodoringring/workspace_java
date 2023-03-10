package mvc.kh;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//시험문제 쪼개기
public class BoardDetail extends HttpServlet {
	Logger logger = Logger.getLogger(BoardDetail.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("btitle", req.getParameter("btitle"));
		pMap.put("bwriter", req.getParameter("bwriter"));
		pMap.put("bcontent", req.getParameter("bcontent"));
		int result = 0;
		BoardService bs = new BoardService();
		result = bs.insertBoard(pMap);
		logger.info("result: "+result);
		if(result == 1) {
			res.sendRedirect("./boardList.bo");
		}else {
			req.setAttribute("message", "게시글 등록 실패");
			RequestDispatcher view = 
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
			view.forward(req, res);
		}
	}		
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("btitle", req.getParameter("btitle"));
		pMap.put("bwriter", req.getParameter("bwriter"));
		pMap.put("bcontent", req.getParameter("bcontent"));
		int result = 0;
		BoardService bs = new BoardService();
		result = bs.insertBoard(pMap);
		logger.info("result: "+result);
		if(result == 1) {
			res.sendRedirect("./boardList.bo");
		}else {
			req.setAttribute("message", "게시글 등록 실패");
			RequestDispatcher view = 
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
			view.forward(req, res);
		}
	}		
}
