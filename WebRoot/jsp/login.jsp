<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">  
	<meta http-equiv="cache-control" content="no-cache">  
	<meta http-equiv="expires" content="0">     
	<title>用户登陆</title>
	
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
	<style>
		#loginWindow{width:420px;height:auto; padding:5px; padding-bottom:20px;}
		.fitem{margin:5px 0px 10px 20px;height:30px;}
		.fitem label {font-size:16px;}
		.fitem input{width:240px;height:20px;line-height:20px;font-size:16px;font-weight:bold;}
		.fitem .msg{color:#f00;font-size:12px;font-weight:bold;}
		 #verifycode{width:80px;padding:2px 5px 2px;}
		 #verifyImage{height:30px;line-height:30px;vertical-align:middle;}
	</style>
 	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
	
</head>
<body>	
 	 <div id="loginWindow" class="easyui-dialog" closable="false" title="系统登录界面"  modal="true" buttons="#dlg-buttons">
       	<form method="post" id="fm" action="userLogin.action">
           	<div class="fitem clearfloat">
	             <label for="username">账号：</label>
	             <input id="username" name="username" type="text"  value="${user.username}" />
	             <span class="msg">${usernameMsg}</span>
            </div>
            <div class="fitem clearfloat">
	             <label for="password">密码：</label>
	   			 <input id="password" name="password" type="password"/>
	   			 <span class="msg">${passwordMsg}</span>
   			</div> 
   			<div class="fitem clearfloat">
	   			 <label for="verifycode">验证码：</label>
	   			 <input id="verifycode" name="verifycode" type="text"/>
	   			 <img id="verifyImage" src="verifyCodeImage.action"/>
	   			 <a href="javascript:$('#verifyImage').attr('src','verifyCodeImage.action?date='+new Date());">换一张</a>
	   			 <span class="msg">${verifycodeMsg}</span>
   			</div> 
        </form>   
    </div>
    <div id="dlg-buttons">
			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#fm').submit();">登陆</a>
	</div>
</body>
</html>