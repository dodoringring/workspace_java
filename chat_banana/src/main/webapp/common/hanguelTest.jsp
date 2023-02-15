<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 여기는 html땅 -->
<% 
//여기는 자바땅 - 자바 코딩 가능함 - 스크립틀릿
//localhost:9000/common/hangeulTest.jsp?mem_name=김도희
//쿼리 스트링으로 넘어오는 한글 처리->servr.xml문서->URIEncoding="UFT-8"
String name=request.getParameter("mem_name");
out.print(name);//null 김도희
%>
<!-- 여기는 html땅 -->
