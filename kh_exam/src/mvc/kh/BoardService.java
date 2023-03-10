package mvc.kh;

import java.sql.Connection;
import java.util.Map;

import org.apache.log4j.Logger;

import model.vo.Board;

public class BoardService {
	Logger logger = Logger.getLogger(BoardService.class);
	BoardDao boardDao = new BoardDao();

	
	//로직쪽 구현하기
	
	public int insertBoard(Board board) {
		logger.info("insertBoard 호출 성공");
		int result = 0;
		Connection con=JDBCTemplate.getConnection();
		result = boardDao.insertBoard(con, board);
		//result = 0;
		JDBCTemplate.close(con);
		return result;
	}
}
