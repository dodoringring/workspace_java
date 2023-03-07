<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.book.scope.Sonata" %>
<%
	Sonata myCar=(Sonata)request.getAttribute("myCar");
	String oMyCar=request.getParameter("oMyCar");
	String oHerCar=request.getParameter("oHerCar");
	String oHisCar=request.getParameter("oHisCar");
	Sonata herCar=(Sonata)pageContext.getAttribute("herCar");
	Sonata hisCar=(Sonata)session.getAttribute("hisCar");
	out.print("scope1.jsp에서 생성된 객체가 유지되나요?");
	out.print("<hr>");
	out.print(myCar);
	out.print("<hr>");
	out.print(herCar);
	out.print("<hr>");
	out.print(hisCar);
	out.print("<hr>");
	out.print(myCar.carName+","+oMyCar.carName+","+oMyCar.concat("1")+"자동차".concat("1"));
	//concat 안에 든걸 갖다 붙임. 변수가 들어 갈 수 있음
	out.print(herCar.carName+","+oHerCar);
	out.print(hisCar.carName+","+oHisCar+","+true.concat("1")+new Boolean(true));
%>
