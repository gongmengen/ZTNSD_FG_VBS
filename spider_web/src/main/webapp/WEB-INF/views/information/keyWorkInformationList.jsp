<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>信息管理</title>

<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<script src="${ctx}/front/laydate/laydate.js"></script>
<link rel="stylesheet" href="${ctx}/front/css/totalList.css" type="text/css"/>
<%-- <link rel="stylesheet" href="${ctx}/front/css/keyWorkInformationList.css" type="text/css"/> --%>
	
<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->


<script>


$(function(){
	if($("#xwColumn").val() == "10016"){//专题信息默认显示第一个关键词的检索结果
		finishwordList(1,true);
	}else{
		finishwordList(1,false);
		finishList();
		
	}
})

//查询关键词列表
var totalPage = 0;
var pageSize = 5;
function finishwordList(pageIndex,flag){
	var param = {'pageIndex':pageIndex,'pageSize':pageSize};
	 $.ajax({
         type: "post",
         url: "${ctx}/keyWork/keyWorkList",
         data: param,
         dataType: 'json',
         success: function (data) {
        		var tempa =$("#tempkeyword").clone().html();
              $("#keywordListSort").html('');
              var tempStr = tempa;
             $.each(data.TitleCounts, function(index,obj) {
            	 if(flag && index == 0){
            		finishList(obj.keywordName);
            		tempStr="<a href=\"#\" onclick=\"finishList('"+obj.keywordName+"')\" title=\""+obj.keywordName+"\" target=\"_self\" class=\"on\">"+obj.keywordName+"</a>";
            	 }else{
	             	tempStr=tempStr.replace("#关键词名称#",obj.keywordName); 
	             	tempStr=tempStr.replace("#关键词名称#",obj.keywordName); 
	             	tempStr=tempStr.replace("#关键词名称#",obj.keywordName); 
            	 }
             	$("#keywordListSort").append(tempStr);
            	tempStr=tempa;
             });
             totalPage =Math.ceil( data.total/pageSize);
             	$("#keywordListSort").append('<span class="pre">&lt;</span><span class="current">'+data.pageIndex+'/'+totalPage+'</span><span class="next">&gt;</span>');
        
	       		delay();
         },
         error: function () {
        	 
         }
     });
}
//关键词列表  加分页
var page = 1;
function delay(){

	$(".keywordListSort a").click(function(){
		 $(this).addClass("on").siblings().removeClass("on");
	});
	
	$('.next').on('click', function(e) {
	  	if(page >= totalPage){
	  		return ; 
	  	}else{
	  		page = page +1;
	  		finishwordList(page,false);
	  	}
		
	})
	$('.pre').on('click', function(e) {
		if(page <=1 ){
	  		return ;
	  	}else{
	  		page = page - 1;
	  		finishwordList(page,false);
	  	}
	})
}
//搜索事件
var startTime;
var endTime;
function executeQuery(){
	var keyWordName =  $("#keywordListSort a.on").attr("title");
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	finishList(keyWordName);
}

//查询新闻列表
var pageind =1;
function finishList(keyWordName){
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	var ind = $('.listSort a.on').index();
	var includedState = 1;
	if(ind==0){
		includedState = 2;
	}else{
		includedState = 1;		
	}
	jiazai();//加载框
	if(keyWordName){
		$('#pager').sjAjaxPager({
	        url: '${ctx}/information/getInformationKeyWord',
	        pageSize: 10,
	        pageIndex:pageind,
	        searchParam: {
	            /*
	            * 如果有其他的查询条件，直接在这里传入即可
	            */
	            'xwColumn':$("#xwColumn").val(),
	            'includedState':includedState,
	            'keyWordName':keyWordName,
	            'startTime':startTime,
	            'endTime':endTime,
	            'sort':sort,
	            'order':order
	        },
	        beforeSend: function () {
	        },
	        success: function (data) {
	        	if(data.success){
	        		$('#pager').html("");
		       		 var tempa =$("#templateli").clone().html();
		             $("#InformationList").html("");
		             $(".listTitWrap #td04").html("匹配率");
		             $("#nums_text").html("为您搜索到"+data.total+"条相关数据");
		             var tempStr = tempa;
		            $.each(data.items, function(index,obj) {
		            	tempStr=tempStr.replace("#序号#",(data.pageIndex-1)*10+(index+1));
		            	tempStr=tempStr.replace("#stuid#",obj.id); 
		            	tempStr=tempStr.replace("#stuid#",obj.id); 
		     	        tempStr=tempStr.replace("#标题#",obj.newsTitle!=null?obj.newsTitle:"");	
		     	        tempStr=tempStr.replace("#来源#",obj.releaseSource!=null?obj.releaseSource:"");	
		     	        tempStr=tempStr.replace("#图片数量#",obj.score);
		     	        tempStr=tempStr.replace("#发布时间#",obj.releaseTime!=null?obj.releaseTime:"");
		     	        tempStr=tempStr.replace("#修改时间#",obj.updateTimeLong!=null?obj.updateTimeLong:"");
		            	tempStr=tempStr.replace("#主键#",obj.id); 
			     	       
		            	$("#InformationList").append(tempStr);
		           		tempStr=tempa;
		            });
		            
	        	}else{
	        		falseDialog(data.msg);
	        	}
	        	loading.close();//加载完成弹框关闭
// 	        	pageind = data.pageIndex;
	        	
	        },
	        complete: function () {
	        }
	    });
	}else{
	$(".keywordListSort a").removeClass("on");
	 $('#pager').sjAjaxPager({
	        url: '${ctx}/information/findinformation',
	        pageSize: 10,
	        pageIndex:pageind,
	        searchParam: {
	            /*
	            * 如果有其他的查询条件，直接在这里传入即可
	            */
	            xwColumn:$("#xwColumn").val(),
	            includedState:includedState,
	            'startTime':startTime,
	            'endTime':endTime
	        },
	        beforeSend: function () {
	        },
	        success: function (data) {
// 	        	pageind = data.pageIndex;
	        	$('#pager').html("");
	       		 var tempa =$("#templateli").clone().html();
	             $("#InformationList").html("");
	             $(".listTitWrap #td04").html("图片数量");
	             $("#nums_text").html("");
	             
	             var tempStr = tempa;
	            $.each(data.items, function(index,obj) {
	            	tempStr=tempStr.replace("#序号#",(data.pageIndex-1)*10+(index+1));
	            	tempStr=tempStr.replace("#stuid#",obj.id); 
	            	tempStr=tempStr.replace("#stuid#",obj.id); 
	     	        tempStr=tempStr.replace("#标题#",obj.newsTitle!=null?obj.newsTitle:"");	
	     	        tempStr=tempStr.replace("#来源#",obj.releaseSource!=null?obj.releaseSource:"");	
	     	        tempStr=tempStr.replace("#图片数量#",obj.pictureNum);
	     	        tempStr=tempStr.replace("#发布时间#",obj.releaseTime!=null?obj.releaseTime:"");
	     	        tempStr=tempStr.replace("#修改时间#",obj.time_format);
	            	tempStr=tempStr.replace("#主键#",obj.id); 
	     	        if(obj.newsTitle!=null){
		     	       $("#InformationList").append(tempStr);
	     	        }
	           		tempStr=tempa;
	            });
	            loading.close();//加载完成弹框关闭
	            $("#selectAll").prop("checked",false);
	        },
	        complete: function () {
	        }
	    });
	}
}

$(function(){
	
	$(".listSort a").click(function(){
		debugger;
		pageind = 1;
	    $(this).addClass("on").siblings().removeClass("on");
	    $(".keywordListSort a").removeClass("on");
		finishList();
	});
	
	// 多选单选删除
	//删除操作
	$("#delete").click(function(){
		var ids = [];
		var shuliang = 0;
		$(".checkBtn").each(function(){
			if(this.checked){
			  	ids.push($(this).val());
			    shuliang++;
			}
		});
			    
		if(shuliang!=0){
		    delConfirm(ids);
		 }else{
		  	falseDialog("请选择要删除的新闻");
		}
			    
	});
	
	// 多选单选转换
	//转换操作
	$("#zhuanhuan").click(function(){
		var ids = [];
		var shuliang = 0;
		$(".checkBtn").each(function(){
			if(this.checked){
			  	ids.push($(this).val());
//	 		    $(this).parents("li").remove();
			    shuliang++;
			}
		});
			    
		if(shuliang!=0){
			zhuanhuan(ids);
		 }else{
		  	falseDialog("请选择要转换的新闻");
		}
			    
	});
	//导入操作
	$("#import").click(function(){
		//导入链接
		window.location.href="http://xw.bd.zt/cgi/mysqlToSybase.jsp";
		
	});
	
	
	//导出操作
	$("#export").click(function(){
		
		var ids = [];
		var shuliang = 0;
		$(".checkBtn").each(function(){
			if(this.checked){
			  	ids.push($(this).val());
			    shuliang++;
			}
		});
			    
		if(shuliang!=0){
			confirmExport("确定导出信息摘要？",ids);
		 }else{
		  	falseDialog("请选择要导出的新闻");
		}
	});
	
})



function dianji(id){

	window.open("${ctx}/information/"+id+"/getInformation?xwColumn=<%=request.getParameter("xwColumn")%>");  
}


//删除确认
function delConfirm(ids){
	$.cachedScript('${ctx }/front/js/artDialog.js').done(function(){
        var d = dialog({
             content:document.getElementById('delDialog'),
             ok:function(){
            	 del(ids);
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
function del(ids) {
	$.ajax({
        type: "POST",
        url: '${ctx }/information/delete?ids='+ids,
        success: function (data) {
        	if (data.success) {
       			pageind=1;
       			successDialog(data.msg);
        		setTimeout("finishList()","2000"); //延迟加载
			}else{
			}
        },
        error:function(){
        }
	});
}


function zhuanhuan(ids) {
	var ind = $('.listSort a.on').index();
	//2.已收录   1.未收录
	var includedState = 0;
	if(ind==0){
		includedState = 1;
	}else{
		includedState = 2;
	}
	$.ajax({
        type: "POST",
        url: '${ctx }/information/zhuanhuan?ids='+ids+"&includedState="+includedState,
        success: function (data) {
        	if (data.success) {
       			pageind=1;
       			successDialog(data.msg);
        		setTimeout("finishList()","2000"); //延迟加载
			}else{
			}
        },
        error:function(){
        }
	});
}


//导出确认框
function confirmExport(obj,ids){
	var aa = dialog({
		 content:document.getElementById('delDialog'),
		 ok:function(){
			 openAccountInfo(ids);
			 this.close();
		 },
		 cancel:function(){
			 this.close();
		 },
	});
	
	$("#delDialog p").html(obj);
	//将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
	aa.showModal();
}

function openAccountInfo(ids){
	
	window.location.href='${ctx }/information/openAccountInfo?ids='+ids;
}
</script> 

<script>

$(function(){
    //全选操作
    $("#selectAll").click(function(){
        if(this.checked){
            $("#InformationList .checkBtn,#selectAll").prop("checked",true);
        }else{
            $("#InformationList .checkBtn,#selectAll").prop("checked",false);
        }
    });
});
</script>
</head>

<body>
<!-- leftMenu -->
<ul class="breadNav">
    <li><a href="${ctx }/page/information/informationcolumn?leftMenu=1" title="" target="_self">新闻信息</a></li>
    <li style="min-width: 13px;">>></li>
    <li><a href="${ctx }/column/${superid }/list" title="" target="_self">${supername }</a></li>
    <li style="min-width: 13px;">>></li>
    <li><a href="" title="" target="_self">${xwColumn.xwColumn.columnName}</a></li>
	<li class="front_page"><a href="javascript:void(0)" onclick="backPage()" >返回</a></li>
</ul>
<!-- newsList -->  
<div class="newsList02">

	<a class="delList" href="javascript:void(0)" onclick="executeQuery()" title="查询" target="_self" style="right: 339px;">查询</a>
	<a class="delList" href="javascript:void(0)" id="zhuanhuan" title="转换" target="_self" style="right: 259px;">转换</a>
	<a class="delList" href="javascript:void(0)" id="export"    title="导出" target="_self" style="right: 179px;">导出</a>
	<a class="delList" href="javascript:void(0)" id="import"    title="导入" target="_self" style="right: 99px;">导入</a>
	<a class="delList" href="javascript:void(0)" id="delete"    title="删除" target="_self" style="right: 19px;">删除</a>
	
	
    
    <input value="${xwColumn.xwColumn.id}" type="hidden" id="xwColumn"/>
     <input  type="hidden" id="totalData"/>
    <div class="listSort">
        <a href="#" title="已收录" target="_self">已收录</a>
        <a class="on" href="#" title="未收录" target="_self">未收录</a>
        <input class="searchInput laydate-icon" id="startTime" placeholder="开始日期" style="margin-left : 50px"/>
		<input class="searchInput laydate-icon" id="endTime" placeholder="结束日期"/>
    </div>
    <div class="keywordListSort" id="keywordListSort">

	 </div>
    <div id="tempkeyword" style="display: none;">
        		<a href="#" onclick="finishList('#关键词名称#')" title="#关键词名称#" target="_self">#关键词名称#</a>
    </div>
        
    <div class="listTitWrap">
    <span class="nums_text" id="nums_text"></span>
        <ul>
            <li>
                <span class="td01">序号</span>
                <span class="td02">标题</span>
                <span class="td03">来源</span>
                <span class="td04" id="td04" onclick="qiehuan('score')">图片数量</span>
                <span class="td05">发布时间</span>
                <span class="td05" onclick="qiehuan('updateTimeLong')">修改时间</span>
                <span class="td06">
                	<label><input class="checkBtnAll" id="selectAll" type="checkbox"/></label>
                	<label>选择</label>
                </span>
            </li>
        </ul>
       
    </div>
    
    <div class="djbzMain">
        <ul class="djbz" id="InformationList">
	            
        </ul>
        <div id="pager"></div>
        <div id="templateli" style="display: none;">
        		<li>
	                <span class="td01">#序号#</span>
	                <span class="td02"><a href="#" onclick="dianji('#stuid#')" title="" target="_self">#标题#</a></span>
	                <span class="td03">#来源#</span>
	                <span class="td04">#图片数量#</span>
	                <span class="td05">#发布时间#</span>
	                <span class="td05">#修改时间#</span>
			      	<span class="td06" id="#stuid#" >
						<label>
		                      <input value="#主键#" class="checkBtn" type="checkbox"/>
		                </label>
					</span>
	          </li>	
        </div>
    </div>
    
</div>


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

<script>

var isUp = false;
var sort ;
var order ;
function qiehuan(obj){
	var keyWordName =  $("#keywordListSort a.on").attr("title");
	if(keyWordName){
	
		if(isUp == false){
			isUp = true;
			sort = obj;
			order = "ASC";
			finishList(keyWordName);
		}else{
			isUp = false;
			sort = obj;
			order = "DESC";
			finishList(keyWordName);
		}
	}
}
</script>
</body>
</html>