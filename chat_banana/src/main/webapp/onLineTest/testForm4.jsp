<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
현재 내가 바라보는 페이지는 terstForm4.jsp이지만
3번문제에 대한 답은 다음 문제버튼이 눌렸을때 마음에 결정이 된것이니까
3번 문제에 대한 답을 담는 hidden은 남겨야한다.
그 값을 다음 문제인 testForm4.jsp에서 request.getParameter("")로 읽어서
쿠키를 생성하고 그 값을 저장할것
*/
	/* String dap1 = request.getParameter("htest1");
	out.print("1번 문제 답안지 ===> "+dap1);
	String dap2 = request.getParameter("htest2");
	out.print("2번 문제 답안지 ===> "+dap2);
	String dap3 = request.getParameter("htest3");
	out.print("3번 문제 답안지 ===> "+dap3); */
	
	String dap3=request.getParameter("htest3");
	out.print("1 문제 답안지"+dap3);//숫자 더하기 문자는 문자이다.
	//쿠키에는 문자열만 담을 수 있으므로 드냥 2를 쓰면 컴파일 에러임
	Cookie c3=new Cookie("testForm1",dap3);
	c3.setPath("/onLineTest");
	c3.setMaxAge(60*60);//평가시간이 60분일때 시간 설정값이다.
	response.addCookie(c3);
%>	   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제 4</title>
<script type="text/javascript">
const test=(cb)=>{
	for(let i=0; i<document.f_test1.cb.length;i++){
		if(cb===i)
			document.f_test1.cb[i].checked=1
			else
				document.f_test1.cb[i].checked=0
	}
}//end of test
const next=()=>{
	let dap=1;
	for(let i=0;i<document.f_test1.cb.length;i++){
		if(document.f_test1.cb[i].checked==1){
			document.f_test1.htest1.value=dap;//밑에 value=3
		}else{
			dap=dap+1
		}
	}
	document.f_test1.submit();
}
const prev=()=>{
	//location.href속성으로 페이지를 전환하는건 SPA는 맞지않음
	//리액트-> const navigate=useNavigate();
	//navigate("./testForm1.jsp")
	window.location.href="testForm3.jsp";
}
</script>
</head>
<body>
<form name="f_test1" method="get" action="testForm5.jsp">
<input type="hidden" name="htest4">
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