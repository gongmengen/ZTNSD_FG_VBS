<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body>
<div>
	<form id="mainform" action="${ctx }/website/add" method="post">
		<table class="formTable">
			<tr>
				<td>网站名称：</td>
				<td>
					<input type="hidden" name="id" value="${id}"/>
					<input id="websiteName" name="websiteName" class="easyui-validatebox" data-options="width: 150,required:'required'"> 
				</td>
			</tr>
			<tr>
				<td>网站地址：</td>
				<td><input id="websiteAddress" name="websiteAddress" type="text" class="easyui-validatebox" data-options="width: 150,required:'required'"/></td>
			</tr>
			<tr>
				<td>栏目id：</td>
				<td><input id="columnId" name="columnId" type="text" class="easyui-validatebox" data-options="width: 150,required:'required'"/></td>
			</tr>
			<tr>
				<td>周期：</td>
				<td><input id="updateCycle" name="updateCycle" type="text" class="easyui-validatebox" data-options="width: 150,required:'required'"/></td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript">
//提交表单
$('#mainform').form({    
    onSubmit: function(){    
    	var isValid = $(this).form('validate');
		return isValid;	// 返回false终止表单提交
    },    
    success:function(data){   
    	if(data=='success'){
	    	dg.datagrid('reload');
			d.panel('close');
			parent.$.messager.show({ title : "提示",msg: "操作成功！", position: "bottomRight" });
    	}else{
    		alert(data)
    	}
    }    
});    
</script>
</body>
</html>