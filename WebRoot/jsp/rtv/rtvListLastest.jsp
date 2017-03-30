<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>质量实时监测数据</title>
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
	<link type="text/css" rel="stylesheet"  href="css/default.css" />
	<style>
		#autoRefresh{
			cursor:pointer;
		}
	</style>
 	<script src="easyui/jquery.min.js"></script>
	<script src="easyui/jquery.easyui.min.js"></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="js/common.js"></script>
	<script src="js/rtv.js"></script>
	<script>
	var refreshTime=5000;
	var timer;
	var autoFlag=true;
	$(function(){
		timer=setInterval("reloadRTV()", refreshTime); 
		$("#autoRefresh").click(function(){
			if(autoFlag) {
				if(timer!=null ) clearInterval(timer);
				$(this).linkbutton({text:'开始自动刷新'});
				autoFlag=false;
				$('#timeSelectSpan').hide();
			}else{
				$(this).linkbutton({text:'停止自动更新'});
				autoFlag=true;
				$('#timeSelectSpan').show();
				refreshTime=$('#timeSelect').combobox('getValue')*1000;
				timer=setInterval("reloadRTV()", refreshTime); 
			}
		})
		$("#timeSelect").combobox({
			onChange: function (newValue,oldValue) {
				if(timer!=null ) clearInterval(timer);
				refreshTime=newValue*1000;
				timer=setInterval("reloadRTV()", refreshTime); 
			}
		});
	});
	
	function formatOper(val,row,index){  
		var usl=row.usl;
		var lsl=row.lsl;
		var real=row.realValue;
		if(real>usl || real<lsl){
			return '<font color="white">NOK</font>';
		}else{
			return '<font color="white">OK</font>';
		}
	}  
	
	function styleOper(val,row,index){  
		var usl=row.usl;
		var lsl=row.lsl;
		var real=row.realValue;
		if(real>usl || real<lsl){
			return 'background-color:#f00;';
		}else{
			return 'background-color:#0f0;';
		}
	}  
	</script>
</head>

<body  class="easyui-layout"  style="overflow-y: scroll">
	<table id="dg" title="厂商编号：【${param.fNo}】" class="easyui-datagrid" style="width:100%;height:auto"
		   url="rtvListLastest.action?fNo=${param.fNo}" 
		   toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true" striped="true">
		<thead>
			<tr>
				<th field="fNo" width="5%">厂商编号</th>
				<th field="pNo" width="5%">产品编号</th>
				<th field="qfNo" width="5%">特性编号</th>
				<th field="qfName" width="20%">特性名称</th>
				<th field="realTime" width="20%">采集时间</th>
				<th field="usl" width="5%">上限值</th>
				<th field="lsl" width="5%">下限值</th>
				<th field="realValue" width="10%">实时值</th>
				<th field="checkInfo" formatter="formatOper"  styler="styleOper" width="5%">判断结果</th>
			</tr>
		</thead>
	</table>
	
	<!-- 工具栏 -->
	<div id="toolbar" >
		<span id="timeSelectSpan" >刷新时间（单位秒）：
			<select class="easyui-combobox" id="timeSelect" style="width:80px;">
				<option value="3" selected>3秒</option>
				<option value="5">5秒</option>
				<option value="10">10秒</option>
				<option value="30">30秒</option>
				<option value="60">60秒</option>
			</select>
		</span> 
		<a class="easyui-linkbutton" id="autoRefresh" iconCls="icon-reload" plain="true">停止自动刷新</a>
		<a class="easyui-linkbutton"  iconCls="icon-reload" plain="true" onclick="reloadRTV()">手工刷新</a>
	</div>
</body>
</html>