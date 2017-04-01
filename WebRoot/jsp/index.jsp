<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<base  href="${pageContext.request.contextPath}/"/>
	<meta charset="UTF-8">
	<title>产品质量管理信息系统</title>
	<link type="text/css" rel="stylesheet" href="css/default.css"/>
	<link type="text/css" rel="stylesheet"  href="easyui/themes/default/easyui.css" />
	<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css" />
 	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<style>
		#north{height:40px;background:url("images/layout-north-bg.gif") #7f99be repeat-x center 50%;}
		#south{height:30px;background-color:#D2E0F2;}
		#west{width:180px;}
		#west ul li a:hover{cursor:pointer;}
		#center{background-color:#eee;}
		#north span{color:#fff; float:right; padding-top:6px; padding-left:5px;}
		#north span a{color:#fff; text-docoration:none;padding-right:10px;}
		#north #myclock{float:left;}
		.accordion-collapse{background:url('images/panel_tool_collapse.gif')}
		.accordion-expand{background:url('images/panel_tool_expand.gif')}
	</style>
	<script>
	$(function(){
		InitLeftMenu();  //初始化左侧菜单
		tabClose();
		tabCloseEven();
		clockon();
		//addTab('厂商列表','jsp/factory/factoryList.jsp');
		addTab('用户列表','jsp/user/userList.jsp');
	})
	</script>
	</head>
	<body class="easyui-layout" >	
		<div id="north" region="north" split="true" border="false" >
			<span id="myclock"></span>
			<span>
			欢迎用户：${sessionScope.username} | 
			<a href="userLogout.action?username=${sessionScope.username}">退出登陆</a></span>
		</div>
		
		<div  id="west" region="west" split="true" title="导航菜单" style="width:180px;" id="west">
        	<div class="easyui-accordion" fit="true" border="false">
				<div title="系统设置" iconCls="icon-ok" style="overflow:auto;padding:10px;">
					<ul>
						<li>
							<div><a onclick="addTab('用户列表','jsp/user/userList.jsp')">用户管理</a></div>
						</li>
						<li>
							<div><a onclick="addTab('模块列表','jsp/module/moduleList.jsp')">模块管理</a></div>
						</li>
						<li>
							<div><a onclick="addTab('权限列表','jsp/auth/authList.jsp')">权限管理</a></div>
						</li>
						<li>
							<div><a onclick="addTab('角色列表','jsp/role/roleList.jsp')">角色管理</a></div>
						</li>
					</ul>
				</div>
				
				<div title="质量管理" iconCls="icon-ok" style="overflow:auto;padding:10px;">
					<ul>
						<li>
							<div><a onclick="addTab('厂商列表','jsp/factory/factoryList.jsp')">质量定义</a></div>
						</li>
						<li>
							<div><a onclick="addTab('实时质量','jsp/qualityInfo/realQuality.jsp')">实时质量</a></div>
						</li>
						<li>
							<div><a onclick="addTab('历史数据','jsp/rtv/rtvList.jsp')">历史数据</a></div>
						</li>
					</ul>
				</div>
				<div title="质量改进" iconCls="icon-ok"  style="padding:10px;">
				</div>	
				<div title="质量策划" iconCls="icon-ok"  style="padding:10px;">
				</div>			
			</div>
    	</div>
    	
    	<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
	       	 <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
	       	 </div>
       	</div>
       	
       	<div id="south" region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
        </div>
       	
       	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
	</body>
</html>