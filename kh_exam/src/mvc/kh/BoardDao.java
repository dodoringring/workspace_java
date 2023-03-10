package mvc.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.log4j.Logger;

import model.vo.Board;

public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	public int insertBoard(Connection conn,Board board) {//파라미터 변경
		logger.info("insertBoard 호출 성공"+board);
		int result =0;
		Connection con = null;
		PreparedStatement pstmt = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO khboard(id,title,writer,content)");
		sql.append("VALUES(seq_khboard.nextval,?,?,?)");
		try {
			//insert후에 자동 커밋 해 주세요. 디폴트가 트루라서. 폴스면 커밋 나중에...묶음배송..기다렸다가 배송하려고
			con.setAutoCommit(false);//없으면 생략되었다는 뜻. -왜냐면 디폴트가 true라서 false는 넣어줘야됨. 
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			//사용자가 입력한 제목담기
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter() );
			pstmt.setString(3, board.getContent() );
			result = pstmt.executeUpdate();
			if(result==1)con.commit();
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return result;
	}
}
