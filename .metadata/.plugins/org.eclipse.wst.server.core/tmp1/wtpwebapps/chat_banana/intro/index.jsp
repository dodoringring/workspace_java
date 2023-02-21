<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String smem_id=(String)session.getAttribute("smem_id");
String smem_name=(String)session.getAttribute("smem_name");
out.print("세션에서 꺼내온 값===>"+smem_id+" , "+smem_name);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Web Application</title>
	<%@include file = "../common/easyUI_common.jsp" %>
	<style type="text/css">
	a{
	text-decoration:none;
	}
	</style>
	<script>
	const login=()=>{
		/*
		select mem_name from book_member
	    where mem_id=:id
	    and mem_pw=:pw
	    */
	    //사용자가 입력한 아이디 가져오기
	    const user_id=$("#_easyui_textbox_input1").val();
	    //사용자가 입력한 비번 가져오기
	    const user_pw=$("#_easyui_textbox_input2").val();
	    alert(user_id+user_pw);
	    //
	}
	</script>
</head>
<body>
    <h2>[[웹 어플리케이션 실습]]</h2>
    <div style="margin:20px 0;"></div>
    <div class="easyui-layout" style="width:1000px;height:550px;">
        <div id="p" data-options="region:'west'" title="kh정보교육원" style="width:30%;padding:10px">
<!-- ===========[[로그인 화면]]====================-->
<div id="d_login" align="center"></div>
<input id="tb_id" type="text" style="width:170px">
<script>
$('#tb_id').textbox({
    iconCls:'icon-man',
    iconAlign:'right',
    prompt:'아이디'
})</script>
<div style="margin:3px 0;"></div>
<input id="pb_pw" type="text" style="width:170px">
<script>
    $('#pb_pw').passwordbox({
        prompt: 'Password',
        showEye: true
    });
</script>
<div style="margin:3px 0;"></div>
<a id="btn_login" href="javascript:login()">로그인</a>
<script>
$('#btn_login').linkbutton({
    iconCls: 'icon-search'
});
</script>

<a id="btn_member" href="javascript:memeberShip()">회원가입</a>
<script>
$('#btn_member').linkbutton({
    iconCls: 'icon-search'
});
</script>

<!-- ===========[[로그아웃 화면]]====================-->
<div id="d_logout" align="center"></div>
<!-- 메뉴구성[로그인 화면과 트리메뉴] -->
	<div style="margin:3px 0;"></div>
		<ul id="tre_gym" class="easyui-tree">
		    <li data-options="state:'closed'">
		        <span>회원관리</span>
		        <ul>
		            <li><a href="#">회원목록</a></li>
		            <li><a href="#">회원등록</a></li>
		            <li><a href="#">회원삭제</a></li>
		        </ul>
		    </li>
		</ul>
</div>
<!-- 메인화면 [게시판,온라인시험,회원관리(회원목록,회원등록,회원삭제),우편번호 검색기 ]-->
        <div data-options="region:'center'" title="Center">
        
        </div>
    </div>
</body>
</html>
<!-- 
부트스트랩
반응형지원, CSS라이브러리 사용
jEasyUI
이벤트 처리(jquery-레거시 시스템)
자바스크립트-표준은 아님
 -->