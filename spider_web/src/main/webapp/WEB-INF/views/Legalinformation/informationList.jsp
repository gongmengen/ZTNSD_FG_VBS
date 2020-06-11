<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>信息管理</title>

<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<link rel="stylesheet" href="${ctx}/front/css/legaltotalList.css" type="text/css"/>
	
<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->


<script>
$(function(){
	//默认隐藏导入转入栏目
	$(".delList").eq(2).hide();
	//默认隐藏转换收录功能
	$(".delList").eq(3).hide();
	
	 $(".listSort a").click(function(){
        $(this).addClass("on").siblings().removeClass("on");
        $(".tabTxt01").hide();
        $(".tabTxt01").eq($(this).index()).show();
        
        $(".delList").hide();
        switch($(this).index())
		{
		case 0:
			$(".delList").eq(2).show();
			$(".delList").eq(3).show();
			$(".delList").eq(3).css("right","106px");
			pageind=1;
			finishList(2);
		  break;
		case 1:
			$(".delList").eq(0).show();
			$(".delList").eq(1).show();
			pageind=1;
			finishList(1);
		  break;
		}
    });
	 
	 //转入对应已收录栏目
	 $("#updatelanmu").click(function(){
// 		 debugger;
		 var shuliang = 0;
		 var ids_lanmu = [];
		 //栏目下拉框value值
		 var columnValue = 0;
	        $(".checkBtn").each(function(){
	            if(this.checked){
	            	var id = $(this).val();
	            	shuliang++;
	            	ids_lanmu.push($("#"+id+" .lanmus01").val()+":"+$(this).val());
	            	columnValue = $("#"+id+" .lanmus01").val();
	            }
	        });
	        //若某条新闻复选框被选中，且新闻栏目不为“请选择”，执行转入栏目和收录
		    if(shuliang!=0 && columnValue!=0){
				$.ajax({
			        type: "POST",
			        url: '${ctx }/information/updateLanmu?ids_lanmu='+ids_lanmu+"&includedState="+2,
			        success: function (data) {
			        	if (data.success) {
			        		if($('.listSort a.on').index()==0){
				        		successDialog(data.msg);
				        		setTimeout("finishList(2)","2000"); //延迟加载
			        		}else if($('.listSort a.on').index()==1){
			        			successDialog(data.msg);
			        			setTimeout("finishList(1)","2000"); //延迟加载
			        		}
						}else{
						}
			        },
			        error:function(){
			        }
				});
				
		    }else{
		    	falseDialog("请选择转入栏目");
		    }
		});
	 
		//导入操作
		$("#leadlanmu").click(function(){
				//导入功能为预留功能，此处仅提供提示弹窗效果
		    	falseDialog("导入功能暂未开通");
		});
	 
		//删除操作
		$("#delete").click(function(){
			var ids = [];
			var shuliang = 0;
		    $(".checkBtn").each(function(){
		        if(this.checked){
		        	ids.push($(this).val());
// 		            $(this).parents("li").remove();
		            shuliang++;
		        }
		    });
		    
		    if(shuliang!=0){
			    delConfirm(ids);
		    }else{
		    	falseDialog("请选择要删除的新闻");
		    }
		    
		    
		});
		
})
var pageind =1;

function finishList(includedState){
	
	jiazai();//加载弹框
	
	 $('#pager').sjAjaxPager({
	        url: '${ctx}/information/findinformation',
	        pageIndex:pageind,
	        pageSize: 10,
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
	        	$('#pager').html("");
	       		 var tempa01 =$("#templateli01").clone().html();
	       			$("#selectAll").prop("checked",false);
	        	if(includedState==1){
	        		tempa01 =$("#templateli03").clone().html();
	        	}
	             $("#InformationList01").html("");
	             var tempStr01 = tempa01;
	            $.each(data.items, function(index,obj) {
	            	pageind = data.pageIndex;
	            	tempStr01=tempStr01.replace("#序号#",(data.pageIndex-1)*10+(index+1));
	            	tempStr01=tempStr01.replace("#stuid#",obj.id); 
	            	tempStr01=tempStr01.replace("#标题#",obj.newsTitle!=null?obj.newsTitle:"");	
	            	tempStr01=tempStr01.replace("#url#",obj.source!=null?obj.source:"");	
	            	tempStr01=tempStr01.replace("#来源#",obj.releaseSource!=null?obj.releaseSource:"");	
	     	        tempStr01=tempStr01.replace("#图片数量#",obj.pictureNum);
	     	        tempStr01=tempStr01.replace("#发布时间#",obj.releaseTime!=null?obj.releaseTime:"");
	     	        tempStr01=tempStr01.replace("#修改时间#",obj.time_format);
	     	        tempStr01=tempStr01.replace("#修改时间#",obj.time_format);
	     	        tempStr01=tempStr01.replace("weiyiid",obj.id);	
	     	        tempStr01=tempStr01.replace("zhuangtai",obj.readState);	
	     	        tempStr01=tempStr01.replace("weiyiid",obj.id);	 
	     	        tempStr01=tempStr01.replace("zhuangtai",obj.readState);	
	     	        tempStr01=tempStr01.replace("#主键#",obj.id);	 
	     	        tempStr01=tempStr01.replace("#主键#",obj.id);	 
	     	        if(obj.readState==1){
	     		        tempStr01=tempStr01.replace("#未读#","未读");	
	     	        }else{
	     		        tempStr01=tempStr01.replace("#未读#","已读");	
	     		        tempStr01=tempStr01.replace("td05 weidu","td05");	
	     	        }
	     	        if(obj.newsTitle!=null){
		     	       $("#InformationList01").append(tempStr01);
	     	        }
	           		tempStr01=tempa01;
	           		
	            });
	            loading.close();//加载完成弹框关闭
	        },
	        complete: function () {
	        }
	    });
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


//转入到未收录
function zhuanhuan() {
	var shuliang = 0;
	 var ids_lanmu = [];
	 //栏目下拉框value值
	 var columnValue = 0;
       $(".checkBtn").each(function(){
           if(this.checked){
           	var id = $(this).val();
           	shuliang++;
           	ids_lanmu.push($("#"+id+" .lanmus01").val()+":"+$(this).val());
           	columnValue = $("#"+id+" .lanmus01").val();
           }
       });
       //若某条新闻复选框被选中，且新闻栏目不为“请选择”，执行转入栏目和收录
	    if(shuliang!=0 && columnValue!=0){
			$.ajax({
		        type: "POST",
		        url: '${ctx }/information/updateLanmu?ids_lanmu='+ids_lanmu+"&includedState="+1,
		        success: function (data) {
		        	if (data.success) {
		        		if($('.listSort a.on').index()==0){
			        		successDialog(data.msg);
			        		setTimeout("finishList(2)","2000"); //延迟加载
		        		}else if($('.listSort a.on').index()==1){
		        			successDialog(data.msg);
		        			setTimeout("finishList(1)","2000"); //延迟加载
		        		}
					}else{
					}
		        },
		        error:function(){
		        }
			});
			
	    }else{
	    	falseDialog("请选择转入栏目");
	    }
}
//状态改已读
// function yidu(id,zhuangtai){
// 	if(zhuangtai==1){//状态为未读
// 		$.ajax({
// 	        type: "POST",
// 	        url: '${ctx }/information/updateZhuangtai?id='+id,
// 	        success: function (data) {
// 	        	if (data) {
// 	        		if($('.listSort a.on').index()==0){
// 		        		setTimeout("finishList(2)","200"); //延迟加载
// 	        		}else if($('.listSort a.on').index()==1){
// 		        		setTimeout("finishList(1)","200"); //延迟加载
// 	        		}
// 				}else{
// 				}
// 	        },
// 	        error:function(){
// 	        }
// 		});
// 	}
	
// }

</script> 

<script>

$(function(){
    //全选操作
    $("#selectAll").click(function(){
        if(this.checked){
            $("#InformationList01 .checkBtn,#selectAll").prop("checked",true);
        }else{
            $("#InformationList01 .checkBtn,#selectAll").prop("checked",false);
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
    
<!--     <li><a href="" title="" target="_self">新闻列表</a></li> -->

</ul>
<!-- newsList -->  
<div class="newsList02">
<%--     <h2>${xwColumn.xwColumn.columnName}</h2> --%>
    <a class="delList leadlanmu" href="javascript:void(0)" id="delete" title="删除" target="_self">删除</a>
    <a class="delList" href="javascript:void(0)" id="updatelanmu" title="转到已收录" target="_self">转到已收录</a>
    <a class="delList leadlanmu" href="javascript:void(0)" id="leadlanmu" title="导入发布后台" target="_self">导入发布后台</a>
	<a class="delList zhuanhuan" href="javascript:void(0)" onclick="zhuanhuan()" id="zhuanhuan" title="转到未收录" target="_self">转到未收录</a>
	
    <input value="${xwColumn.xwColumn.id}" type="hidden" id="xwColumn"/>
     <input  type="hidden" id="totalData"/>
    <div class="listSort">
<!--         <a class="on" href="javascript:void(0)" title="全部" target="_self">全部</a> -->
        <a href="javascript:void(0)" title="已收录" target="_self">已收录</a>
        <a class="on" href="javascript:void(0)" title="未收录" target="_self">未收录</a>
    </div>
   	<div class="listTitWrap">
        <ul>
            <li>
                <span class="td01">序号</span>
                <span class="td02">标题</span>
                <span class="td03">来源</span>
                <span class="td04">图片数量</span>
                <span class="td05">发布时间</span>
                <span class="td05">修改时间</span>
<!--                 <span class="td05">状态</span> -->
                <span class="td06">
                	<label>选择栏目</label>
                </span>
                <span class="td07">
                	<label><input class="checkBtnAll" id="selectAll" type="checkbox"/></label>
                	<label>选择</label>
                </span>
            </li>
        </ul>
       
    </div>
    
    <div class="djbzMain">
        <ul class="djbz" id="InformationList01">
        
        </ul>
        <div id="pager"></div>
        <div id="templateli01" style="display: none;">
        		<li  id="#主键#" >
	                <span class="td01">#序号#</span>
	                <span class="td02"><a href="#url#" title="" target="_Blank">#标题#</a></span>
<!-- 	                onclick="yidu('weiyiid','zhuangtai')"  -->
	                <span class="td03">#来源#</span>
	                <span class="td04">#图片数量#</span>
	                 <span class="td04">#发布时间#</span>
	                <span class="td05">#修改时间#</span>
<!-- 			      	<span class="td05 weidu"><i></i>#未读#</span> -->
 					<span class="td07">
	                    <label>
		                    <input value="#主键#" class="checkBtn" type="checkbox"/>
		                </label>
	                </span>
			      	<span class="td06">
	                    <select class="lanmus01" name="lanmus02">
	                        <option value="0">请选择</option>
	                    	<c:forEach var="stu" items="${columns}">
					            <option value="${stu.id }" <c:if test='${stu.id ==xwColumn.xwColumn.id}'>selected</c:if>>${stu.columnName }</option>
					        </c:forEach>
	                    </select>
	                </span>
	               
	          </li>	
        </div>
          <div id="templateli03" style="display: none;">
	        		<li id="#主键#">
		                <span class="td01">#序号#</span>
		                <span class="td02"><a href="#url#" title="" target="_Blank">#标题#</a></span><!--onclick="yidu('weiyiid','zhuangtai')"-->
		                <span class="td03">#来源#</span>
		                <span class="td04">#图片数量#</span>
		                <span class="td05">#发布时间#</span>
		                <span class="td05">#修改时间#</span>
<!-- 				      	<span class="td05 weidu"><i></i>#未读#</span> -->
						<span class="td07">
		                    <label>
		                        <input value="#主键#" class="checkBtn" type="checkbox"/>
		                    </label>
		                </span>
				      	<span class="td06">
				      		<select class="lanmus01" name="lanmus02">
		                        <option value="0">请选择</option>
		                    	<c:forEach var="stu" items="${columns}">
						            <option value="${stu.id }" <c:if test='${stu.id ==xwColumn.xwColumn.id}'>selected</c:if>>${stu.columnName }</option>
						        </c:forEach>
		                    </select>
		                </span>
		                
		          </li>	
	        </div>
    </div>
</div>
   
</body>
</html>