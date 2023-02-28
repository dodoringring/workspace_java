package com.pojo.step1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//클래스 설계에 인터페이스 필요하다
//인터페이스 중심의 코딩을 전개하는것이 결합도를 낮춰준다.-의존성이 낮다.-단위테스트가능-신뢰도 높이는 코드
//HttpServlet에서 강제하는(Override) void를 다른 타입으로 바꾸어보자
//Override-doget, dopost
//그래서 아래와 같이 바꿨지만 파라미터 자리의 req와 res는 개발자가 인스턴스화 하는 것이 아니고 톰캣이 주입해줌->문제
//의존성 주입이다. 제어 역전이 일어난다. 역제어이다.
//이 문제를 어떻게 해결하지...?


public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException;
}
