package com.pojo.step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HandlerMapping {
	static Logger logger=Logger.getLogger(HandlerMapping.class);


/*
 * @param upmu[](upmu[0]-업무명[폴더명],upmu[1]-메소드명,기능명,페이지이름,분기)
 * @param request -1-1,1-2와는 다르게 인터페이스를 implement하지 않는다.
 * @param response
 * 
 * 질문? 어디서 받아오지?
 * @return Object
 * 
 * 
 *
 * */
 public static Object getController(String[] upmu,HttpServletRequest req,HttpServletResponse res)
 	throws ServletException, IOException{
	 logger.info(upmu[0]+","+upmu[1]);
	 Controller3 controller=null;
	 String path=null;
	 Object obj=null;
	 ModelAndView mav=null;
	 if("board3".equals(upmu[0])) {
		 controller=new Board3Controller();
		 //게시글 전체 목록
		 if("boardList".equals(upmu[1])) {
			 obj=controller.boardList(req,res);
			 //리턴타입이ModelAndView
			 if(obj instanceof ModelAndView) {
				 return (ModelAndView)obj;
			 }
			 else if(obj instanceof String) {//타입 알아내기 instanceof
				 return (String)obj;
		 }
		 //리턴타입이 스트링
		 }
		 else if("jsonBoardList".equals(upmu[1])) {//Json 포맷 나감-application/json
			 if(obj instanceof ModelAndView) {//타입 알아내기 instanceof
				 return (ModelAndView)mav;
			 }else if(obj instanceof String) {//타입 알아내기 instanceof
				 return (String)obj;
			 }
		 }
		else if("boardInsert".equals(upmu[1])) {//글입력-새글쓰기와 댓글쓰기
			obj=controller.boardInsert(req,res);
			logger.info("boardInsert호출==>boolean : "+obj instanceof String);
			if(obj instanceof String) {//타입 알아내기 instanceof
				 return (String)obj;
			 }	 
				 }
		else if("boardUpdate".equals(upmu[1])) {//글수정-첨부파일 수정 유무 고려하기
			obj=controller.boardUpdate(req,res);
			if(obj instanceof String) {//타입 알아내기 instanceof
				 return (String)obj;
			 }
		}
		else if("boardDelete".equals(upmu[1])) {//글입력-새글쓰기와 댓글쓰기
			obj=controller.boardDelete(req,res);
			if(obj instanceof String) {//타입 알아내기 instanceof
				 return (String)obj;
			 }
				 }
		else if("boardDetail".equals(upmu[1])) {//Json 포맷 나감-application/json
			obj=controller.boardDetail(req,res);
			if(obj instanceof ModelAndView) {//타입 알아내기 instanceof
				return (ModelAndView)obj;
			}else if(obj instanceof String) {//타입 알아내기 instanceof
				return (String)obj;
			 }
		}
	 }//end of 게시판구현
	 //인증관리-나
	 else if ("auth".equals(upmu[0])) {
		 
	 }
	 
	 //회원관리-은재언니 등등..
	 else if ("member".equals(upmu[0])) {
		 
	 }
	 
	 return obj;
	 	
 	}
 }