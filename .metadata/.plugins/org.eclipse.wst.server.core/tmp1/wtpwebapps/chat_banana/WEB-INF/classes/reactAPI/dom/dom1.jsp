<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="root"></div>
 <script
      crossorigin
      src="https://unpkg.com/react@18/umd/react.development.js"
    ></script>
    <script
      crossorigin
      src="https://unpkg.com/react-dom@18/umd/react-dom.development.js"
    ></script>
    <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<script type="text/babel">
	const rootElement =document.querySelector("#root");
	//h1Element.textContext="DOM Make";이 코드와 같은 효과
	//React는 react.development.js에서 참조하는 객체임
	const h1Element=React.createElement("h1",{childeren:"DOM Make"});
	//Client sode rendering시 앞에가 주입할 대상이고 뒤에가 root위치임
	//rootElement.appendChild(h1Element);
	//react-dom.development.js에서 참조하는 객체이다.
	ReactDOM.createRoot(rootElement).render(h1Element);
</script>
</body>
</html>
<!-- 
확장자는 jsp이지만 mime type이 html이므로 html문서이다. 확장자에 속지말자!!
 -->