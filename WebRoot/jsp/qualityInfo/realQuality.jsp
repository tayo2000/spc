<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>实时质量</title>
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
					var url="jsp/rtv/rtvListLastest.jsp?fNo="+row.fNo;
					addTab("厂商编号："+row.fNo+"的实时质量",url);
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
</body>
</html>