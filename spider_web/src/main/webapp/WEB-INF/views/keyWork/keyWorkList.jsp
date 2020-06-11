<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>关键词管理</title>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<link rel="stylesheet" href="${ctx}/front/css/keyWorkList.css" type="text/css" />
<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->
</head>
<body>
	<ul class="breadNav">
		<li><a href="" title="" target="_self">关键词管理</a></li>
	</ul>
	<!-- logList -->
	<div class="editorList">
		<div class="searchArea">
			<span>关键词：</span>
			<input class="searchInput" id="searchkeywordName"/>
			<a class="addBtn" onclick="addDialog()" href="javascript:void(0)" title="添加" target="_self" style="    margin-left: 20px;">添加</a>
			<a class="addBtn" onclick="executeQuery()"href="javascript:void(0)" title="查询" target="_self">查询</a>
		</div>
		<div class="listTitWrap">
			<ul>
				<li><span class="td01">序号</span>
					<span class="td02">关键词名称</span> 
					<span class="td03">创建日期</span>
					<span class="td04">更新日期</span>
					<span class="td05">操作</span>
				</li>
			</ul>
		</div>
		<div class="djbzMain">
			<ul id="KeyWordList" class="djbz">
			</ul>
			<div id="pager"></div>
			<div style="display: none;" id="clonKeyWordList">
				<li><span class="td01">#序号#</span> 
					<span class="td02">#关键词名称#</span>
					<span class="td03">#创建日期#</span> 
					<span class="td04">#更新日期#</span> 
					<span class="td05">
						<a class="updateBtn" onclick="updateDialog('#主键#')" id="look" href="javscript:void(0)" title="" target="_self">修改</a>
						<a class="delEditor" onclick="delConfirm('#主键#')" href="javascript:void(0)" title="删除" target="_self">删除</a>
					</span> 
				</li>
			</div>
		</div>
	</div>
	
	
	<!-- 添加弹窗 -->
<div class="editDialog" id="siteAddDialog">
    <h3>添加</h3>
    <span class="closeBtn" data-id="cancel">x</span>
    <div id="errorTips" class="errorUserTips"></div>
    <form id="mainform">
    <div class="editName">
        <i>关键词名称：</i>
        <input id="add_keywordName" name="keywordName" type="text" placeholder="请输入关键词名称"/>
    </div>
    <div class="dialogBtn">
        <input  type="submit" value="确定"/><input class="cancel" data-id="cancel" type="button" value="取消"/>
    </div>
    </form>
</div>

	<!-- 修改弹窗 -->
<div class="editDialog" id="siteUpdateDialog">
    <h3>添加</h3>
    <span class="closeBtn" data-id="cancel">x</span>
    <div id="errorTips" class="errorUserTips"></div>
    <form id="updateform">
    <input id="update_keywordId" name="keywordId" type="hidden"/>
    <div class="editName">
        <i>关键词名称：</i>
        <input id="update_keywordName" name="keywordName" type="text" placeholder="请输入关键词名称"/>
    </div>
    <div class="dialogBtn">
        <input  type="submit" value="确定"/><input class="cancel" data-id="cancel" type="button" value="取消"/>
    </div>
    </form>
</div>


</body>
<script>
	var pageind = 1;
	$(function() {
		findKeyWordList();
	});
	function executeQuery(){
		var keywordName = $("#searchkeywordName").val();
		findKeyWordList(keywordName);
	}
	//列表数据填充
	function findKeyWordList(keywordName) {
		$('#pager').sjAjaxPager({
			url : '${ctx}/keyWork/keyWorkList',
			pageIndex : pageind,
			pageSize : 10,
			searchParam : {
				"keywordName":keywordName
			},
			beforeSend : function() {
				jiazai();
			},
			success : function(data) {
				pageind = data.pageIndex;
				$("#KeyWordList").html("");
				var tempa = $("#clonKeyWordList").clone().html();
				var tempStr = tempa;
				$('#pager').html("");
				$.each(data.TitleCounts, function(index, obj) {
					tempStr = tempStr.replace("#序号#", (data.pageIndex - 1)* 10 + (index + 1));
					tempStr = tempStr.replace("#关键词名称#",obj.keywordName);
					tempStr = tempStr.replace("#创建日期#",obj.createTimeStr);
					tempStr = tempStr.replace("#更新日期#",obj.updateTimeStr);
					tempStr = tempStr.replace("#主键#",obj.keywordId);
					tempStr = tempStr.replace("#主键#",obj.keywordId);
					$("#KeyWordList").append(tempStr);
					tempStr = tempa;
				});
			},
			complete : function() {
				loading.close();//加载完成弹框关闭
			}
		});

	}
	
	/* 详情查看弹框   */
	function addDialog(){
		$.cachedScript('${ctx }/front/js/artDialog.js').done(function(){
	        var d = dialog({
	             content:document.getElementById('siteAddDialog'),
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
	//表单添加提交
	function addKeyWord(){
		$.ajax({
			url : '${ctx}/keyWork/addKeyWork',
			 data:$("#mainform").serialize(),
			 success: function(data){
				 if(data.success){
					$(".cancel").click();
	        		successDialog(data.msg);
	        		setTimeout("findKeyWordList()","200"); //延迟加载
				 }else{
					 falseDialog(data.msg);
				 }
			 },
			complete : function() {
			}
		})
	}

	/* 修改弹框   */
	function updateDialog(keywordId){
		lookKeyWord(keywordId);
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
	//详情查看
	function lookKeyWord(keywordId) {
		$.ajax({
	        type: "POST",
	        url: '${ctx }/keyWork/lookKeyWork?keywordId='+keywordId,
	        success: function (data) {
	        	if(data.success){
	        		$("#update_keywordName").val(data.keyWork.keywordName);
	        		$("#update_keywordId").val(data.keyWork.keywordId);
				 }else{
					 falseDialog(data.msg);
				 }
	        },
	        error:function(){
	        	falseDialog("未知错误，请重试！")
	        }
		});
	}
	//表单修改提交
	function updateKeyWord(){
		$.ajax({
			url : '${ctx}/keyWork/updateKeyWord',
			 data:$("#updateform").serialize(),
			 success: function(data){
				 if(data.success){
					$(".cancel").click();
	        		successDialog(data.msg);
	        		setTimeout("findKeyWordList()","200"); //延迟加载
				 }else{
					 falseDialog(data.msg);
				 }
			 },
			complete : function() {
			}
		})
	}
	//删除确认
	function delConfirm(keywordId){
		$.cachedScript('${ctx }/front/js/artDialog.js').done(function(){
	        var d = dialog({
	             content:document.getElementById('delDialog'),
	             ok:function(){
	            	 delkeyWord(keywordId);
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
	function delkeyWord(keywordId) {
		$.ajax({
	        type: "POST",
	        url: '${ctx }/keyWork/deleteKeyWork?keywordId='+keywordId,
	        success: function (data) {
	        	if(data.success){
	        		successDialog(data.msg);
	        		setTimeout("findKeyWordList()","200"); //延迟加载
				 }else{
					 falseDialog(data.msg);
				 }
	        },
	        error:function(){
	        	falseDialog("未知错误，请重试！")
	        }
		});
	}
	
	
	$().ready(function() {

		 /* 表单验证 */
	 	 $("#mainform").validate({
			rules: {
				keywordName: {
					required: true,
					minlength: 2,
					maxlength: 50
				}
			},
			messages: {
				keywordName: {
					required: "关键词不能为空",
					minlength: "长度不能少于2",
					maxlength:"长度不能超过50"
				}
			},
			submitHandler: function() {
				addKeyWord();
			}
			
		}); 
	 	$("#updateform").validate({
			rules: {
				keywordName: {
					required: true,
					minlength: 2,
					maxlength: 50
				}
			},
			messages: {
				keywordName: {
					required: "关键词不能为空",
					minlength: "长度不能少于2",
					maxlength:"长度不能超过50"
				}
			},
			submitHandler: function() {
				updateKeyWord();
			}
			
		}); 
		 
	 
	 	/* 表单重置 */
		 $(".cancel").click(function() {
			 $("#mainform").validate().resetForm();
			 $("#updateform").validate().resetForm();
			 $("input[type=text]").val("");
		    });
		$(".closeBtn").click(function() {
			 $("#mainform").validate().resetForm();
			 $("#updateform").validate().resetForm();
			 $("input[type=text]").val("");
		    });

	});
</script>


</html>