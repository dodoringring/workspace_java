package com.pojo.step1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Board1Controller implements Action1 {
	Logger logger=Logger.getLogger(Board1Controller.class);
	@Override
	public ActionForward1 execute(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		logger.info("execute호출");
		logger.info("request : "+req);
		logger.info("response : "+res);
		//ActionForward1 af =null; 널초기화-NullPointerException -화면처리안됨
		ActionForward1 af= new ActionForward1();
		//FrontMVC11에서 결정된 정보를 Board1controller에서 사용하기 위해 요청객체 저장소 있는
		//값을 가져오기
		String upmu[]=(String[])req.getAttribute("upmu");
		Board1Logic boardLogic=new Board1Logic();
		//FrontMVC11은 실제업무를 처리하는 클래스 클래스가 아니므로 
		//실제 게시판 구현의 마지막 단계는 Board1Controller클래스이니까 여기서
		//Path정보와 리다이렉트 여부를 결정해 주는것이 맞다.-업무 담당자의 마지막 위치이니까...
		String path=null;
		boolean isRedirect=false;
		//너 게시글 목록을 출력할거야?
		if("getBoardList".equals(upmu[1])) {//upmu[1] /를 기준으로 0번째방은 업무용 이름 두번째는 요청이름
			List<Map<String,Object>> boardList=boardLogic.getBoardList();
			//조회된 경과를 요청객체에 담기
			req.setAttribute("boardList", boardList);
			//응답페이지 이름 결정
			path="getBoardList.jsp";
			//만일 vue.js나react와같이 UI라이브러이롸 연계시에는 json포맷을 생성하는 jsp페이지로 연결시켜야함-주의할것
			//path="jsonGetBoardList.jsp" application/json
			//redirect로 할지 forward로 할지를 결정함
			isRedirect=false;//false이면 forward이다-요청이 유지된다. - 주소창은 그대로인데 페이지는 바뀜
			
		}//너 부서등록 하려고?
		else if("jsonGetBoardList".equals(upmu[1])) {
			//insert into dept(deptno, dname, loc) values(?,?,?)
			String jsonDoc = boardLogic.jsonBoardList();
			path="jsonBoardList.jsp";
			isRedirect=false;//false이면 forward이다. -요청이 유지된다. 주소창은 그대로인데 페이지는 바뀜
		}//너 부서등록해야돼?
		else if("boardInsert".equals(upmu[1])) {
			int result = boardLogic.boardInsert();
			
		}
		//너 부서정보 수정해야돼?
		else if("boardUpdate".equals(upmu[1])) {
			//update board_master_t set bm_title=?,bm_writer=?,bm_content=?,...
			int result = boardLogic.boardUpdate();
			
		}
		//너희부서 없어졌다.
		else if("boardDelete".equals(upmu[1])) {
			//delete from board_master_t where bm_no=?
			int result = boardLogic.boardDelete();
		}
		af.setPath(path);
		af.setRedirect(isRedirect);
		return af;//액션포워드 넘긴다.
	}
	
	public static void main(String args[]) {
		Board1Controller bc =new Board1Controller();
		try {
			bc.execute(null,null);
		} catch (Exception e) {
	
		}
	}
}
