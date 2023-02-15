<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
	확장자는 jsp이지만 mime타입은 html이다.
	이 파일은 브라우저가 html문서로 판단한다.
	왜냐하면 1번 페이지 다이렉티브에 contentType에 설정된 마임 타입때문이다.
	실행하면 - URL주소에 해당 페이지를 요청하면
	c_jsp.java로 변경됨-(변경해주는애가 jsp-api.jar:jsp엔진 또는 jsp컨테이너라고 한다. 톰캣에 있음)
	->c_jsp.class로 변경됨
	out.print()out은 jsp가 제공하는 내장객체 - dos창이 아닌 브라우저에 쓰는것이다.
	->자바스크립트와 같은 원리로 자바인테 브라우저에서 동작이 가능함.
	
  -->
<script type="text/javascript">


document.write("<h1>최고존엄도희대장군^^</h1>")


</script>