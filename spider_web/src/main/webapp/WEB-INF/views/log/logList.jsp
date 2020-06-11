<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>日志管理</title>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<link rel="stylesheet" href="${ctx}/front/css/log.css" type="text/css" />
<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->
</head>
<body>
	<ul class="breadNav">
		<li><a href="" title="" target="_self">日志管理</a></li>
	</ul>
	<!-- logList -->
	<div class="editorList">
		<div class="searchArea">
			<a class="addBtn" onclick="dels()"href="javascript:void(0)" title="删除" target="_self">删除</a>
		</div>
		<div class="listTitWrap">
			<ul>
				<li><span class="td01">序号</span>
					<span class="td05">网站名称</span> 
					<span class="td05">网站地址</span>
					<span class="td05">提示信息</span>
					<span class="td05">记录时间</span>
					<span><label><input class="checkBtnAll" id="selectAll" type="checkbox"/></label>
                		<label>选择</label>
                		</span>
				</li>
			</ul>
		</div>
		<div class="djbzMain">
			<ul id="logList" class="djbz">
			</ul>
			<div id="pager"></div>
			<div style="display: none;" id="clonLogList">
				<li><span class="td01">#序号#</span> 
					<span class="td05">#网站名称#</span>
					<span class="td05"><a style="color: #4b96ea;" href="#网站地址#" title="#网站地址#" target="view_window">#网站地址#</a></span>
					<span class="td05" title="#提示信息#">#提示信息#</span>
					<span class="td05">#创建时间#</span> 
					<span><label><input value="#主键#" class="checkBtn" type="checkbox"/></label></span>
				</li>
			</div>
		</div>
	</div>
	<script>
		var pageind = 1;
		function findlogList() {

			$('#pager').sjAjaxPager(
					{
						url : '${ctx}/log/websiteLogList',
						pageIndex : pageind,
						pageSize : 10,
						searchParam : {
						/*
						 * 如果有其他的查询条件，直接在这里传入即可
						 */
						},
						beforeSend : function() {
						},
						success : function(data) {
							pageind = data.pageIndex;
							$("#logList").html("");
							var tempa = $("#clonLogList").clone().html();
							var tempStr = tempa;
							$('#pager').html("");
							$.each(data.websiteLogs, function(index, obj) {
								tempStr = tempStr.replace("#序号#", (data.pageIndex - 1)* 10 + (index + 1));
								tempStr = tempStr.replace("#网站名称#",obj.website_name);
								tempStr = tempStr.replace("#网站地址#",obj.website_address);
								tempStr = tempStr.replace("#网站地址#",obj.website_address);
								tempStr = tempStr.replace("#网站地址#",obj.website_address);
								tempStr = tempStr.replace("#提示信息#",obj.log_text);
								tempStr = tempStr.replace("#提示信息#",obj.log_text);
								tempStr = tempStr.replace("#创建时间#",obj.time_format);
								tempStr = tempStr.replace("#主键#", obj.id);

								$("#logList").append(tempStr);
								tempStr = tempa;
							});
						},
						complete : function() {
						}
					});

		}
	</script>
	<script>
		$(function() {
			findlogList();
		});
		
		$(function(){
		    //全选操作
		    $("#selectAll").click(function(){
		        if(this.checked){
		            $("#logList .checkBtn,#selectAll").prop("checked",true);
		        }else{
		            $("#logList .checkBtn,#selectAll").prop("checked",false);
		        }
		    });
		});
		
		//删除确认
		function delConfirm(ids) {
			$.cachedScript('${ctx }/front/js/artDialog.js').done(function() {
				var d = dialog({
					content : document.getElementById('delDialog'),
					ok : function() {
						del(ids);
						this.close().remove();
						return false;
					},
					okValue : "确定",
					cancel : function() {
						this.close();
						return false;
					},
				});
				//将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
				d.showModal();
			});
		}
		
		//选择删除列
		function dels(){
			var shuliang = 0;
			var ids = [];
			$(".checkBtn").each(function(){
				if(this.checked){
					var idwz = $(this).val()
					var id = idwz.split(":")[0];
					var websiteName = idwz.split(":")[1];
					if(id){
						ids.push($(this).val());
				   		shuliang++;
					}
				}
			});
			if(shuliang==0){
			  	falseDialog("请选择要删除的日志");
			 }else{
				 delConfirm(ids);
			 }
	
		}
		
		//删除日志
		function del(ids) {
			$.ajax({
				type : "POST",
				url : '${ctx }/log/deleteLog?id=' + ids,
				success : function(data) {
					if (data.success) {
						successDialog(data.msg);
						setTimeout("findlogList()", "200"); //延迟加载
						$("#selectAll").prop("checked",false);
					} else {
						falseDialog(data.msg);
					}
				},
				error : function() {
					falseDialog("未知错误，请重试！")
				}
			});
		}
	</script>

</body>
</html>