<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script>
	const autoReload = () => {
		console.log('autoReload 호출');
		//ajax함수는 jquery.min.js가 제공하는 api이다.
		//ajax함수는 결국 XMLHttpRequest();
		//ajax.open("GET",url,true)
		//ajax.send()
		$.ajax({
          type: "GET",
          url: "newsList.jsp",
          success: function (data) {
            $("#d_news").html(data);
            
          },
        });
	}
</script>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(() => {//문서가 열리자마자 실행되는
			start = () => {
				setInterval(autoReload, 2000);
			}
			start();
		})
	</script>
	<div id="d_news">뉴스 준비중...</div>
<%
	System.out.print("<font color = 'red' size=18></font>");
%>
</body>
</html>
<!-- 
 html(단방향, 변수선언이나 제어문 지원 안됨,이벤트 처리 불가)은 순차적으로 실행
 자바스크립트의 코드의 위치에 따라서 document.querySelector(id or class or elementname)
 항상 선언이 먼저이다.
 자바스크립트 위치
 1)head안에 올 수 있다.-전변선언, 함수선언할때(호출할때 실행됨)
 	만일 이것을 지연하고 싶을때-defer-미룬다-html, DOM Tree그린다.
 2)boby안에 올 수 있다.-호출하지 않아도 실행됨
 단, 함수로 선언된 부분은 제외
 
 

 -->