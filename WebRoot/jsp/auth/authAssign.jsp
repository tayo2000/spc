<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>分配权限</title>
	<link type="text/css" rel="stylesheet" href="css/default.css"/>
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
 	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/role.js"></script>
</head>
<body class="easyui-layout">
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
</body>
</html>