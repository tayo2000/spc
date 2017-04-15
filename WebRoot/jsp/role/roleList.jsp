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
	<script type="text/javascript" src="js/role.js"></script>
</head>
<body class="easyui-layout" >	
		<!-- 角色列表   有工具栏 -->
		<table id="dg" title="角色列表" class="easyui-datagrid" style="width:100%;height:auto" 
			url="roleList.action" toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true" >
			<thead>
				<tr>
					<th field="roleId" width="50">角色编号</th>
					<th field="roleName" width="50">角色名称</th>
					<th field="roleDesc" width="50">角色描述</th>
				</tr>
			</thead>
		</table>
		<!-- 工具栏 -->
		<div id="toolbar">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addRole()">添加</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRole()">编辑</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRole()">删除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="openAuth()">分配权限</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="refreshRole()">刷新</a>
		</div>
	
	<!-- 对话框 -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:auto;font-size:14px;" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem clearfloat">
				<label>角色编号：</label>
				<input class="finput" id="roleId" name="roleId" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>角色名称：</label>
				<input class="finput" id="roleName" name="roleName" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>角色描述：</label>
				<input class="finput" id="roleDesc" name="roleDesc" type="text"/>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRole()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	
	<div id="dlg2"  class="easyui-dialog"  
		 data-options="iconCls:'icon-save', 
				  closed:true,
				  title:'分配权限',
				  modal:true,
				  buttons:'#dlg2-buttons'" 
		 style="width:420px;height:auto;padding:10px 20px ">
		 <table style="padding:5px;">
		 	<tr>
		 		<td  style="padding:5px;">
		 			<div id="authList" class="easyui-datalist" title="可选权限列表" style="width:150px;height:300px;" data-options="
			            url: 'authList.action',
			            singleSelect: false,
			            textField:'authName',
			            valueField:'authId'
			            ">
		   		   </div>
		 		</td>
		 		<td>
		 			<input type="button" onclick="leftToRight()" value=">>"/>
		 				<br/><br/>
		 			<input type="button" onclick="rightToLeft()" value="<<"/>
		 		</td>
		 		<td style="padding:5px;">
		 			<div id="authSelectedList" class="easyui-datalist" title="已选权限列表" style="width:150px;height:300px;" data-options="
			            singleSelect: false,
			            textField:'authName',
			            valueField:'authId'
			            ">
		   		  </div>
		 		</td>
		 	</tr>
 		</table>
    </div>
    <div id="dlg2-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="assignAuth()">分配</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg2').dialog('close')">重置</a>
	</div>
</body>
</html>