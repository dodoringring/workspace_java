package mvc.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.log4j.Logger;

import model.vo.Board;
//updateBoard()구현하기
public class BoardDao2 {
	Logger logger = Logger.getLogger(BoardDao2.class);
	public int updateBoard(Board board) {//파라미터 변경
		logger.info("insertBoard 호출 성공"+board);
		int result =0;
		Connection con = null;
		PreparedStatement pstmt = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("update khboard set title=?");
		sql.append("                ,content=?");
		sql.append(" where id=?");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			result = pstmt.executeUpdate();
			logger.info("result : "+result);
		} catch (Exception e) {
			logger.info("Exception : "+ e.toString());
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return result;
	}
}
