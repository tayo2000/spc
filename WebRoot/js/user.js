var url;
function addNewUser(){
	$('#dlgAddUser').dialog('open').dialog('setTitle','添加用户信息');
	$('#fmAddUser').form('clear');
	$("input[name='username']").removeAttr("readonly");
	$('#roleId').combobox({
		 onLoadSuccess:function(data){ $('#roleId').combobox('setValue',data[0].roleId);}
		
	});  
	$('#fNo').combobox({
		 onLoadSuccess:function(data){ $('#fNo').combobox('setValue',data[0].fNo);}
		
	}); 
	
	url='userAdd.action';
}

function editUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#dlgEditUser').dialog('open').dialog('setTitle','编辑用户信息');
		$('#fmEditUser').form('load',row);
		$("input[name='username']").attr("readonly","readonly");
		$("input[name='username']").css("background-color","#ccc");
	}
	url='userInfoUpdate.action';
}

function editPassword(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#dlgEditPassword').dialog('open').dialog('setTitle','修改用户密码');
		$('#fmEditPassword').form('load',row);
		$("input[name='username']").attr("readonly","readonly");
		$("input[name='username']").css("background-color","#ccc");
	}
	url='userPasswordUpdate.action';
}


function saveNewUser(){
	$('#fmAddUser').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(){
				$('#dlgAddUser').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
		}
	});
}


function updateUser(){
	$('#fmEditUser').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(){
				$('#dlgEditUser').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
		}
	});
}

function savePassword(){
	$('#fmEditPassword').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(){
				$('#dlgEditPassword').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
		}
	});
}

function deleteUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('确认','您确定要删除用户： '+row.username+' 吗?',function(r){
			if (r){
				$.post('userDelete.action',{username:row.username});
				$('#dg').datagrid('reload');
			}
		});
	}
}