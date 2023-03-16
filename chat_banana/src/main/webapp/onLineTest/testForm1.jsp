<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!--  react->nextjs->typescript추가 ->ECMAScript-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제 1</title>
<script type="text/javascript">
	const test=(cb)=>{
		for(let i=0;i<document.f_test1.cb.length;i++){
			if(cb===i)
				document.f_test1.cb[i].checked=1
				else
					document.f_test1.cb[i].checked=0
		}
	}//end of test
	//다음 페이지 처리
	//document는 이 문서(testForm.jsp->SSR->html->다운로드->text파일 덩어리)를 가리킨다.
	//document의 최상위 객체는 window객체
	//브라우저안에서 인스턴스화 없이 사용가능
	//document.f_test1.cb 네임이 같은게 두개 이상일때는 브라우저가 배열로 자동변환
	//checked는 checkbox에서 선택된 상태일때 처리하는 속성임
	//1이면 선택0이면 비선택 //JS에서 0은 false이고 나머지는 모두 true이다.
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
	
</script>
</head>
<body>
	<!-- 쿠키를 이용해서 문제의 답을 유지해보자~! -->
	<form name="f_test1" method="get" action="testForm2.jsp">
		<!-- 눈에 보이지않게 변수 정의하기 위해서 hidden 사용 ~ 화면에는 드러나지 않아도 내부적으로 정보 전달시 사용 -->
		<input type="hidden" name="htest1" value=3>
		문제1. 다음 중 DML구문이 아닌 것을 고르시오. <br>
		<input type="checkbox" name="cb" onChange="test(0)">select <br>
		<input type="checkbox" name="cb" onChange="test(1)">insert <br>
		<input type="checkbox" name="cb" onChange="test(2)">create <br>
		<input type="checkbox" name="cb" onChange="test(3)">delete <br>
		<br> <input type="button" value="다음문제" onClick="next()">
	</form>
</body>
</html>