package com.pojo.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//HttpServlet을 상속받았으므로 서블릿이다.
//그래서 나는 메소드 파라미터로 request와 response를 받을 수 있다.
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontMVC11 extends HttpServlet {
	Logger logger=Logger.getLogger(FrontMVC11.class);
	private static final long serialVersionUID=1L;
	//개발자 입장에서는 get방식이든 요청이든 post방식 요청이든 모두 처리해야 합니다.
	//그래서 창구를 하나로 통일하려고 doService사용자 정의 메소드를 추가한것임.
	//이 메소드는 어떤 장애를 가지고 있나요?-톰캣으로부터 요청객체와 응답객체를 주입받지 못한다.
	//XXX.st1으로 요청하면 doGet만 호출이 가능하고 doPost안됨, doService안됨.
	//메소드에 파라미터로 요청객체와 응답객체를 내가 주입해준다. 오버라이드할 부모가 없어. @아니다.
	//테스트 URL-프로토콜:도메인주소:포트번호/작업폴더명/요청이름
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doservice호출-시간,로그레벨,라인번호, 클래스명");
		logger.info("doservice호출");
		String uri = req.getRequestURI(); //주소창에 입력된 값중에서 도메인과 포트번호가 제외된 값만 갖고옴
		logger.info(uri);// /dept/getDeptList.st1
		//server.xml<Context path="/"
		String context = req.getContextPath();//"/" -> server.xml ContextPath정보가 톰캣 서버의 주소
		logger.info(context);// /dept/getDeptList.st1
		String command = uri.substring(context.length()+1); //context정보만 제외된 나머지 정보를 담고 있음
		System.out.println(command);//dept/getDeptList.st1
		int end = command.lastIndexOf(".");//16 -st1잘라내기위해 사용 // .에 대한 위치를 잘라내기 위해서
		System.out.println(end);//16출력
		command = command.substring(0,end);//dept/getDeptList
		System.out.println(command);
		String upmu[] = null;//upmu[0] = 업무명|폴더명, upmu[1] = 요청기능이름
		upmu = command.split("/");//dept , getDeptList
		for(String imsi: upmu) {
			System.out.println(imsi);
		}
		ActionForward1 af = null;
		Board1Controller boardController=null;
		//Board1Controller는 서블릿이 아니므로 요청객체와 응답객체를 주입받지 못함
		//execute호출시 파라미터 전달하기-구조
		//원본이 넘어가는거니까 거기에 upmu배열을 저장한다.
		req.setAttribute("upmu", upmu);
		if("board".equals(upmu[0])) {
			boardController = new Board1Controller();//나는 서블릿이 아니다.
			//톰캣서버를 경유 했을때 요청객체와 응답객체를 활용가능함.
			//섭ㄹ릿이 아니지만 req와 res는 반드시 필요하다-웹서비스를 제공
			//FrontMVC11경유해라
			af = boardController.execute(req,res);
		}
		
		if(af!=null) {
			if(af.isRedirect()) {
				res.sendRedirect(af.getPath());
			}else {
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req,res);
			}
		}//end for page이동처리에 대한 공통 코드부분
	}

	
	/*Restful API-GET방식
	 * 브라우저에 인터셉트 당한다. 노출이 되어있다. 그래서 브라우저가 아는척 한다.
	 * 헤더에 값이 담기므로 제약이 있다.
	 * 첨부파일 처리에 사용불가함
	 * 링크 걸 수 있다.
	 * 단위테스트 가능함.(Mockup작업시 좋다.)
	 * */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//Post방식으로 요청이 일어나면 서블릿의 doPost가 받는다.
	//이때 톰캣 컨테이너로부터 요청객체와 응답개체를 주입받는다.(의존성 주입)
	//개발자가 정의한 doService메소드 호출시 파라미터로 주입받은 요청객체와 응답객체를 넘긴다.
	//오버라이딩하는 doget,dopost가 아닌것은 톰캣서버로부터 res,req를 주입 받을 수 없다.
//그래서 doget, dopost메소드 내에서 doservice메소드를 호출 할 때 파라미터로 req,res를 넘긴다.
//그래야 사용자 정의 메소드에서도 요청객체와 응답 객체를 사용 할 수 있으니까.
//POJO프레임 워크는 요청객체와 응답객체에 의존적이다.
//스프링 프레임 워크에서는 요청객체와 응답객체 없이도 모든 서비스가 가능하게 되었다.
//없이도 가능 하다는것은 메소드의 파라미터로 주입 받는다라는걸 의미한다.
//스프링에서는 메소드의 파라미터의 갯수가 늘었다 줄었다 할 수 있다. 오버라이딩 관계가 아니다.
	doService(req,res);//pass by value
	}
	/*Restful API-Post방식
	 * 링크를 걸 수 없다. 단독으로 호출 테스트 불가하다. Postman이 필요하다.
	 * 포스트맨이 네가지 테스트함(get, post, put, delete)
	 * 브라우저에 쿼리스트링에 노출이 안됨. -포장되어있는 선물
	 * 패킷에 바디부분에 값이 담기므로 용량에 제한이 없다.-첨부파일? 포스트로!! 슬랙에서도 Post쓴다.
	 * 노출이 안되어서 브라우저에 인터셉트 당하지 않는다.
	 * */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req,res);
	}

}
