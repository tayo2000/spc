<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>质量特性列表</title>
	
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
	<link type="text/css" rel="stylesheet"  href="css/default.css" />
	
 	<script src="easyui/jquery.min.js"></script>
	<script src="easyui/jquery.easyui.min.js"></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="js/common.js"></script>
	<script src="js/feature.js"></script>
</head>

<body  class="easyui-layout"  style="overflow-y: scroll">
	<table id="dg" title="产品编号：[${param.pNo}]的特性列表 " class="easyui-datagrid" style="width:100%;height:auto"
		   url="featureList.action?pNo=${param.pNo}&fNo=${param.fNo}"
		   toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true" >
		<thead>
			<tr>
				<th field="qfNo" width="10%">特性编号</th>
				<th field="qfName" width="30%">特性名称</th>
				<th field="fNo" width="10%">所属厂商</th>
				<th field="pNo" width="10%">所属产品</th>
				<th field="usl" width="5%">上限值</th>
				<th field="lsl" width="5%">下限值</th>
				<th field="sl" width="5%">均值</th>
				<th field="unit" width="10%">单位</th>
			</tr>
		</thead>
	</table>
	<!-- 工具栏 -->
	<div id="toolbar">
		<a class="easyui-linkbutton" iconCls="icon-add"    plain="true" onclick="addFeature('${param.fNo}','${param.pNo}')">添加</a>
		<a class="easyui-linkbutton" iconCls="icon-edit"   plain="true" onclick="editFeature()">编辑</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteFeature()">删除</a>
		<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reloadFeature()">刷新</a>
	</div>
	   
	<!-- 对话框 -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:auto;font-size:14px;" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem clearfloat">
				<label>厂商编号：</label>
				<input class="finput" id="fNo" name="fNo" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>产品编号：</label>
				<input class="finput" id="pNo" name="pNo" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>特性编号：</label>
				<input class="finput" id="qfNo" name="qfNo" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>特性名称：</label>
				<input class="finput" id="qfName" name="qfName" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>上限值：</label>
				<input class="finput" id="usl" name="usl" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>下限值：</label>
				<input class="finput" id="lsl" name="lsl" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>均值：</label>
				<input class="finput" id="lsl" name="sl" type="text"/>
			</div>
			<div class="fitem clearfloat">
				<label>计量单位：</label>
				<input  class="finput" id="unit" name="unit" type="text"/>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveFeature()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</body>
</html>