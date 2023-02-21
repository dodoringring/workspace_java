<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Map,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MimeHtmlServlet2 응답페이지</title>
</head>
<body>
	<h2>MimeHtmlServlet2 응답페이지</h2>
	<%
	String myName=null;
	Integer age=null;
	myName=(String)session.getAttribute("myName");
	age=(Integer)session.getAttribute("age");
	out.print(myName);
	out.print("<hr>");
	out.print(age);
		out.print("<hr>");
	out.print("<br>");
	Map<String,Object> rmap=(Map<String, Object>)session.getAttribute("rmap");
	if(rmap!=null){//nullPointerException 방어 코드
	Object keys[]=rmap.keySet().toArray();
	for(int i=0;i<keys.length;i++){
		out.print(rmap.get(keys[i]));//자바코드
		out.print("<br/>");//html태그		
	}//end of for
	}
	
	out.print("<hr>");
	//getAttribute 의 리턴타입은 Object이다.(getParameter 의 리턴타입은 String이다.)
	List<Map<String,Object>> mList=(List<Map<String,Object>>)session.getAttribute("mList");
	if(mList!=null){
		for(int i=0;i<mList.size();i++){
			Map<String,Object> rMap =mList.get(i);
			out.print(rMap.get("mem_id")+","+rMap.get("mem_pw")+","+rMap.get("mem_name"));
		}
	}
			//스크립틀릿 안에 선언하면 지역변수이다. 서비스안에 들어오니까 지변이다.
	//왜냐면???-a.jsp는 a_jsp.java로 바뀐다. 이때 service메소드 안에 들어간다.
	//지역변수는 초기화를 생략 할 수 없다.
	
	%>
</body>
</html>