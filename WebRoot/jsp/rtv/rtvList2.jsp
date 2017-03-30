<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>质量特性历史监测数据</title>
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
	<link type="text/css" rel="stylesheet"  href="css/default.css" />
 	<script src="easyui/jquery.min.js"></script>
	<script src="easyui/jquery.easyui.min.js"></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="js/common.js"></script>
	<script src="js/rtv.js"></script>
	<script>
	$(function(){
		$('#dg').datagrid({
			rowStyler: function(index,row){
				var usl=row.usl;
				var lsl=row.lsl;
				var real=row.realValue;
				if(real>usl || real<lsl){
					return 'background-color:#ff0;color:#f00;';
				}
			}
		});
		//setInterval("reloadRTV()", 5000); 
	})
	</script>
</head>

<body  class="easyui-layout"  style="overflow-y: scroll">
	<table id="dg" title="产品编号：[${param.pNo} - ${param.qfNo}] " class="easyui-datagrid" style="width:100%;height:auto"
		   url="rtvList.action?pNo=${param.pNo}&qfNo=${param.qfNo}" pagination="true" 
		   toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true" striped="true" pageSize="20">
		<thead>
			<tr>
				<th field="pNo" width="5%">产品编号</th>
				<th field="qfNo" width="5%">特性编号</th>
				<th field="qfName" width="15%">特性名称</th>
				<th field="usl" width="5%">上限值</th>
				<th field="lsl" width="5%">下限值</th>
				<th field="sl" width="5%">均值</th>
				<th field="realValue" width="10%" >监测值</th>
				<th field="realTime" width="15%" >监测时间</th>
			</tr>
		</thead>
	</table>
	<!-- 工具栏 -->
	<div id="toolbar">
		<a class="easyui-linkbutton" iconCls="icon-add"    plain="true" onclick="#">添加</a>
		<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reloadRTV()">刷新</a>
	</div>
</body>
</html>