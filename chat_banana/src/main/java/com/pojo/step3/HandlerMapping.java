package com.pojo.step3;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.log4j.Logger;
 
public class HandlerMapping {
	static Logger logger = Logger.getLogger(HandlerMapping.class);
	
	/***************************************
	 * @param upmu[](upmu[0]=업무명,폴더명 | upmu[1]=메소드명, 기능명, 페이지이름)
	 * @param request -> 1-1, 1-2와는 다르게 인터페이스를 implements하지 않는다
	 * @param response -> HttpServlet
	 * Q. 어디서 받아오는가?
	 * @return Object
	 * 테스트 -> http://localhost:9000/board3/boardList.st3
	 ***************************************/
	
	public static Object getController(String[] upmu, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info(upmu[0]+", "+upmu[1]);
		Controller3 controller = null;
		String path = null;
		Object obj = null;
		ModelAndView mav = null;
		
		// common
		if("common".equals(upmu[0])) {
			controller = new CommonController();
			// 우편번호 조회
			if("zipcodeList".equals(upmu[1])) {
				obj = controller.zipcodeList(req, res);
				// 리턴타입이 ModelAndView인 경우
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				}
				// 리턴타입이 String인 경우
				else if(obj instanceof String) {
					return (String)obj;
				}
			} // end if zipcodeList if문
		}
		
		// 게시판 구현
		else if("board3".equals(upmu[0])) {
			controller = new Board3Controller();
			
			// 게시글 전체 목록 -> html 화면 출력(text/html)
			if("boardList".equals(upmu[1])) {
				obj = controller.boardList(req, res);
				// 리턴타입이 ModelAndView인 경우
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				}
				// 리턴타입이 String인 경우
				else if(obj instanceof String) {
					return (String)obj;
				}
			}
			
			// json 게시글 전체 목록 -> json 화면 출력(application/json)
			else if("jsonBoardList".equals(upmu[1])) {
				obj = controller.jsonBoardList(req, res);
				// 리턴타입이 ModelAndView인 경우
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				}
				// 리턴타입이 String인 경우
				else if(obj instanceof String) {
					return (String)obj;
				}
			}
			
			// 글 입력 - 새글쓰기와 댓글쓰기
			else if("boardInsert".equals(upmu[1])) {
				obj = controller.boardInsert(req, res);
				// 리턴타입이 String인 경우
				if(obj instanceof String) {
					return (String)obj;
				}
			}
			
			// 이미지 업로드 - 리액트 quill editor 이미지 추가
			else if("imageUpload".equals(upmu[1])) {
				obj = controller.imageUpload(req, res);
				logger.info("imageUpload 호출 => " + obj instanceof String);
				// 리턴타입이 String인 경우
				if(obj instanceof String) {
					return (String)obj;
				}
			}
			
			// 이미지 다운로드 - 리액트 quill editor 이미지 추가
			else if("imageDownload".equals(upmu[1])) {
				obj = controller.imageDownload(req, res);
				logger.info("imageDownload 호출 => " + obj instanceof String);
				// 리턴타입이 String인 경우
				if(obj instanceof String) {
					return (String)obj;
				}
			}
			
			// 리액트 -
			else if("imageGet".equals(upmu[1])) {
				obj = controller.imageGet(req, res);
				logger.info("imageGet 호출 => " + obj instanceof String);
				// 리턴타입이 String인 경우
				if(obj instanceof String) {
					return (String)obj;
				}
			}
			
			// 글 수정 - 첨부파일 수정 유무 고려하기
			else if("boardUpdate".equals(upmu[1])) {
				obj = controller.boardUpdate(req, res);
			// 리턴타입이 String인 경우
				if(obj instanceof String) {
					return (String)obj;
				}
			}
			
			// 글 삭제 - 첨부파일 삭제 유무 고려하기
			else if("boardDelete".equals(upmu[1])) {
				obj = controller.boardDelete(req, res);
			// 리턴타입이 String인 경우
				if(obj instanceof String) {
					return (String)obj;
				}
			}
			
			// 글 상세보기
			else if("boardDetail".equals(upmu[1])) {
				obj = controller.boardDetail(req, res);
				// 리턴타입이 ModelAndView인 경우
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				}
				// 리턴타입이 String인 경우
				else if(obj instanceof String) {
					return (String)obj;
				}
			}
		} // end of 게시판 구현
		
		// 인증 관리 구현
		else if("auth".equals(upmu[0])) {
		}
		
		// 회원 관리 구현
		else if("member".equals(upmu[0])) {
			controller = new MemberController();
			if("login".equals(upmu[1])) {
				obj = controller.login(req, res);
				// 리턴타입이 ModelAndView인 경우
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				}
				// 리턴타입이 String인 경우
				else if(obj instanceof String) {
					return (String)obj;
				}
			}//end of login
			else if("logout".equals(upmu[1])) {
				obj = controller.logout(req, res);
				// 리턴타입이 ModelAndView인 경우
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				}
				// 리턴타입이 String인 경우
				else if(obj instanceof String) {
					return (String)obj;
				}
			}//end of logout
		}//end of 회원관리
		
		// 주문 관리 구현
		else if("order".equals(upmu[0])) {
		}
		
		return obj;
	}
}