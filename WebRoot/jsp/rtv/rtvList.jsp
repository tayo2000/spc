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
	<script>
	$(function(){
		$('#dg').datagrid({
			rowStyler: function(index,row){
				var usl=row.usl;
				var lsl=row.lsl;
				var real=row.realValue;
				if(real>usl || real<lsl){
					return 'background-color:#f00;color:#fff;';
				}
			}
		});
		
		$('#factoryList').combobox({
		    url:'factoryList.action',
		    valueField:'fNo',
		    textField:'fName',
		    onLoadSuccess: function () { //加载完成后,设置选中第一项  
                var val = $(this).combobox('getData');  
                for (var item in val[0]) {  
                    if (item == 'fNo') {  
                        $(this).combobox('select', val[0][item]);  
                    }  
                }  
            },  
		    onChange: function (newValue,oldValue) {
		    	$('#productList').combobox('reload', 'productListForCombo.action?fNo='+newValue);
				$('#dg').datagrid({
						url:'rtvList.action',
			        	queryParams:{'fNo':newValue}
			     });
				$('#dg').datagrid('reload');
			}
		});
		
		$('#productList').combobox({
		    valueField:'pNo',
		    textField:'pNo',
		    onChange: function (newValue,oldValue) {
		    	var fNo=$('#factoryList').combobox('getValue');
		    	var pNo=newValue;
		    	$('#featureList').combobox('reload', 'featureList.action?fNo='+fNo+'&pNo='+pNo);
		    	$('#dg').datagrid({
					url:'rtvList.action',
		        	queryParams:{'fNo':fNo,'pNo':pNo}
		    	 });
		    	$('#dg').datagrid('reload');
		    }
		});
		
		$('#featureList').combobox({
		    valueField:'qfNo',
		    textField:'qfNo',
		    onChange:function (newValue,oldValue) {
		    	var fNo=$('#factoryList').combobox('getValue');
		    	var pNo=$('#productList').combobox('getValue');
		    	var qfNo=newValue;
		    	$('#dg').datagrid({
					url:'rtvList.action',
		        	queryParams:{'fNo':fNo,'pNo':pNo,'qfNo':qfNo}
		    	 });
		    	$('#dg').datagrid('reload');
		    }
		});
	});
	
	function showCharts(){
		var row = $('#dg').datagrid('getData').rows[0];
		if(!row) return;
		var url="jsp/rtv/rtvCharts.jsp?pNo="+row.pNo+"&qfNo="+row.qfNo+"&usl="+row.usl+"&lsl="+row.lsl;
		addTab(row.pNo+"/"+row.qfNo+"  状态图",url);
	}
	</script>

</head>

<body  class="easyui-layout"  style="overflow-y: scroll">
	<table id="dg" class="easyui-datagrid" style="width:100%;height:auto"
		   url="rtvList.action?pNo=${param.pNo}&qfNo=${param.qfNo}" pagination="true" 
		   toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true" striped="true" pageSize="20">
		<thead>
			<tr>
				<th field="fNo" width="5%">厂商编号</th>
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
		厂商列表：<input id="factoryList" placeholder="请选择厂家"/>
		产品列表：<input id="productList" placeholder="请选择产品"/>
		特性列表：<input id="featureList" placeholder="请选择特性"/>
		<a class="easyui-linkbutton" iconCls="icon-ok"     plain="true" onclick="showCharts()">图表显示</a>
	</div>
</body>
</html>