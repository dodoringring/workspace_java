package com.pojo.step1;

public class ActionForward {
	//페이지 이동 방법
	//1. res.sendRedirect("XXX.jsp") -표준 서블릿-MVC패턴이 아니다.
	//  or res.sendRedirect("dept/getDeptList.kh")-서블릿이 요정을 받음-ㅡMVC패턴
	//JSP가 요청을 받는것이 왜 문제인가? -WAS마다 명명 규칙이 다르다. 그래서 인스턴스화를 할 수 없다.
	//또한 인스턴스화를 한다 하더라도 request와 response객체를 주입받지못하는 문제가 있다. 그러면 mime type을 못정한다.
	
	
	private String path=null;//응답페이지의 이름 또는 서블릿의 이름
	//sendRedirect로 페이지를 이동 할 것인지 아니면 forward로 페이지를 이동 할 것인지 결정해줌
	private boolean isRedirect=false;//true:redirect(insert|update|delete), flase:forward(select)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
/*
 * ActionForward클래스를 왜 만드나?
 * 웹서비스에서는 메인 메소드 대신에 URL로 요청을 보낸다.
 * 누가? 클라이언트가
 * 누구에게? 톰캣 서버에게
 * 요청을 할 때 URL을 사용한다.
 * 
 * 
 * 
 * */
