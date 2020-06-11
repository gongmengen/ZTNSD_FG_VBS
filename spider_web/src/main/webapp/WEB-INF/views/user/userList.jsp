<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>编辑管理</title>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<link rel="stylesheet" href="${ctx}/front/css/editList.css" type="text/css"/>
<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->
</head>
<body>
<ul class="breadNav">
    <li><a href="" title="" target="_self">编辑管理</a></li>
</ul>
<!-- newsList -->  
<div class="editorList">
    <div class="addEditor">
        <a class="" onclick="addDialog()" href="javascript:void(0)" title="添加" target="_self">添加</a>
    </div>
    <div class="listTitWrap">
        <ul>
            <li>
                <span class="td01">序号</span>
                <span class="td02">用户账户</span>
                <span class="td03">权限</span>
                <span class="td04">操作</span>
            </li>
        </ul>
    </div>
    <div class="djbzMain">
        <ul id="userList" class="djbz">
        
        </ul>
        <div id="pager"></div>
        <div style="display: none;" id="clonUserList">
	        <li>
	                <span class="td01">#序号#</span>
	                <span class="td02">#用户账户#</span>
	                <span class="td03">#用户权限#</span>
	                <span class="td04">
	                    <a class="updateBtn" onclick="updateDialog('#主键#')" id="update" href="javscript:void(0)" title="" target="_self">修改</a>
	                    <a class="delEditor" onclick="delConfirm('#主键#')" href="javascript:void(0)" title="删除" target="_self">删除</a>
	                </span>
	            </li>
        </div>
    </div>
</div> 
<!-- 添加弹窗 -->
<div class="editDialog" id="editDialog">
    <h3>添加</h3>
    <span class="closeBtn" data-id="cancel">x</span>
    <div id="errorTips" class="errorUserTips"></div>
    <form id="mainform">
    <!-- <div id="errorTips" class="errorTips"></div> -->
    <div class="editName">
        <i>用户姓名：</i>
        <input id="nickName" name="nickName" type="text" placeholder="请输入用户姓名"/>
    </div>
    <div class="editName">
        <i>用户账户：</i>
        <input id="userName" name="userName" type="text" placeholder="请输入用户账户"/>
    </div>
    <div class="editName">
        <i>用户密码：</i>
        <input id="password" name="password" type="text" placeholder="请输入用户密码"/>
    </div>
    <div class="editPower">
        <i>用户权限：</i>
        <select id="roleType" name="roleType">
            <option id="1" value="1">添加网站</option>
            <option id="2" value="2">添加网站、修改/删除本人添加网站</option>
            <option id="3" value="3">添加网站、修改/删除所有添加网站</option>
            <option id="4" value="4">添加/修改编辑权限</option>
            <option id="5" value="5">所有权限</option>
        </select>
    </div>
    <div class="dialogBtn">
        <input  type="submit" value="确定"/><input class="cancel" data-id="cancel" type="button" value="取消"/>
    </div>
    </form>
</div>
<script>
var pageind =1;
function finduserList(){
	
		 $('#pager').sjAjaxPager({
		        url: '${ctx}/user/userList',
		        pageIndex:pageind,
		        pageSize: 10,
		        searchParam: {
		            /*
		            * 如果有其他的查询条件，直接在这里传入即可
		            */
		        },
		        beforeSend: function () {
		        },
		        success: function (data) {
		        	pageind = data.pageIndex;
		        	$("#userList").html("");
		    		var tempa =$("#clonUserList").clone().html();
		    		 var tempStr = tempa;
		    		 $('#pager').html("");
		            $.each(data.users,function(index,obj){
		    	        tempStr=tempStr.replace("#序号#",(data.pageIndex-1)*10+(index+1));	
		    	        tempStr=tempStr.replace("#用户账户#",obj.userName);	
		    	        tempStr=tempStr.replace("#用户权限#",obj.roleTypeName);	

		    	        tempStr=tempStr.replace("#主键#",obj.id);	
		    	        tempStr=tempStr.replace("#主键#",obj.id);	
		    	        
		    	        $("#userList").append(tempStr);
		            	tempStr=tempa;
		    		});
		        },
		        complete: function () {
		        }
		    });

}
</script>
<script>
/* 添加弹窗 */
function addDialog(){
	$.cachedScript('${ctx }/front/js/artDialog.js').done(function(){
        var d = dialog({
             content:document.getElementById('editDialog'),
             ok:function(){
                 this.close().remove();
                 return false;
             },
             okValue:"确定",
             cancel:function(){
            	 $("#errorTips").attr("style","display:none;");
                 this.close();
                 return false;
             },
        });
        //将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
        d.showModal();
    });
}

function add(){
	var id = $("#id").val();
	var userName  =$("#userName").val();
	var nickName  =$("#nickName").val();
	var password  =$("#password").val();
	var roleType  =$("#roleType").val();
	
	$.ajax({
        type: "post",
        url: '${ctx }/user/add',
        data : {
        	id:id,
        	userName:userName,
        	nickName:nickName,
        	password:$.md5(password),
        	roleType:roleType
        	}, 
        success: function (data) {
        	if (data.success) {
        		$(".cancel").click(); 
        		successDialog(data.msg);
        		setTimeout("finduserList()","200"); //延迟加载
			}else{
//				falseDialog(data.msg);
				$("#errorTips").attr("style","display:block;");
				$("#errorTips").html("用户账户已存在");
			}
//        	loading.close();
        },
        error:function(){
//        	loading.close();
 //       	falseDialog("未知错误，请重试！");
        }
	});
}

</script>
<script>
$(function(){
	finduserList();
    //表格样式
    $(".djbz li:even").addClass("bg"); 
    
});

//删除确认
function delConfirm(id){
	$.cachedScript('${ctx }/front/js/artDialog.js').done(function(){
        var d = dialog({
             content:document.getElementById('delDialog'),
             ok:function(){
            	 del(id);
                 this.close().remove();
                 return false;
             },
             okValue:"确定",
             cancel:function(){
                 this.close();
                 return false;
             },
        });
        //将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
        d.showModal();
    });
}
function del(id) {
	$.ajax({
        type: "POST",
        url: '${ctx }/user/delete?id='+id,
        success: function (data) {
        	if (data.success) {
        		successDialog(data.msg);
        		setTimeout("finduserList()","200"); //延迟加载
			}else{
				falseDialog(data.msg);
			}
        },
        error:function(){
        	falseDialog("未知错误，请重试！")
        }
	});
}
</script> 

<!-- 用户修改弹窗 -->
<div class="editDialog" id="siteUpdateDialog">
    <h3>修改用户</h3>
    <span class="closeBtn" data-id="cancel">x</span>
    <form id="updateform" class="demoform">
    <input type="hidden" id="id" name="id" value=""/>
    <div class="editName">
        <i>用户姓名：</i>
        <input type="text" id="nickName1" name="nickName" placeholder="请输入用户姓名"/>
    </div>
    <div class="editName">
        <i>用户账户：</i>
		<input type="text" id="userName1" name="userName" disabled= "true" placeholder="请输入用户账户"/>
    </div>
    <div class="editName">
        <i>用户密码：</i>
        <input type="text" id="password1" name="password" placeholder="请输入用户密码"/>
    </div>
    <div class="editPower">
        <i>用户权限：</i>
        <select id="roleType1" name="roleType">
             <option id="1" value="1">添加网站</option>
            <option id="2" value="2">添加网站、修改/删除本人添加网站</option>
            <option id="3" value="3">添加网站、修改/删除所有添加网站</option>
            <option id="4" value="4">添加/修改编辑权限</option>
            <option id="5" value="5">所有权限</option>
        </select>
    </div>
    <div class="dialogBtn">
        <input type="submit" value="确定" />
        <input class="cancel" data-id="cancel" type="button" value="取消" />
    </div>
    </form>
</div>

<script>
/* 用户弹窗修改 */
function updateDialog(id){
	val(id);
	$.cachedScript('${ctx }/front/js/artDialog.js').done(function(){
        var d = dialog({
             content:document.getElementById('siteUpdateDialog'),
             ok:function(){
            	 this.close().remove();
                 return false;
             },
             okValue:"确定",
             cancel:function(){ 
                 this.close();
                 return false;
             },
        });
        //将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
        d.showModal();   
    });	
}


/* 根据id查询网站信息 */
function val(id){

    $("#id").val(id);
	$.ajax({
		type:'GET',
		url:'${ctx }/user/userListId',
		dataType:'json',
		data:{"id":id},
		success:function(data){
			$("#nickName1").val(data.nickName);
			$("#userName1").val(data.userName);
			//下拉框回显
			var all_options = document.getElementById("roleType1").options;
			for (i=0; i<all_options.length; i++){
		      if (all_options[i].id == data.roleType)  // 根据option标签的ID来进行判断  测试的代码这里是两个等号
		      {
		         all_options[i].selected = true;
		      }
			}
			
		}
	});
}

/* 用户修改 */
function update(){
	var id = $("#id").val();
	var userName1  =$("#userName1").val();
	var nickName1  =$("#nickName1").val();
	var password1  =$("#password1").val();
	var roleType1  =$("#roleType1").val(); 
	
	$.ajax({
        type: "post",
        url: '${ctx }/user/update',
        data : {
        	id:id,
        	userName:userName1,
        	nickName:nickName1,
        	password:password1,
        	roleType:roleType1
        	}, 
        success: function (data) {
        	if (data.success) {
        		$(".cancel").click();
        		successDialog(data.msg);
        		setTimeout("finduserList()","200"); //延迟加载
			}else{
				falseDialog(data.msg);
			}
//        	loading.close();
        },
        error:function(){
//        	loading.close();
       	falseDialog("未知错误，请重试！");
        }
	});
}
</script>
 <script>


$().ready(function() {

	 /* 表单验证 */
 	 $("#mainform").validate({
		rules: {
			userName: {
				required: true,
				minlength: 2,
				maxlength: 50
			},
			nickName: {
 				required: true,
				minlength: 2,
				maxlength: 50
 			},
 			password: {
 				required: true,
 				minlength: 6,
				maxlength: 50
 			},
		},
		messages: {
			userName: {
				required: "账户不能为空",
				minlength: "长度不能少于2",
				maxlength:"长度不能超过50"
			},
			nickName: {
				required: "姓名不能为空",
				minlength: "长度不能少于2",
				maxlength:"长度不能超过50"
			},
			password: {
				required: "密码不能为空",
				minlength: "长度不能少于6",
				maxlength:"长度不能超过50"
			},
		},
		submitHandler: function() {
			add();
		}
		
	}); 
 	$("#updateform").validate({
		rules: {
			userName: {
				required: true,
				minlength: 2,
				maxlength: 50
			},
			nickName: {
 				required: true,
				minlength: 2,
				maxlength: 50
 			},
 			password: {
 				required: true,
 				minlength: 6,
				maxlength: 50
 			},
		},
		messages: {
			userName: {
				required: "账户不能为空",
				minlength: "长度不能少于2",
				maxlength:"长度不能超过50"
			},
			nickName: {
				required: "姓名不能为空",
				minlength: "长度不能少于2",
				maxlength:"长度不能超过50"
			},
			password: {
				required: "密码不能为空",
				minlength: "长度不能少于6",
				maxlength:"长度不能超过50"
			},
		},
		submitHandler: function() {
			update();
		}
		
	}); 
	 
 
 	/* 表单重置 */
	 $(".cancel").click(function() {
		 $("#mainform").validate().resetForm();
		 $("#updateform").validate().resetForm();
		 $("select").val("");
		 $("input[type=text]").val("");
	    });
	$(".closeBtn").click(function() {
		 $("#mainform").validate().resetForm();
		 $("#updateform").validate().resetForm();
		 $("select").val("");
		 $("input[type=text]").val("");
	    });

});
</script>    
</body>
</html>