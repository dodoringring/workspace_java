<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%//스크립틀릿 html에 자바 섞어쓰기. JSP는 뷰의 역할
   String menu=(String)request.getAttribute("menu");
   String side=(String)request.getAttribute("side");
//오브젝트타입을 캐스팅연산자로 강제변환->스트링으로
	out.print("내가선택한 메뉴는"+menu+"이고, "+side+"입니다.");//null이 출력된다. why? 원본이 아니고 새로 만들어진 요청객체라서.
//서블릿에서 주입받은 req에 담겨있는 것이지 페이지 이동으로 출력된 화면이 가진 req에는 menu를 담지 않았다.
//request에는 menu담지 않았다. 
//기존의 요청이 끊어지고 (URL이 바뀌었잖아)새로운 객체가 getAttribute함
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>crudTest</title>
</head>
<body>
crudTest페이지입니다.
<!-- 기존의 요청이 끊어지고 새로운 요청이 왔다.
http://localhost:9000/haha.st1요청했더니 (web.xml)st1찾아서->servlet-name->servlet->classname
get방식이니까 doGet메소드가(누가? 톰캣이 .st1기준-시스템호출-callback) 호출되고
그 안에서 doService호출한다. 이때 파라미터로 톰캣서버에서 주입받은 req와 res를 넘겨(원본)준다.
서블릿이 호출될때 톰캣서버로부터 주입받은 request객체와 response객체가 아닌
새로운 request객체와 response객체라는 것이다. -->
</body>
</html>