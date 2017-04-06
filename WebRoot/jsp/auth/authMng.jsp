<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>权限分配</title>
	<link type="text/css" rel="stylesheet" href="css/default.css"/>
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
 	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/auth.js"></script>
	<script type="text/javascript">
		function formatOper(val,row,index){  
			return "<input type='checkbox' name='"+val+"'>";
		}
		
		function grantAuth(){
			$('#fm').form('submit',{
				url: "authMng.action",
				onSubmit: function(){
					return $(this).form('validate');
				},
				success:function(data){
					parent.$('#tabs').tabs('close',"配置权限");
					var selTab=parent.$('#tabs').tabs('select',"权限列表");
					var url =$(selTab.panel('options').content).attr('src');
					 $('#tabs').tabs('update', {
					        tab : selTab,
					        options : {href : url}
					 });
				}
			});
		}
	</script>
</head>
<body>	
	<div class="easyui-panel" title="模块的权限分配"
        style="width:100%;height:auto;padding:10px;background:#fafafa;"
        data-options="iconCls:'icon-save',collapsible:true,footer:'#ft'">
   			<form id="fm" method="post">
   			<table id="dg" class="easyui-datagrid" singleSelect="true" url="moduleList2.action">
   				<thead>
	   				<tr>
	   					<th field="moduleId"   width="100">模块代号</th>
	   					<th field="moduleName" width="150">模块名</th>
	   					<th field="ckbAdd"     width="50" formatter="formatOper" align="center">添加</th>
	   					<th field="ckbDelete"  width="50" formatter="formatOper" align="center">删除</th>
	   					<th field="ckbUpdate"  width="50" formatter="formatOper" align="center">修改</th>
	   					<th field="ckbList"    width="50" formatter="formatOper" align="center">查询</th>	
	   				</tr>
   				</thead>
   			</table>
   			</form>
	</div>
	<div id="ft" style="padding:5px 0;">
		<a onclick="grantAuth()" class="easyui-linkbutton" data-options="iconCls:'icon-save'" style="width:80px">设置权限</a>
		<a onclick="javascript: $('#fm')[0].reset();" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" style="width:80px">重置列表</a>
	</div>
</body>
</html>