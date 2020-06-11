<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>信息管理</title>

<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<link rel="stylesheet" href="${ctx}/front/css/totalList.css" type="text/css"/>
	
<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->


<script>
$(function(){
	
	$(".listSort a").click(function(){
		pageind = 1;
		switch($(this).index())
		{
		case 0:
			finishList(2);
		  break;
		case 1:
			finishList(1);
		  break;
		}
	    $(this).addClass("on").siblings().removeClass("on");
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
	
	
	$("#exportToLawRule").click(function(){
		//添加所属部门，新闻id
		var data={'xwColumn':$("#xwColumn").val(),'includedState':2};
		$.ajax({
			type:'POST',
			  /* url:'http://127.0.0.1:8080/splider/cgi/lawrule_test.jsp',  */
			  url:'http://192.168.0.9:9196/dsj/lawrule_test.jsp', 
			dataType:'text',
			data:data,
			success:function(data){
				successDialog(data);
			},
			error:function(data){
				falseDialog("法规数据导出失败");
			}
		});		
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

var pageind =1;
function finishList(includedState){
	
	jiazai();//加载框
	
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
	        },
	        beforeSend: function () {
	        },
	        success: function (data) {
	        	pageind = data.pageIndex;
	        	$('#pager').html("");
	       		 var tempa =$("#templateli").clone().html();
	             $("#InformationList").html("");
	             var tempStr = tempa;
	            $.each(data.items, function(index,obj) {
	            	tempStr=tempStr.replace("#序号#",(data.pageIndex-1)*10+(index+1));
	            	tempStr=tempStr.replace("#stuid#",obj.id); 
	            	tempStr=tempStr.replace("#stuid#",obj.id); 
	     	        tempStr=tempStr.replace("#标题#",obj.newsTitle!=null?obj.newsTitle:"");	
	     	        tempStr=tempStr.replace("#来源#",obj.releaseSource!=null?obj.releaseSource:"");	
	     	        tempStr=tempStr.replace("#图片数量#",obj.pictureNum);
	     	        tempStr=tempStr.replace("#发布时间#",obj.releaseTime!=null?obj.releaseTime:"");
	     	        tempStr=tempStr.replace("#创建时间#",obj.time_format);
	            	tempStr=tempStr.replace("#主键#",obj.id); 
// 	     	        if(obj.readState==1){
// 	     		        tempStr=tempStr.replace("#未读#","未读");	
// 	     	        }else{
// 	     		        tempStr=tempStr.replace("#未读#","已读");	
// 	     		        tempStr=tempStr.replace("td05 weidu","td05");	
// 	     	        }
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


function dianji(id){
// 	document.getElementById(id).className = "td05 weidu";//styleclass为新的属性值  
// 	document.getElementById(id).setAttribute("class","td05");  
// 	 $('#'+id).html('<i></i>已读');
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
        		if($('.listSort a.on').index()==0){
        			pageind=1;
        			successDialog(data.msg);
	        		setTimeout("finishList(2)","2000"); //延迟加载
        		}else if($('.listSort a.on').index()==1){
        			pageind=1;
        			successDialog(data.msg);
	        		setTimeout("finishList(1)","2000"); //延迟加载
        		}
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
        		if(ind==0){
        			pageind=1;
        			successDialog(data.msg);
	        		setTimeout("finishList(2)","2000"); //延迟加载
        			pageind=1;
        		}else if(ind==1){
        			successDialog(data.msg);
	        		setTimeout("finishList(1)","2000"); //延迟加载
        		}
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
// 	$.ajax({
//         type: "POST",
//         url: '${ctx }/information/openAccountInfo?ids='+ids,
//         success: function (data) {
//         	if (data.success) {
//         			successDialog(data.msg);
// 			}else{
// 			}
//         },
//         error:function(){
//         }
// 	});
	
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

<body onload="finishList(1)">
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

	<a class="delList" href="javascript:void(0)" id="zhuanhuan" title="转换" target="_self" style="right: 259px;">转换</a>
	<c:choose>
		<c:when test="${xwColumn.xwColumn.superId == 10}">
			<a class="delList" href="javascript:void(0)" id="exportToLawRule"  title="导入法规" target="_self" style="right: 179px;">导入法规</a>
		</c:when>
		<c:otherwise>
			<a class="delList" href="javascript:void(0)" id="export"    title="导出" target="_self" style="right: 179px;">导出</a>
		</c:otherwise>
	</c:choose>
	<a class="delList" href="javascript:void(0)" id="import"    title="导入" target="_self" style="right: 99px;">导入</a>
	<a class="delList" href="javascript:void(0)" id="delete"    title="删除" target="_self" style="right: 19px;">删除</a>

    <input value="${xwColumn.xwColumn.id}" type="hidden" id="xwColumn"/>
     <input  type="hidden" id="totalData"/>
    <div class="listSort">
        <a href="#" title="已收录" target="_self">已收录</a>
        <a class="on" href="#" title="未收录" target="_self">未收录</a>
    </div>
    <div class="listTitWrap">
        <ul>
            <li>
                <span class="td01">序号</span>
                <span class="td02">标题</span>
                <span class="td03">来源</span>
                <span class="td04">图片数量</span>
                <span class="td05">发布时间</span>
                <span class="td05">创建时间</span>
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
	                <span class="td05">#创建时间#</span>
			      	<span class="td06" id="#stuid#" >
						<label>
		                      <input value="#主键#" class="checkBtn" type="checkbox"/>
		                </label>
					</span>
	          </li>	
        </div>
    </div>
    
</div>
     
</body>
</html>