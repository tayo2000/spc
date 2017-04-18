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

function openAuth(){
	var row = $('#dg').datagrid('getSelected');
	if(!row) return;
	var  roleId=row.roleId;
	$('#authSelectedList').datalist({
	    url:'authSelectedList.action?roleId='+roleId
	});
	$('#dlg2').dialog('open');
}

function assignAuth(){
	var authList=$("#authSelectedList").datalist("getRows");
	var row = $('#dg').datagrid('getSelected');
	var arList=new Array();
	for(var i=0;i<authList.length;i++){
		var ar=new Object();
		ar.roleId=row.roleId;
		ar.authId=authList[i].authId;
		arList.push(ar);
	}
	 $.ajax({
         type:'POST',
         url:'authRoleAdd.action?roleId='+row.roleId,
         dataType:'json',      
         contentType:'application/json',   
         data:JSON.stringify(arList),
         error:function(XMLResponse){console.info(XMLResponse)},
         success: function(){		
        	 $('#dlg2').dialog('close');	// close the dialog
         }
    });
//	 $('#dlg2').dialog('close');
}

function leftToRight(){
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
			var rowIndex = $('#authList').datalist('getRowIndex', selList[i]);
			$("#authList").datalist('deleteRow', rowIndex);  
		}
	}
	$("#authList").datalist("unselectAll");
}

function rightToLeft(){
	var selectedList=$("#authSelectedList").datalist("getSelections");
	for(var i=0;i<selectedList.length;i++){
		 $("#authList").datalist('appendRow', selectedList[i]);  
		 var rowIndex = $('#authSelectedList').datalist('getRowIndex', selectedList[i]);
		 $('#authSelectedList').datalist('deleteRow', rowIndex);  
	}
	$("#authSelectedList").datalist("unselectAll");
	$('#authList').datalist('sort', {
		sortName: 'authName',
		sortOrder: 'asc'
	});
}
