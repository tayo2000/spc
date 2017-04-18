<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>用户列表</title>
	<link type="text/css" rel="stylesheet" href="css/default.css"/>
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
 	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
	<style>
		#north{height:30px;background:url("images/layout-north-bg.gif") #7f99be repeat-x center 50%;}
		#south{height:30px;background-color:#D2E0F2;}
		#west{width:180px;}
		#west ul li a:hover{cursor:pointer;}
		#center{background-color:#eee;}
		.accordion-collapse{background:url('images/panel_tool_collapse.gif')}
		.accordion-expand{background:url('images/panel_tool_expand.gif')}
		.fitem .finput{width:70%;}
	</style>
</head>
<body class="easyui-layout" >	
		<!-- 用户列表   有工具栏 -->
		<table id="dg" title="用户列表" class="easyui-datagrid" style="width:100%;height:auto" 
			url="userList.action" toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true" >
			<thead>
				<tr>
					<th field="username" width="50">用户名称</th>
					<th field="password" width="50" hidden="true" >密码</th>  <!-- 隐藏列 -->
					<th field="fNo" width="50">所属厂商</th>
					<th field="roleId" width="50">角色</th>
					<th field="email" width="50">电子邮件</th>
					<th field="loginCount" width="50">登陆次数</th>
					<th field="loginTime" width="50">最近登陆时间</th>
				</tr>
			</thead>
		</table>
		<!-- 工具栏 -->
		<div id="toolbar">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addNewUser()">添加</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editPassword()">修改密码</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUser()">删除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="javascript: $('#dg').datagrid('reload');">刷新</a>
		</div>
	
	<!-- 添加用户对话框 -->
	<div id="dlgAddUser" class="easyui-dialog" style="width:400px;height:auto;font-size:14px;" closed="true" buttons="#dlgAddUser-buttons">
		<form id="fmAddUser" method="post">
			<div class="fitem clearfloat">
				<label>用户：</label>
				<input class="finput" name="username" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>密码：</label>
				<input class="finput" name="password" type="password"/>
			</div>
			
			<div class="fitem clearfloat">
				<label>厂商：</label>
				<input class="easyui-combobox" style="width:60%;height:30px;font-size:14px;text-align:left;" 
				     id="fNo" name="fNo"  editable="false" panelHeight='auto'
					 data-options="valueField:'fNo',textField:'fNo',url:'factoryList.action'"/>  
			</div>
			
			<div class="fitem clearfloat">
				<label>角色：</label>
				<input class="easyui-combobox" style="width:60%;height:30px;font-size:14px;" 
				     id="roleId" name="roleId"  editable="false" panelHeight='auto'
					 data-options="valueField:'roleId',textField:'roleId',url:'roleList.action'"/>  
			</div>
			
			<div class="fitem clearfloat">
				<label>邮件：</label>
				<input class="finput" name="email" type="text"/>
			</div>
		</form>
	</div>
	<div id="dlgAddUser-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveNewUser()">保存信息</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgAddUser').dialog('close')">取消</a>
	</div>
	
	<!-- 编辑用户对话框 -->
	<div id="dlgEditUser" class="easyui-dialog" style="width:400px;height:auto;font-size:14px;" closed="true" buttons="#dlgEditUser-buttons">
		<form id="fmEditUser" method="post">
			<div class="fitem clearfloat">
				<label>用户：</label>
				<input class="finput" name="username" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>厂商：</label>
				<input class="easyui-combobox" style="width:60%;height:30px;font-size:14px;text-align:left;" 
				     id="fNo" name="fNo"  editable="false" panelHeight='auto'
					 data-options="valueField:'fNo',textField:'fNo',url:'factoryList.action'"/>  
			</div>
			
			<div class="fitem clearfloat">
				<label>角色：</label>
				<input class="easyui-combobox" style="width:60%;height:30px;font-size:14px;text-align:left;" 
				     id="roleId" name="roleId"  editable="false" panelHeight='auto'
					 data-options="valueField:'roleId',textField:'roleId',url:'roleList.action'"/>  
			</div>
			<div class="fitem clearfloat">
				<label>邮件：</label>
				<input class="finput" name="email" type="text"/>
			</div>
		</form>
	</div>
	<div id="dlgEditUser-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="updateUser()">保存信息</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgEditUser').dialog('close')">取消</a>
	</div>
	
	<!--修改密码对话框 -->
	<div id="dlgEditPassword" class="easyui-dialog" style="width:450px;height:auto;font-size:14px;" closed="true" buttons="#dlgEditPassword-buttons">
		<form id="fmEditPassword" method="post">
			<div class="fitem clearfloat">
				<label>用户：</label>
				<input class="finput" name="username" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>输入新密码：</label>
				<input class="finput"  name="password1" type="text"/>
			</div> 
			<div class="fitem clearfloat">
				<label>再次确认密码：</label>
				<input class="finput"  name="password2" type="text"/>
			</div>
		</form>
	</div>
	<div id="dlgEditPassword-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="savePassword()">保存密码</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgEditPassword').dialog('close')">取消</a>
	</div>
	
</body>
</html>