package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//Model, ModelMap
public class HashMapBinder {
	HttpServletRequest req=null;
	public HashMapBinder() {}
	public HashMapBinder(HttpServletRequest req) {
	this.req=req;
	}

//어떤 페이지 어떤 상황에서 공통코드를 재사용 가능하게 할것인가?
//업무별 요청 클래스에서 주입 받을 객체를 정해서 메소드의 파라미터로 전달받음
//전달받은 주소번지 원본에 값을 담아준다.
public void bind(Map<String,Object> pMap) {
	pMap.clear();
	//에뉴머레이션 리스트나 맵안에 뭐가 있는지를 체크해준다. getParameterNames는 Http가 제공. 여러개라서 에뉴머레이션으로 받음 정해짐...
	Enumeration<String> en = req.getParameterNames();
	while(en.hasMoreElements()) {
		String key=en.nextElement();
		pMap.put(key, req.getParameter(key));
		}
	}
}