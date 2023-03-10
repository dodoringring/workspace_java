package mvc.kh;

import java.sql.Connection;
import java.util.Map;

import org.apache.log4j.Logger;

import model.vo.Board;
//updateBoard()

public class BoardService2 {
	Logger logger = Logger.getLogger(BoardService2.class);
	BoardDao2 boardDao = new BoardDao2();

	
	//로직쪽 구현하기
	
	public int updateBoard(Board board) {
		logger.info("insertBoard 호출 성공");
		int result = 0;
		
		result = boardDao.updateBoard(board);
		
		return result;
	}
}
