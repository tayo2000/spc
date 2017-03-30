<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>厂商列表</title>
	<link type="text/css" rel="stylesheet" href="css/default.css"/>
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
 	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/factory.js"></script>
	<style>
		#north{height:30px;background:url("images/layout-north-bg.gif") #7f99be repeat-x center 50%;}
		#south{height:30px;background-color:#D2E0F2;}
		#west{width:180px;}
		#west ul li a:hover{cursor:pointer;}
		#center{background-color:#eee;}
		.accordion-collapse{background:url('images/panel_tool_collapse.gif')}
		.accordion-expand{background:url('images/panel_tool_expand.gif')}
	</style>
	<script>
		$(function(){
			$("#dg").datagrid({
				onDblClickRow:function(rowIndex,rowData){
					var row = $('#dg').datagrid('getSelected');
					if(!row) return;
					var url="jsp/product/productList.jsp?fNo="+row.fNo;
					addTab("厂商编号："+row.fNo+"的产品列表",url);
				}
			})
		})
	</script>
</head>
<body class="easyui-layout" >	
		<!-- 厂商列表   有工具栏 -->
		<table id="dg" title="厂商列表" class="easyui-datagrid" style="width:100%;height:auto" 
			url="factoryList.action" toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true" >
			<thead>
				<tr>
					<th field="fNo" width="50">厂商编号</th>
					<th field="fName" width="50">厂商名称</th>
					<th field="fType" width="50">厂商类型</th>
					<th field="fInfo" width="50">备注</th>
				</tr>
			</thead>
		</table>
		<!-- 工具栏 -->
		<div id="toolbar">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addFactory()">添加</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editFactory()">编辑</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteFactory()">删除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="refreshFactory()">刷新</a>
		</div>
	
	<!-- 对话框 -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:auto;font-size:14px;" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem clearfloat">
				<label>厂商编号：</label>
				<input class="finput" id="fNo" name="fNo" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>厂商名称：</label>
				<input class="finput" id="fName" name="fName" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>厂商类型：</label>
				<input class="finput" id="fType" name="fType" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>基本信息：</label>
				<textarea class="finput" style="height:70px;" id="pType"  name="fInfo" cols="30" rows="4"></textarea>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFactory()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</body>
</html>