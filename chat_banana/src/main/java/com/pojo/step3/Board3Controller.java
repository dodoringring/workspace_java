package com.pojo.step3;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.util.HashMapBinder;
public class Board3Controller implements Controller3 {
	Logger logger = Logger.getLogger(Board3Controller.class);
	Board3Logic boardLogic = new Board3Logic();
	
	//메소드
		@Override
		public ModelAndView boardList(HttpServletRequest req, HttpServletResponse res) {
			logger.info("boardList 호출");
			List<Map<String, Object>> bList = null;
			//사용자가 조건 검색을 원하는 경우 - 조건 값을 전달할 객체 생성함
			//MyBatis에서는 동적쿼리를 지원하므로 하나로 2가지 경우 사용 가능함
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			bList =boardLogic.boardList(pMap);
			ModelAndView mav = new ModelAndView(req);
			mav.setViewName("board3/boardList");
			mav.addObject("bList", bList);				
			return mav;
		}
		
		@Override
		public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res) {
			logger.info("jsonBoardList호출");
			List<Map<String, Object>> bList = null;
			Map<String, Object> pMap = new HashMap<>();
			bList =boardLogic.boardList(pMap);
			req.setAttribute("bList", bList);
			return "forward:jsonBoardList.jsp";
		}
		@Override
		public Object boardDetail(HttpServletRequest req, HttpServletResponse res) {
			logger.info("boardDetail호출");
			List<Map<String, Object>> bList = null;
			//전체 조회에 대한 sql문 재사용 가능함 - 1건 조회 경우
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			bList =boardLogic.boardDetail(pMap);
			logger.info(bList);
			req.setAttribute("bList", bList);
			return "forward:board3/boardDetail";
		}
		/*
				INSERT INTO board_master_t(bm_no, bm_title, bm_writer, bm_reg, bm_hit
				                                              , bm_group, bm_pos, bm_step)
			    VALUES(seq_board_no.nextval, #{bm_title}, #{bm_writer}, to_char(sysdate, 'YYYY-MM-DD')
			               ,  0, #{bm_group}, #{bm_pos}, #{bm_step})
	     화면에서 받아올 값 - bm_title, bm_writer, bm_content
	     그렇지 않은 경우 - bm_group, bm_pos, bm_step, bm_reg
		 * */
		
		@Override
		public Object boardInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			logger.info("boardInsert호출");
			int result = 0;
			//폼태그 안에 사용자가 입력한 정보(bm_writer, bm_title, bm_content ....)를 받아온다
			//req.getParameter("bm_writer");
			//req.getParameter("bm_title");
			//req.getParameter("bm_writer");
			//req.getParameter("bm_writer");
			Map<String, Object> pMap = new HashMap<>();
			logger.info("before ==>" + pMap);
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.multiBind(pMap);//멀티 바인드를 타게한다. 첨부파일 post방식
			logger.info("after ==>" + pMap);
			result = boardLogic.boardInsert(pMap);
			String path = "";
			 if(result==1) {
				path = "redirect:/board3/boardList.st3";
			}else {
				path ="boardInsertFail.jsp";
				res.sendRedirect(path);
			}
			return path;
		}
	
		@Override
		public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			logger.info("boardUpdate호출");
			int result = 0;
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			logger.info(pMap);
			//result 값의 변화를 주는 코드 추가 => 현재는 0
			result = boardLogic.boardUpdate(pMap);
			String path = "";
			if(result==1) {
				path = "redirect:/board3/boardList.st3";
				
			}else {
				path = "boardInsertFail.jsp";
				res.sendRedirect(path);
			}
			return path;
		}
		
		
	@Override
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("boardDelete호출");
		int result = 0;		
		Map<String, Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		result= boardLogic.boardDelete(pMap); //이게 없으면 안된다
		//없으면 java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1 에러뜸
		String path = "";
		if(result==1) {
			logger.info("DB에서 삭제 성공");
			path = "redirect:/board3/boardList.st3";
		}
		else {//result =0인 경우 else 타게 되므로 redirect문장 추가안해주면 /표시 따라 잘라주는데 아무것도 안들어가게 된다\
			path="redirect:/board3/boardInsertFail.jsp";
			res.sendRedirect(path);
		}
		return path;
	}
}