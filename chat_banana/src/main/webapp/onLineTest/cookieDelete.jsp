<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키정보는 사용자 컴터에 저장되어 있음
	//그래서 서버는 요청을 해야 함 - 사용자 컴터에게
	//서버는 사용자를 어떻게 구분하나요? - JSessionID 발급 -> 쿠키에 저장됨 -> 쿠키값 기준으로 너를 알아봄
	Cookie cs[] = request.getCookies();
	int size = 0;
	size = cs.length;
	
	for(int i=0; i<size; i++) {
		String c_name = cs[i].getName();
		if(("testForm1").equals(c_name)) {
			Cookie cookie = new Cookie(c_name,"");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		else if(("testForm2").equals(c_name)) {
			Cookie cookie = new Cookie(c_name,"");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		else if(("testForm3").equals(c_name)) {
			Cookie cookie = new Cookie(c_name,"");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		else if(("testForm4").equals(c_name)) {
			Cookie cookie = new Cookie(c_name,"");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		else if(("testForm5").equals(c_name)) {
			Cookie cookie = new Cookie(c_name,"");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
			
	response.sendRedirect("testForm1.jsp");		
%>