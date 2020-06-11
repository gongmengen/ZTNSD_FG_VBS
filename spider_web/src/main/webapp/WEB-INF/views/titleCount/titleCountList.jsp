<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>转载统计</title>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<script src="${ctx}/front/laydate/laydate.js"></script>
<link rel="stylesheet" href="${ctx}/front/css/titleCount.css" type="text/css" />
<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->
</head>
<body>
	<ul class="breadNav">
		<li><a href="" title="" target="_self">转载统计</a></li>
	</ul>
	<!-- logList -->
	<div class="editorList">
		<div class="searchArea">
			<input class="searchInput" id="newsTitle" placeholder="新闻标题"/>
			<input class="searchInput laydate-icon" id="startTime" placeholder="开始日期"/>
			<input class="searchInput laydate-icon" id="endTime" placeholder="结束日期"/>
			<a class="addBtn" onclick="confirmUpdate()"href="javascript:void(0)" title="查询" target="_self">更新</a>
			<a style="margin-right: 20px;" class="addBtn" onclick="executeQuery()"href="javascript:void(0)" title="查询" target="_self">查询</a>
		</div>
		<div class="listTitWrap">
			<ul>
				<li><span class="td01">序号</span>
					<span class="td02">新闻标题</span> 
					<span class="td03">转载数量</span>
					<span class="td03">百度相关结果数量</span>
					<span class="td04">更新日期</span>
					<span class="td05">操作</span>
				</li>
			</ul>
		</div>
		<div class="djbzMain">
			<ul id="TitleCountList" class="djbz">
			</ul>
			<div id="pager"></div>
			<div style="display: none;" id="clonTitleCountList">
				<li><span class="td01">#序号#</span> 
					<span class="td02">#新闻标题#</span>
					<span class="td03">#转载数量#</span> 
					<span class="td03">#百度相关结果#</span> 
					<span class="td04">#更新日期#</span> 
					<span class="td05"><a class="updateBtn" onclick="lookDialog('#查看标题#')" id="look" href="javscript:void(0)" title="" target="_self">查看</a></span> 
				</li>
			</div>
		</div>
	</div>

<!-- 新闻详情查看 弹窗 -->
<div class="editDialog" id="siteUpdateDialog">
    <h3>新闻详细信息查看</h3>
    <span class="closeBtn" data-id="cancel">x</span>
    <div class="editorList">
		<div class="listTitWrap">
			<ul>
				<li><span class="td11">序号</span>
					<span class="td12">新闻标题</span> 
					<span class="td13">新闻来源</span>
					<span class="td14">发布时间</span>
				</li>
			</ul>
		</div>
		<div class="djbzMain"  style="overflow-y: auto;height:430px;">
			<ul id="InformationList" class="djbz">
			</ul>
			<div style="display: none;" id="templateli">
				<li><span class="td11">#序号#</span> 
					<span class="td12"  title="#新闻标题#">
						<a style="color: #4b96ea;" href="#原文网址#" target="view_window">#新闻标题#</a>
					</span>
					<span class="td13">#新闻来源#</span> 
					<span class="td14">#发布时间#</span> 
				</li>
			</div>
		</div>
	</div>
</div>

</body>
<script>
	var pageind = 1;
	$(function() {
		findTitleCountList();
	});
	function executeQuery(){
		var newsTitle = $("#newsTitle").val();
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		findTitleCountList2(newsTitle,startTime,endTime);
	}
	
	//导出确认框
	function confirmUpdate(){
		var aa = dialog({
			 content:document.getElementById('delDialog'),
			 ok:function(){
				 updateTitleCount();
				 this.close();
			 },
			 cancel:function(){
				 this.close();
			 },
		});
		
		$("#delDialog p").html("是否确认更新");
		//将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
		aa.showModal();
	}
	
	
	function updateTitleCount(){
		$.ajax({
	        type: "POST",
	        url: '${ctx }/titleCount/updateTitleCount',
	        beforeSend : function() {
				jiazai();
			},
	        success: function (data) {
	        	if (data.success) {
	        		successDialog(data.msg);
				}
	        },
	        error:function(){
	        	falseDialog("更新失败");
	        }
		}); 
		
	}
	
	
	
	//列表数据填充
	function findTitleCountList(newsTitle,startTime,endTime) {
		
		$('#pager').sjAjaxPager({
			url : '${ctx}/titleCount/titleCountList',
			pageIndex : pageind,
			pageSize : 10,
			searchParam : {
			/*
			 * 如果有其他的查询条件，直接在这里传入即可
			 */
				"newsTitle":newsTitle,
				"startTime":startTime,
				"endTime":endTime
			},
			beforeSend : function() {
				jiazai();
			},
			success : function(data) {
				pageind = data.pageIndex;
				$("#TitleCountList").html("");
				var tempa = $("#clonTitleCountList").clone().html();
				var tempStr = tempa;
				$('#pager').html("");
				$.each(data.TitleCounts, function(index, obj) {
					tempStr = tempStr.replace("#序号#", (data.pageIndex - 1)* 10 + (index + 1));
					tempStr = tempStr.replace("#新闻标题#",obj.newsTitle);
					tempStr = tempStr.replace("#查看标题#",obj.newsTitle);
					tempStr = tempStr.replace("#转载数量#",obj.titleNumber);
					tempStr = tempStr.replace("#百度相关结果#",obj.baiduNums==null?"":obj.baiduNums);
					tempStr = tempStr.replace("#更新日期#",obj.updateTimeStr);
					tempStr = tempStr.replace("#主键#",obj.titleId);

					$("#TitleCountList").append(tempStr);
					tempStr = tempa;
				});
				
			},
			complete : function() {
				loading.close();//加载完成弹框关闭
			}
		});

	}
	
	//这个方法用于实时获取查询的标题统计数量
	function findTitleCountList2(newsTitle,startTime,endTime) {
		
		$('#pager').sjAjaxPager({
			url : '${ctx}/information/titleCountList',
			pageIndex : pageind,
			pageSize : 10,
			searchParam : {
			/*
			 * 如果有其他的查询条件，直接在这里传入即可
			 */
				"newsTitle":newsTitle,
				"startTime":startTime,
				"endTime":endTime
			},
			beforeSend : function() {
				jiazai();
			},
			success : function(data) {
				pageind = data.pageIndex;
				$("#TitleCountList").html("");
				var tempa = $("#clonTitleCountList").clone().html();
				var tempStr = tempa;
				$('#pager').html("");
				$.each(data.TitleCounts, function(index, obj) {
					tempStr = tempStr.replace("#序号#", (data.pageIndex - 1)* 10 + (index + 1));
					tempStr = tempStr.replace("#新闻标题#",obj.newsTitle);
					tempStr = tempStr.replace("#转载数量#",obj.titleNumber);
					tempStr = tempStr.replace("#百度相关结果#",obj.baiduNums==null?"":obj.baiduNums);
					tempStr = tempStr.replace("#更新日期#",obj.updateTimeStr);
					tempStr = tempStr.replace("#查看标题#",obj.newsTitle);

					$("#TitleCountList").append(tempStr);
					tempStr = tempa;
				});
				
			},
			complete : function() {
				loading.close();//加载完成弹框关闭
			}
		});

	}
	
	

	/* 详情查看弹框   */
	function lookDialog(newsTitle){
		lookInformation(newsTitle);
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
	function lookInformation(newsTitle){
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		$.ajax({
			url : '${ctx}/information/findTitleCountByTitle',
			type: 'POST',
            dataType: 'JSON',
			 data:{"newsTitle" : newsTitle,"startTime" : startTime,"endTime" : endTime},
			 success: function(data){
				$("#InformationList").html("");
				var tempa = $("#templateli").clone().html();
				var tempStr = tempa;
				$.each(data.items, function(index, obj) {
					tempStr = tempStr.replace("#序号#",  (index + 1));
					tempStr = tempStr.replace("#新闻标题#",obj.newsTitle);
					tempStr = tempStr.replace("#新闻标题#",obj.newsTitle);
					tempStr = tempStr.replace("#原文网址#",obj.source);
					tempStr = tempStr.replace("#新闻来源#",obj.releaseSource);
					tempStr = tempStr.replace("#发布时间#",obj.releaseTime);

					$("#InformationList").append(tempStr);
					tempStr = tempa;
				});
			 },
			complete : function() {
			}
		})
	}
</script>

<script>
//日期范围限制
var start = {
    elem: '#startTime',
    format: 'YYYY-MM-DD',
//     min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#endTime',
    format: 'YYYY-MM-DD',
//     min: laydate.now(),
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，充值开始日的最大日期
    }
};
laydate(start);
laydate(end);
</script>

</html>