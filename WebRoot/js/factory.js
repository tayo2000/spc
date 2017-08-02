var url;
function addFactory() {
	$('#dlg').dialog('open').dialog('setTitle', '添加厂商信息');
	$('#fm').form('clear');
	url = 'factoryAdd.action';
	$('#fNo').removeAttr("readonly");
	$('#fNo').css("background-color", "#fff");
}

function editFactory() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', '编辑厂商信息');
		$('#fm').form('load', row);
		$('#fNo').attr("readonly", "readonly");
		$('#fNo').css("background-color", "#eee");
	}
	url = 'factoryUpdate.action';
}

function saveFactory() {
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

function deleteFactory() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '您确定要删除编号为：' + row.fNo + '的厂商吗?', function(r) {
					if (r) {
						$.post('factoryDelete.action', {
									fNo : row.fNo
								});
						$('#dg').datagrid('reload');
					}
				});
	}
}

function refreshFactory() {
	$('#dg').datagrid('reload');
}