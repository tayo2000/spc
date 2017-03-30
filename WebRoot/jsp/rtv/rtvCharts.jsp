<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>质量特性实时监测数据</title>
	<script src="easyui/jquery.min.js"></script>
	<script src="js/highcharts.js"></script>
	<script>
	var chart;
	var startPos=0;
	var lsl=parseFloat("${param.lsl}");
	var usl=parseFloat("${param.usl}");
	var options= {
			 chart: {renderTo: 'container' }, //将报表对象渲染到层上  
	         title: {text : "${param.pNo}-${param.qfNo}状态图"},
             yAxis:{
             	plotLines: [{
                     color: '#f00',
                     dashStyle: 'Dash', //Dash,Dot,Solid,默认Solid
                     width: 2,
                    },
                    {color: '#f00',
                     dashStyle: 'Dash', //Dash,Dot,Solid,默认Solid
                     width: 2,
                    }],
             },
	        	
	        series: [{name: '${param.qfNo}状态图',data: []}] //设定报表对象的初始数据  
        };
	 $(function(){ 
		/*  if(usl!=99999) options.yAxis.plotLines[0].value = usl;
		 if(lsl!=-99999) options.yAxis.plotLines[1].value = lsl; */
		 chart = new Highcharts.Chart(options);
		 loadRTVData();
		 setInterval(loadRTVData,5000);
	 });
	
		
	    //使用JQuery从后台获取JSON格式的数据  
		function loadRTVData(){
			startPos++;
			if(startPos>5) startPos=1; 
			jQuery.getJSON('rtvCharts.action?startPos='+startPos+'&pNo=${param.pNo}&qfNo=${param.qfNo}', null, function(data) {  
				chart.series[0].setData(data); 
			})
		 }
	</script>
</head>
<body>
	  <div id="container">
	  
	  </div>  
</body>
</html>