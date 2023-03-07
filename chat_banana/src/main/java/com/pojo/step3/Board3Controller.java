package com.pojo.step3;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojo.step2.ActionServlet;
import com.util.HashMapBinder;

public class Board3Controller implements Controller3 {
	Logger logger = Logger.getLogger(Board3Controller.class);
	Board3Logic boardLogic=new Board3Logic();
	
	@Override
	public ModelAndView boardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList 호출");
		List<Map<String,Object>> bList=null;
		Map<String, Object> pMap=new HashMap<>();
		HashMapBinder hmb=new HashMapBinder(req);
		hmb.bind(pMap);
		bList=boardLogic.boardList(pMap);
		ModelAndView mav=new ModelAndView(req);
		mav.setViewName("board3/boardList");
		mav.addObject("bList",bList);
		return mav;
	}
	@Override
	public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList 호출");
		List<Map<String,Object>> bList=null;
		Map<String, Object> pMap=new HashMap<>();
		bList=boardLogic.boardList(pMap);
		req.setAttribute( "bList",bList);
		return "forward:jsonBoardList.jsp";
	}

	@Override
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardDetail 호출");
		List<Map<String,Object>> bList=null;
		Map<String, Object> pMap=new HashMap<>();
		HashMapBinder hmb=new HashMapBinder(req);
		hmb.bind(pMap);
		bList=boardLogic.boardList(pMap);
		logger.info(bList);
		req.setAttribute("bList",bList);
		return "forward:board3/boardDetail";
	}
/*
 * INSERT INTO board_master_t(bm_no, bm_title, bm_writer, bm_reg, bm_hit, bm_group, bm_pos, bm_step, bm_pw)
		VALUES (seq_board_no.nextval, #{bm_title}, #{bm_writer}, to_char(sysdate, 'YYYY-MM-DD'), 0, #{bm_group}, #{bm_pos}, #{bm_step})
 * */
	@Override
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		logger.info("boardInsert 호출");
		int result = 0;
		//폼태그안에 사용자가 입력한 정보(bm_writer, bm_title,bm_content등등)를 받아 온다.
		//req.getParameter("bm_writer");
		//req.getParameter("bm_title");
		//req.getParameter("bm_contnet");
		//req.getParameter("?");
		//req.getParameter("?"); 반복되는 코드 if나 while문 사용할수있다
		
		Map<String,Object> pMap=new HashMap<>();
		HashMapBinder hmb=new HashMapBinder(req);
		hmb.bind(pMap);
		result=boardLogic.boardInsert(pMap);
		String path="";
		if(result == 1) {
			path="redirect:/board3/boardList.st3";
		}else {
			path="boardInsertFail.jsp";
			res.sendRedirect(path);
		}
		return path;
	}

	@Override
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		logger.info("boardUpdate 호출");
		int result = 0;
		Map<String,Object> pMap=new HashMap<>();
		HashMapBinder hmb=new HashMapBinder(req);
		hmb.bind(pMap);
		logger.info(pMap);
		//result(0인데->1)값의 변화를 주는 코드 추가
		result=boardLogic.boardUpdate(pMap);
		String path ="";
		if(result == 1) {
			path="redirect:/board3/boardList.st3";
		}else {
			path="boardInsertFail.jsp";
			res.sendRedirect(path);
		}
		return "redirect:/board3/boardList.st3";
		
	}

	@Override
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		logger.info("boardDelete 호출");
		int result = 0;
		Map<String,Object> pMap=new HashMap<>();
		HashMapBinder hmb=new HashMapBinder(req);
		hmb.bind(pMap);
		//result=boardLogic.boardDelete(pMap);
		logger.info(pMap);
		String path ="";
		if(result == 1) {
			path="redirect:/board3/boardList.st3";
		}else {//result인경우 else타게만듦
			path="redirect:/board3/boardInsertFail.jsp";
			res.sendRedirect(path);
		}
		return path;
	
	}


}
