package com.pojo.step1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//클래스 설계에 인터페이스 필요하다
//인터페이스 중심의 코딩을 전개하는 것이 결합도를 낮춰준다 - 의존성이 낮다 - 단위테스트 가능 - 신뢰도 높이는 코드
//HttpServlet에서 강제(Override : doGet, doPost를 의미)하는 void를 다른 타입으로 바꿔보기 위한 연습
//오버라이딩의 경우 선언부를 손댈 수 없다.
//ActionForard1은 setter와getter를 가진 VO패턴의 클래스임
//변수를 2개 보유 - private접근제한자를 선언-캡슐화
//String path => res.sendRedirect(path), req.getRequestDispather(path)
//path는 응답 페이지 이름[.jsp]이거나 응답페이지로  forward될 서블릿의 이름이 온다.
//스크립틀릿- init()-service()-destroy()->서블릿의 생명주기
//그중에 개발자는 service에만 관여함
//스크립틀릿 안에는 지역변수이다.
//목록->글쓰기->블라블라-> 저장(서블릿-sendRedirect) ->insert->select(서블릿-forward)->jsp
//두번째 전변은 boolean isRedirect->true이면 sendRedirect false이면 

//그래서 아래와 같이 바꾸었지만 파라미터자리의 req와 res는 개발자가 인스턴스화 하는 것이 아니고
//톰캣이 주입해주는 객체이다
//이 문제를 어떻게 해결하는지를 관전 포인트로 삼아야함
public interface Action1 {
	public ActionForward1 execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
	
}