var url;
function addauth(){
	$('#dlg').dialog('open').dialog('setTitle','添加权限信息');
	$('#fm').form('clear');
	url='authAdd.action';
	$('#authId').removeAttr("readonly");
	$('#authId').css("background-color","#fff");
}

function editauth(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#dlg').dialog('open').dialog('setTitle','编辑权限信息');
		$('#fm').form('load',row);
		$('#authId').attr("readonly","readonly");
		$('#authId').css("background-color","#eee");
	}
	url='authUpdate.action';
}

function saveauth(){
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

function deleteauth(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('确认','您确定要删除编号为：'+row.authId+'的权限吗?',function(r){
			if (r){
				$.post('authDelete.action',{authId:row.authId});
				$('#dg').datagrid('reload');
			}
		});
	}
}

function refreshauth(){
	$('#dg').datagrid('reload');
}