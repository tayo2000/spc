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

function refreshRole(){
	$('#dg').datagrid('reload');
}