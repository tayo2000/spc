var url;

function addFeature(fNo, pNo) {
	$('#dlg').dialog('open').dialog('setTitle', '添加新特性');
	$('#fm').form('clear');
	url = 'featureAdd.action';

	$('#fNo').val(fNo);
	$('#fNo').attr("readonly", "readonly");
	$('#fNo').css("background-color", "#eee");

	$('#pNo').val(pNo);
	$('#pNo').attr("readonly", "readonly");
	$('#pNo').css("background-color", "#eee");

	$('#qfNo').removeAttr("readonly");
	$('#qfNo').css("background-color", "#fff");
}

function editFeature() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', '编辑产品');
		$('#fm').form('load', row);

		$('#fNo').attr("readonly", "readonly");
		$('#fNo').css("background-color", "#eee");

		$('#pNo').attr("readonly", "readonly");
		$('#pNo').css("background-color", "#eee");

		$('#qfNo').attr("readonly", "readonly");
		$('#qfNo').css("background-color", "#eee");
	}
	url = 'featureUpdate.action';
}

function saveFeature() {
	$('#fm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function() {
					$('#dlg').dialog('close');
					$('#dg').datagrid('reload');
				}
			});
}

function deleteFeature() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '您确定要删除编号为：' + row.qfNo + '的特性吗?',
				function(r) {
					if (r) {
						$.post('featureDelete.action', {
									fNo : row.fNo,
									pNo : row.pNo,
									qfNo : row.qfNo
								});
						$('#dg').datagrid('reload');
					}
				});
	}
}

function reloadFeature() {
	$('#dg').datagrid('reload');
}

function showCharts() {
	var row = $('#dg').datagrid('getSelected');
	if (!row)
		return;
	var url = "jsp/rtv/rtvCharts.jsp?pNo=" + row.pNo + "&qfNo=" + row.qfNo
			+ "&usl=" + row.usl + "&lsl=" + row.lsl;
	addTab(row.pNo + "/" + row.qfNo + "  状态图", url);
}

function showRTV() {
	var row = $('#dg').datagrid('getSelected');
	if (!row)
		return;
	var url = "jsp/rtv/rtvList.jsp?pNo=" + row.pNo + "&qfNo=" + row.qfNo;
	addTab(row.pNo + "/" + row.qfNo + "  特性数据", url);
}