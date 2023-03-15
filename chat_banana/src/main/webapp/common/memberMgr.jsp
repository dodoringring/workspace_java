<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리시스템</title>
<%@ include file="../common/easyUI_common.jsp"%>
</head>
<body>
	<h3>우편번호찾기</h3>
	<script>
		$(document).ready(function() {
			$("#btn_zipcode").linkbutton({
				onClick : function() {
					$("#dlg_zipcode").dialog({
						title : '우편번호 찾기',
						width : 400,
						height : 200,
						closed : false,
						cache : false,
						href : 'zipcodeList.jsp',
						modal : true
					});
				}

			})//end of 찾기버튼
			$('#dong').textbox('textbox').bind('keydown',function(e){
				if(e.keyCode==13){//키값이 13번 입니다.
					$('#dg_zopcode').datagrid({
						url:"/common/zipcodeList.st3?dong="+$(this).val(),
						columns:[[
							{field:'ZIPCODE', title:'우편번호', width:100},
							{field:'ADDRESS', title:'주소', width:300, align:'left'}
						]],
						singleSelect:true,
						onSelect:function(index, row){
							g_address=row.ADDRESS
						}
					onDblClickCell:function(index,field, value){
						fi("ZIPCODE"==field){
						$('#mem_zipcode').textbox('setValue', value)
						$('#mem_addr').textbox('setValue', g_address)
						}
					}
					});
				}
			})
			
		})//end of ready-DOM Tree가 다 그려졌을때
	</script>
	<div id="dlg_zipcode">Dialog Content</div>


	<!--======================= 회원가입 =======================-->
	<div id="dlg_ins"
		style="width: 100%; max-width: 480px; padding: 30px 60px;">
		<form id="f_ins">
			<input type="hidden" id="work" name="work" value="member" />
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" id="mem_id" name="mem_id" label="아이디:"
					labelPosition="top" data-options="prompt:'Enter a ID'"
					style="width: 110px;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" id="mem_name" name="mem_name"
					label="이름:" labelPosition="top"
					data-options="prompt:'Enter a Name'" style="width: 150px;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" id="mem_zipcode" name="mem_zipcode"
					label="우편번호:" labelPosition="top"
					data-options="prompt:'Enter a ZipCode'" style="width: 100px;">
				<a id="btn_zipcode" href="#" class="easyui-linkbutton">우편번호찾기</a>
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" id="mem_addr" name="mem_addr"
					label="주소:" labelPosition="top"
					data-options="prompt:'Enter a ADDRESS'" style="width: 300px;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" id="mem_pw" name="mem_pw" label="비번:"
					labelPosition="top" data-options="prompt:'Enter a PASSWORD'"
					style="width: 110px;">
			</div>
		</form>
	</div>
	<div id="tb_ins" style="padding: 5px;">
		<a id="btn_save" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save'">저장</a> <a id="btn_close" href="#"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">닫기</a>
	</div>
	<!--======================= 회원가입 =======================-->
</body>
</html>