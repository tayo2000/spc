<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>模块列表</title>
	<link type="text/css" rel="stylesheet" href="css/default.css"/>
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
 	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/module.js"></script>
</head>
<body class="easyui-layout" >	
		<!-- 模块列表   有工具栏 -->
		<table id="dg" title="模块列表" class="easyui-datagrid" style="width:100%;height:auto" 
			url="moduleList.action"  toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true" striped="true"  >
			<thead>
				<tr>
					<th field="moduleId" width="50">模块编号</th>
					<th field="moduleName" width="50">模块名称</th>
					<th field="moduleDesc" width="50">模块描述</th>
				</tr>
			</thead>
		</table>
		<!-- 工具栏 -->
		<div id="toolbar">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addModule()">添加</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editModule()">编辑</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteModule()">删除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="refreshModule()">刷新</a>
		</div>
	
	<!-- 对话框 -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:auto;font-size:14px;" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem clearfloat">
				<label>模块编号：</label>
				<input class="finput" id="moduleId" name="moduleId" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>模块名称：</label>
				<input class="finput" id="moduleName" name="moduleName" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>模块描述：</label>
				<input class="finput" id="moduleDesc" name="moduleDesc" type="text"/>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveModule()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</body>
</html>