<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>权限列表</title>
	<link type="text/css" rel="stylesheet" href="css/default.css"/>
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
 	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/auth.js"></script>
</head>
<body class="easyui-layout" >	
		<!-- 权限列表   有工具栏 -->
		<table id="dg" title="权限列表" class="easyui-datagrid" style="width:100%;height:auto" 
			url="authList.action" toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true" >
			<thead>
				<tr>
					<th field="authId" width="50">权限代号</th>
					<th field="authName" width="50">权限名称</th>
					<th field="authDesc" width="50">权限描述</th>
					<th field="url" width="50">访问地址</th>
					<th field="moduleId" width="50">模块代号</th>
				</tr>
			</thead>
		</table>
		<!-- 工具栏 -->
		<div id="toolbar">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addAuth()">添加</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editAuth()">编辑</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteAuth()">删除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="refreshAuth()">刷新</a>
		</div>
	
	<!-- 对话框 -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:auto;font-size:14px;" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem clearfloat">
				<label>权限代号：</label>
				<input class="finput" id="authId" name="authId" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>权限名称：</label>
				<input class="finput" id="authName" name="authName" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>权限描述：</label>
				<input class="finput" id="authDesc" name="authDesc" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>访问地址：</label>
				<input class="finput" id="url" name="url" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>模块代号：</label>
				<input class="easyui-combobox" style="width:60%;height:30px;font-size:14px;text-align:left;" 
				     id="moduleId" name="moduleId"  editable="false" panelHeight='auto'
					 data-options="valueField:'moduleId',textField:'moduleName',url:'moduleList.action'"/>  
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAuth()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</body>
</html>