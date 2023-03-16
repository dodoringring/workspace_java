<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String mem_id = (String)session.getAttribute("smem_id");
	String mem_name = (String)session.getAttribute("smem_name");
	out.print("세션에서 꺼내온 값 ===> " + mem_id + ", " + mem_name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Application</title>
<%@include file="../common/easyUI_common.jsp"%>
<script type="text/javascript">
	const login = () => {
		/*
			SELECT mem_name FROM book_member
			WHERE mem_id =:id
			AND mem_pw =:pw
		*/
		//사용자가 입력한 아이디 가져오기
		const user_id = $("#_easyui_textbox_input1").val();
		//사용자가 입력한 비번 가져오기
		const user_pw = $("#_easyui_textbox_input2").val();
		alert(user_id + user_pw);
	}
</script>
</head>
<body>
	<h2>웹 어플리케이션 실습</h2>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 1000px; height: 550px;">
		<!-- 메뉴 구성 [로그인 화면과 트리 메뉴] -->
		<div id="p" data-options="region:'west'" title="West"
			style="width: 30%; padding: 10px">
			<!-- ==================[[로그인 화면]]================== -->
			<div id="d_login" align="center">
				<!-- create table member mem_id varchar2(10) -->
				<input id="tb_id" type="text" style="width: 170px">
				<script>
					$('#tb_id').textbox({
						iconCls : 'icon-man',
						iconAlign : 'right',
						prompt : '아이디'
					})
				</script>
				<div style="margin: 3px 0;"></div>
				<input id="pb_pw" type="text" style="width: 170px">
				<script>
					$(function() {
						$('#pb_pw').passwordbox({
							prompt : 'Password',
							showEye : true
						});
					});
				</script>
				<div style="margin: 3px 0;"></div>
				<a id="btn_login" href="javascript:login()">로그인</a>
				<script type="text/javascript">
					$('#btn_login').linkbutton({
						iconCls : 'icon-man'
					});
				</script>
				<a id="btn_member" href="javascript:signup()">회원가입</a>
				<script type="text/javascript">
					$('#btn_member').linkbutton({
						iconCls : 'icon-add'
					});
				</script>
			</div>
			<!-- ==================[[로그아웃 화면]]================== -->
			<div id="d_logout" align="center"></div>

			<!-- 메뉴 구성 [로그인 화면과 트리메뉴] -->
			<div style="margin: 3px 0;"></div>
			<ul id="tree_gym" class="easyui-tree">
				<li data-options="state:'closed'"><span>회원관리</span>
					<ul>
						<li><a href="#">회원목록</a></li>
						<li><a href="#">회원등록</a></li>
						<li><a href="#">회원삭제</a></li>
					</ul></li>
				<li><span>File21</span></li>
			</ul>
		</div>
		<!-- 메인 화면 [게시판, 온라인 시험, 쪽지관리(받은 쪽지함, 보낸 쪽지함), 회원관리(회원목록, 회원등록, 회원삭제), 우편번호 검색기] -->
		<div data-options="region:'center'" title="Center"></div>
		<!-- 메인 화면 [게시판, 온라인 시험, 회원관리, 우편번호 검색기] -->
	</div>
</body>
</html>
<!--
부트스트랩 - 리액트 수업 -> Spring과 리액트 연계 수업 -> 프로젝트에서 적용
반응형 지원, CSS 라이브러리 사용
CSS - JS 거의 없음
jEasyUI
이벤트 처리(jquery - 레거시 시스템)
자바스크립트 - 표준 아님 -> jquery 기반이라서
자바스크립트 기반의 UI 솔루션 사용하기 - 큰 도움
개발자 도구 활용 - 디버깅 -> 왜냐하면 html을 래핑하기 때문에
vue.js react.js

JSTL사용 - 1.1 -> 1.2 -> 소개

로그인 테스트 흐름도
1. intro아래 index.jsp실행
2. 아이디와 비번을 입력받는다
3. 로그인버튼을 누른다 -> 자바스크립트의 login()호출
4. login.do를 호출한다 -> 로그인 처리를 하는 서블릿 호출
5. com.mvc.dao.MemberDao클래스의 인스턴스화
6. 메소드 호출 - 로그인처리
7. MemberDao의 Login(Map[mem_id와 mem_pw~사용자 입력값]) 호출
8. 리턴타입으로 Map을 받아온다(mem_id, mem_name)
9. 8번에서 돌려받은 Map에서 오라클 서버에서 조회된 아이디와 이름을 세션에 담기
10. 그리고 페이지 이동
	페이지 이동은 sendRedirect나 forwoard둘다 모두 가능하다
	단 forward로 응답을 처리한 경우 인증 후에 다른 서비스를 forward로 처리하는 것이 불가함 - 주의
-->