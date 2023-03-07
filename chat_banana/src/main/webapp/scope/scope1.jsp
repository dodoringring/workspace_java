<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="myCar" scope="request" class="com.book.scope.Sonata" />
    <jsp:useBean id="herCar" scope="page" class="com.book.scope.Sonata" />
    <jsp:useBean id="hisCar" scope="session" class="com.book.scope.Sonata" />

<%
//유지문제->request, session+cookie
	com.book.scope.Sonata himCar=new com.book.scope.Sonata();
//scope를 가질 수 없다, 인스턴스화 하면 그래서 안된다. 인스턴스화는 스코프를 가질 수 없다.
	out.print("<h3>"+myCar.toString()+"</h3>");
	out.print("<h3>"+herCar.toString()+"</h3>");
	out.print("<h3>"+hisCar.toString()+"</h3>");
	out.print("<h3>"+himCar.carName+"</h3>");
	request.setAttribute("myCar",myCar);
	pageContext.setAttribute("herCar",herCar);//page는 여기 페이지에서만 된다.
	session.setAttribute("hisCar",hisCar);
%>
<jsp:forward page="move1.jsp">
<jsp:param name="oMyCar" value="<%=myCar.toString() %>"/>
<jsp:param name="oHerCar" value="<%=herCar.toString() %>"/>
<jsp:param name="oHisCar" value="<%=hisCar.toString() %>"/>
</jsp:forward>
</body>
</html>