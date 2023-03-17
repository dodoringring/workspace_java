package com.pojo.step3;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.log4j.Logger;
 
import com.pojo.step2.Board2Controller;
 
public class ActionSupport extends HttpServlet {
	Logger logger = Logger.getLogger(ActionSupport.class);
 
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService 호출");
		String uri = req.getRequestURI();
		logger.info(uri); // /board3/boardList.st3가 찍힘
 
		String context = req.getContextPath();
		logger.info(context); // "/" -> server.xml에 들어있음
 
		String command = uri.substring(context.length() + 1);
		System.out.println(command); // board3/boardList.st3
 
		int end = command.lastIndexOf(".");
		System.out.println(end); // 16(board3의 경우)
 
		command = command.substring(0, end);
		System.out.println(command); // board3/boardList
 
		String upmu[] = null; // upmu[0]=업무명(폴더명), upmu[1]=요청기능이름(메소드명)
		upmu = command.split("/"); // /기준으로 문자열 잘라서 upmu 배열에 담기
		logger.info(upmu[0] + ", " + upmu[1]);
		// upmu req에 담기
		req.setAttribute("upmu", upmu);
		Object obj = ""; // null이 맞지만 String이 들어온다는 전제로 ""
 
		try {
			// 아래 코드는 DB쪽으로 가는 길
			obj = HandlerMapping.getController(upmu, req, res);
		} catch (Exception e) {
			logger.info("Exception: " + e.toString());
		}
 
		// 페이지 이동처리 공통코드
		// obj 형식 예시 -> redirect:XXX.jsp or forward:XXX.jsp
		// 아래 코드는 응답으로 나가는 길
		if (obj != null) {
			String pageMove[] = null; // 응답페이지의 위치, 페이지이름
			ModelAndView mav = null;
 
			// obj가 String인 경우 -> webapp
			if (obj instanceof String) {
				// obj에 :이 포함된 경우
				if (((String) obj).contains(":")) {
					logger.info(": 포함되어 있음");
					pageMove = obj.toString().split(":");
				}
				// objdp /가 포함된 경우
				else if (((String) obj).contains("/")) {
					logger.info("/ 포함되어 있음");
					pageMove = obj.toString().split("/");
				}
				// obj에 :과 /이 포함되지 않은 경우
				else {
					// spring boot -> @RestController 사용
					// spring4 -> ResponseBody 사용(@RestController 미지원)
					logger.info(":과 / 포함되어 있지 않음"); // 마임타입 text/plain
					pageMove = new String[1];
					pageMove[0] = obj.toString();
					logger.info(obj.toString());
				}
			}
			
			// obj가 ModelAndView인 경우 -> WEB-INF
			else if (obj instanceof ModelAndView) {
				mav = (ModelAndView) obj;
				pageMove = new String[2];
				pageMove[0] = ""; // forward가 들어있으면 안됨 -> 있으면 webapp로 향함
				pageMove[1] = mav.getViewName();
				logger.info(pageMove[0] + ", " + pageMove[1]);
			}
			
			logger.info("Object가 String, ModelAndView일 경우가 끝난 지점");
			// pageMove가 null이 아닐 경우 각 방식으로 페이지 이동처리
			if (pageMove != null && pageMove.length == 2) {
				// pageMove[0] = redirect or forward or ""
				// pageMove[1] = XXX
				logger.info(pageMove[0] + ", " + pageMove[1]);
				new ViewResolver(req, res, pageMove);
			}
			// pageMove배열이 한 개인 경우는 리턴값이 String인 경우일때
			// -> @RestController, 스프링부터 이전엔 ResponseBody
			else if (pageMove != null && pageMove.length == 1) {
				res.setContentType("text/plainl;charset=UTF-8");
				PrintWriter out = res.getWriter();
				out.print(pageMove[0]);
			}
		} // end of 페이지 이동처리 공통코드
	}
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet호출");
		doService(req, res);
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doPost호출");
		doService(req, res);
	}
}
