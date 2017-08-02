var url;
function addModule() {
	$('#dlg').dialog('open').dialog('setTitle', '添加模块信息');
	$('#fm').form('clear');
	url = 'moduleAdd.action';
	$('#moduleId').removeAttr("readonly");
	$('#moduleId').css("background-color", "#fff");
}

function editModule() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', '编辑模块信息');
		$('#fm').form('load', row);
		$('#moduleId').attr("readonly", "readonly");
		$('#moduleId').css("background-color", "#eee");
	}
	url = 'moduleUpdate.action';
}

function saveModule() {
	$('#fm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function() {
					$('#dlg').dialog('close'); // close the dialog
					$('#dg').datagrid('reload'); // reload the user data
				}
			});
}

function deleteModule() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '您确定要删除编号为：' + row.moduleId + '的模块吗?',
				function(r) {
					if (r) {
						$.post('moduleDelete.action', {
									moduleId : row.moduleId
								});
						$('#dg').datagrid('reload');
					}
				});
	}
}

function refreshModule() {
	$('#dg').datagrid('reload');
}