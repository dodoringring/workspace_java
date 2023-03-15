<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 list</title>
<%@ include file="./easyUI_common.jsp"%>
</head>
<body>
	<script type="text/javascript">
		//ready ~ dom구성이 완료되었을 때
		$(document).ready(function() {
			$("#btn_search").linkbutton({
				onClick : function() {
					const u_dong = $("#_easyui_textbox_input1").val();
					console.log(u_dong);
					if (u_dong == null || u_dong.length < 1) {
						alert("동을 입력하세요.");
						//동 정보가 없으면 처음부터 새로 시작해야하니까 return
						return;
					} else {
						console.log('사용자가 입력한 동 이름은' + u_dong);
						//오라클 서버를 경유해서 조회된 결과를 dataGrid에 출력해보기
						$('#dg_zipcode').datagrid({
							url : '/common/zipcodeList.st3?dong=' + u_dong,
							columns : [ [ {
								field : 'ZIPCODE',
								title : '우편번호',
								width : 100,
								align : 'center'
							}, {
								field : 'ADDRESS',
								title : '주소',
								width : 300,
								align : 'left'
							} ] ]
						});
					}
				}
			})
			$('#dong').textbox('textbox').bind('keydown', function(e) {
				if (e.keyCode == 13) {
					//이미 #dong에 접근을 한 상태이기 때문에 아래에서 this.val로 접근할 수 있는 모양.
					$('#dg_zipcode').datagrid({
						url : '/common/zipcodeList.st3?dong=' + $(this).val(),
						columns : [ [ {
							field : 'ZIPCODE',
							title : '우편번호',
							width : 100,
							align : 'center'
						}, {
							field : 'ADDRESS',
							title : '주소',
							width : 300,
							align : 'left'
						} ] ]
					});
				}
			})
		})
	</script>
	<!--======================= 우편번호 검색기 =======================-->
	<div id="dlg_zipcode"
		style="width: 100%; max-width: 600px; padding: 30px 30px;">
		<input class="easyui-textbox" id="dong" name="dong"
			labelPosition="top" data-options="prompt:'동이름 이나 주소정보 입력...'"
			style="width: 210px;"> <a id="btn_search" href="#"
			class="easyui-linkbutton" data-options="iconCls:'icon-search'">찾기</a>
		<div style="margin-bottom: 10px;"></div>
		<table id="dg_zipcode"></table>
	</div>
	<!--======================= 우편번호 검색기 =======================-->
</body>
</html>