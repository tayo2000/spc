var url;
// $(function(){
// InitLeftMenu();
// tabClose();
// tabCloseEven();
// clockon();
// addTab("产品列表","jsp/product/productList.jsp");
// /* $('#dg').datagrid({
// columns:[[{field:'pNo',width:100,title:'产品编号'},
// {field:'pName',width:100,title:'产品名称'},
// {field:'pType',width:100,title:'产品型号'},
// {field:'remarks',width:100,title:'remarks'},
// {field:'xxx', width:100, title:'操作',formatter: function(value,row,index){
// return '<a href="#" onclick="constructionManager(\'' + row.id+ '\')">查看</a>'}
// }]]
// })
// $('#dg').datagrid('getPager').pagination({
// pageSize: 10, //每页显示的记录条数，默认为10
// pageList: [5, 10, 15, 20], //可以设置每页记录条数的列表
// pageNumber: 1,
// url:"productList.action" ,
// onSelectPage: function(pageNumber, pageSize) {
// $.getJSON("productList.action",
// {page:pageNumber,rows:pageSize},function(result){
// var obj = { total: result.total, rows: result.rows };
// $("#dg").datagrid('loadData', obj);
// });
// }
//        
// }); */
// })
function addProduct(fNo) {
	$('#dlg').dialog('open').dialog('setTitle', '添加新产品');
	$('#fm').form('clear');

	$('#fNo').val(fNo);
	$('#fNo').attr("readonly", "readonly");
	$('#fNo').css("background-color", "#eee");

	$('#pNo').removeAttr("readonly");
	$('#pNo').css("background-color", "#fff");

	url = 'productAdd.action';
}

function editProduct() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', '编辑产品');
		$('#fm').form('load', row);

		$('#fNo').attr("readonly", "readonly");
		$('#fNo').css("background-color", "#eee");

		$('#pNo').attr("readonly", "readonly");
		$('#pNo').css("background-color", "#eee");
	}
	url = 'productUpdate.action';
}

function saveProduct() {
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

function deleteProduct() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '您确定要删除编号为：' + row.pNo + '的产品吗?', function(r) {
					if (r) {
						$.post('productDelete.action', {
									pNo : row.pNo,
									fNo : row.fNo
								});
						$('#dg').datagrid('reload');
					}
				});
	}
}

function setFeature() {
	var row = $('#dg').datagrid('getSelected');
	if (!row)
		return;
	var url = "jsp/feature/featureList.jsp?pNo=" + row.pNo + "&fNo=" + row.fNo;
	addTab("产品编号：" + row.pNo + "的特性列表", url);
}

function refreshProduct() {
	$('#dg').datagrid('reload');
}