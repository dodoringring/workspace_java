<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String dap4=request.getParameter("htest4");
out.print("4 문제 답안지"+dap4);//숫자 더하기 문자는 문자이다.
//쿠키에는 문자열만 담을 수 있으므로 드냥 2를 쓰면 컴파일 에러임
Cookie c4=new Cookie("testForm1",dap4);
	c4.setPath("/onLineTest");
	c4.setMaxAge(60*60);//평가시간이 60분일때 시간 설정값이다.
	response.addCookie(c4);
	//단위 테스트 URL은 다음과 같습니다 
	//http://localhost:9000/onLineTest/testForm6.jsp?htest1=2&htest2=1&htest3=4&htest4=1&htest5=3
	//1번 부터 5번까지 작성한 답안지의 값을 쿼리스트링으로 받아야 하므로 문제지는 testForm5.jsp에서 끝났다 하더라도 
	//1번 부터 5번까지의 답안지를 가지고 있는 testForm5.jsp에서 값을 모두 읽어들인 후 
	//채점을 하는 testAccount.jsp페이지로 이동시켜야 합니다.
	//반복되는 작업이고 문제 수가 많아지면 그 만큼 많은 값을 쿼리스트링으로 끝없이 넘겨야 하므로 비효율적이다.
	//그래서 유지의 문제는 중요하고 여기서는 쿠키를 사용하여 개선해 보도록 한다 
	response.sendRedirect("testAccount.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제 5</title>
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
	window.location.href="testForm4.jsp";
}
</script>
</head>
<body>
<form name="f_test1" method="get" action="testForm6.jsp">
<!-- 
	최초에는 쿼리스트링으로 넘기고 있어서 처음 입력한 답안을 계속 기억기 어려워
	페이지 이동 할 때 마다 계속 달고다녀야했다.
	지금은 현재페이지에서 이전 문제에 대한 답안 한개만 request.getParameter로 가져오면 됨
	현재 문제에 대한 답은 
 -->
<input type="hidden" name="htest1">
<input type="hidden" name="htest2">
<input type="hidden" name="htest3">
<input type="hidden" name="htest4">
<input type="hidden" name="htest5">
	문제5. 다음 중 프로시저에 대한 설명으로 틀린 것을 고르시오.
	<br>
	<input type="checkbox" name="cb" onChange="test(0)"> 프로시저를 생성할
	때 파라미터를 선언할 수 있다.
	<br>
	<input type="checkbox" name="cb" onChange="test(1)"> 파라미터에 여러
	변수를 선언할 수 있다.
	<br>
	<input type="checkbox" name="cb" onChange="test(2)"> 프로시저안에서
	SELECT,INSERT,UPDATE, DELETE 모두 사용 할 수 있다.
	<br>
	<input type="checkbox" name="cb" onChange="test(3)"> 프로시저 안에서
	commit할 수 없다.
	<br>
	<br>
	<input type="button" value="이전문제" onClick="prev()">
	<input type="button" value="다음문제" onClick="next()">
</body>
</html>