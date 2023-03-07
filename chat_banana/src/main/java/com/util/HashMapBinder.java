package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//Model, ModelMap
//스프링 부트에서는 RequestParam대신 해줌, Model, ModelMap 귀찮거든 
//사용자가 입력한 값을 Map에 담아 준다.
//담을 맵은 컨트롤 계층에서 bind메소드 호출시 파라미터를 이용해서 원본주소를 받아온다.
//그리고 그 안에 담는다.
public class HashMapBinder {
	HttpServletRequest req=null;//(전변)
	public HashMapBinder() {}
	//생성자 파라미터에 요청객체(지변)가 필요한 이유는?
	public HashMapBinder(HttpServletRequest req) {
	//전변과 지변 초기화->생성자의 제 1 역할
	this.req=req;
	}

//어떤 페이지 어떤 상황에서 공통코드를 재사용 가능하게 할것인가?
//업무별 요청 클래스에서 주입 받을 객체를 정해서 메소드의 파라미터로 전달받음
//전달받은 주소번지 원본에 값을 담아준다.
public void bind(Map<String,Object> pMap) {//이 객체는 누가 주입해주나? 어느 위치에서 인스턴스화 되나? 왜 파라미터인가?
	pMap.clear();
	//에뉴머레이션은 리스트나 맵안에 뭐가 있는지를 체크해준다. getParameterNames는 Http가 제공. 여러개라서 에뉴머레이션으로 받음 정해짐...
	Enumeration<String> en = req.getParameterNames();
	while(en.hasMoreElements()) {
		String key=en.nextElement();
		pMap.put(key, req.getParameter(key));
		}
	}
}