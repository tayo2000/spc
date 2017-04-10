var url;
function addRole(){
	$('#dlg').dialog('open').dialog('setTitle','添加角色信息');
	$('#fm').form('clear');
	url='roleAdd.action';
	$('#roleId').removeAttr("readonly");
	$('#roleId').css("background-color","#fff");
}

function editRole(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#dlg').dialog('open').dialog('setTitle','编辑角色信息');
		$('#fm').form('load',row);
		$('#roleId').attr("readonly","readonly");
		$('#roleId').css("background-color","#eee");
	}
	url='roleUpdate.action';
}

function saveRole(){
	$('#fm').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(){
				$('#dlg').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
		}
	});
}

function deleteRole(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('确认','您确定要删除编号为：'+row.roleId+'的角色吗?',function(r){
			if (r){
				$.post('roleDelete.action',{roleId:row.roleId});
				$('#dg').datagrid('reload');
			}
		});
	}
}

function assignAuth(){
	$('#dlg2').dialog('open').dialog('setTitle','分配权限');
}

function selectAuth(){
	var selList=$("#authList").datalist("getSelections");
	var selectedList=$("#authSelectedList").datalist("getRows");
	for(var i=0;i<selList.length;i++){
		var flag=true;
		for(var j=0;j<selectedList.length;j++){
			if(selList[i]==selectedList[j]) {
				flag=false;
				break;
			}
		}
		if(flag==true){
			$("#authSelectedList").datalist("appendRow",selList[i]);
		}
	}
}
function cancelAuth(){
	var selAuth=$("#authSelectedList").datalist("getSelections");
	for(var i=0;i<selAuth.length;i++){
		 var rowIndex = $('#authSelectedList').datalist('getRowIndex', selAuth[i]);
		 $('#authSelectedList').datalist('deleteRow', rowIndex);  
	}
}
function refreshRole(){
	$('#dg').datagrid('reload');
}