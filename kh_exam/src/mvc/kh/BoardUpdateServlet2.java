package mvc.kh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.vo.Board;
//3. 서블릿안에서 다처리하지말고 다오랑 서비스로 나눠서 처리해라
public class BoardUpdateServlet2 extends HttpServlet{
	Logger logger = Logger.getLogger(BoardUpdateServlet2.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		Board board = new Board();
		board.setId(req.getParameter("id"));
		board.setTitle(req.getParameter("title"));
		board.setWriter(req.getParameter("writer"));
		board.setContent(req.getParameter("content"));
		
		BoardService2 bs = new BoardService2();
		int result=bs.updateBoard(board);
		if(result == 1) {
			res.sendRedirect("./boardDetail.bo");
		}else {
			req.setAttribute("message", "게시글 수정 실패");
			RequestDispatcher view = 
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
			view.forward(req, res);
		}
	}		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		doGet(req,res);
	}	
}
