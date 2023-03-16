<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제 4</title>
</head>
<body>
	문제4. 다음 중 테이블에 대한 설명으로 틀린 것을 고르시오.
	<br>
	<input type="checkbox" name="cb" onChange="test(0)"> row와
	column으로 구성되어있다.
	<br>
	<input type="checkbox" name="cb" onChange="test(1)"> 테이블에는 반드시
	index가 있어야 한다.
	<br>
	<input type="checkbox" name="cb" onChange="test(2)"> 컬럼에는 적당한
	타입을 선택하고 담을 수 있는 크기도 설정할 수 있다.
	<br>
	<input type="checkbox" name="cb" onChange="test(3)"> 테이블에는 PK도
	올 수 있고 FK도 올 수 있다.
	<br>
	<br>
	<input type="button" value="이전문제" onClick="prev()">
	<input type="button" value="다음문제" onClick="next()">
</body>
</html>