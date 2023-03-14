<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리시스템</title>
<%@ include file="../common/easyUI_common.jsp" %>
</head>
<body>
<h3>우편번호찾기</h3>
<script>
$(document).ready(function(){
	$("#btn_search").linkbutton({
		onClick:function(){
			const u_dong=$("#_easyui_textbox_input1").val();/* 제이쿼리 문법. 값을 가져올때는 val */
			if(u_dong==null||u_dong.length<1){
				alert("동을 입력하세요");
				//동정보가 없으면 처음부터 새로 시박해야하니까...return을 썼다.
				return;
			}else{
				console.log(`사용자가 입력한 동 이름은${u_dong}`);
				//오라클 서버를 경유하여 조회된 결과를 dataGrid에 출력해보기
			}
		}
	})//end of 찾기버튼
	$('dong').textbox('textbox').bind('keydown',function(e){
		const u_)dong=
	})
})
</script>
<!--======================= 우편번호 검색기 =======================-->
<div id="dlg_zipcode" style="width:100%;max-width:600px;padding:30px 30px;">
	<input class="easyui-textbox" id="dong" name="dong" labelPosition="top" data-options="prompt:'동이름 이나 주소정보 입력...'" style="width:210px;">
	<a id="btn_search" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">찾기</a>
	<div  style="margin-bottom:10px;"></div>
	<table id="dg_zipcode">
	</table>
</div>
<!--======================= 우편번호 검색기 =======================-->
</body>
</html>