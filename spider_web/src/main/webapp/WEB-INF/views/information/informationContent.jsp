<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>新闻详情</title>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<link rel="stylesheet" href="${ctx }/front/css/article.css" type="text/css"/>

<!-- 图片放大弹框-->
<link rel="stylesheet" href="${ctx }/front/css/zoomify.min.css"/>
 <script src="${ctx }/front/js/zoomify.min.js"></script>
<!-- 富文本编辑器 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="../../kindeditor-4.1.10/themes/default/default.css" />" />
<link rel="stylesheet" charset="utf-8" type="text/css"
	href="<c:url value="../../kindeditor-4.1.10/plugins/code/prettify.css"/>" />
<script type="text/javascript" charset="utf-8"
	src="<c:url value="../../kindeditor-4.1.10/kindeditor.js"/>"></script>
<script type="text/javascript" charset="utf-8"
	src="<c:url value="../../kindeditor-4.1.10/lang/zh_CN.js"/>"></script>
<script type="text/javascript" charset="utf-8"
	src="<c:url value="../../kindeditor-4.1.10/plugins/code/prettify.js"/>"></script>
	<!-- 图片裁剪-->
	
<link rel="stylesheet" href="${ctx }/front/css/imgareaselect-animated.css"/>
 <script src="${ctx }/front/js/jquery.imgareaselect.pack.js"></script>
</head>
<body>
<!-- leftMenu -->
<ul class="breadNav">
	<li><a href="${ctx }/page/information/informationcolumn?leftMenu=1" title="" target="_self">新闻信息</a></li>
    <li style="min-width: 13px;">>></li>
    <li><a href="${ctx }/column/${superid }/list" title="" target="_self">${supername }</a></li>
    <li style="min-width: 13px;">>></li>
    <li><a id="shuaxin" href="${ctx }/information/informationList?xwColumn=${columnId}" title="" target="_self">${columnName}</a></li>
    <li style="min-width: 13px;">>></li>
    <li><a href="" title="" target="_self">正文</a></li>
    <li class="front_page save"><a href="javascript:void(0)" onclick="SaveBtn('${information.id }')" >保存</a></li>
    <li class="front_page submit"><a href="javascript:void(0)" onclick="submitBtn('${information.id }')" >提交</a></li>
    <li class="front_page"><a href="javascript:void(0)" onclick="closePage()" >关闭</a></li>
</ul>
<!-- article -->  
<div class="article">
    <input type="hidden" value="${ information.id}" id="informationId"/>
    <input type="hidden" value="${ information.pic_sign}" id="picSign"/>
    <div class="changeChanel">
        <span>原文网址：<a style="color: #4b96ea;" href="${information.source }" target="view_window">${information.source }</a></span>
        <div class="changeTxt">
            <i>新闻归属：</i>
             <select class="lanmu" id="lanmuGuishu">
		            <option value="0">请选择</option>
	              <c:forEach var="stu" items="${columnsGs}">
		            <option value="${stu.id }" <c:if test='${stu.id ==information.gsColumn}'>selected</c:if> >${stu.columnName }</option>
		          </c:forEach>
            </select>
        </div>
        <div class="changeTxt">
            <i>转入栏目：</i>
             <select class="lanmu" id="lanmu" name="lanmu01">
		            <option value="0">请选择</option>
	              <c:forEach var="stu" items="${columns}">
		            <option value="${stu.id }" <c:if test='${stu.id ==information.xwColumn}'>selected</c:if> >${stu.columnName }</option>
		          </c:forEach>
            </select>
<%--             <a class="submitBtn" href="javascript:void(0)" onclick="submitBtn('${information.id }')" title="提交" target="_self">提交</a> --%>
        </div>
    </div>
    <input id="id"	name="id" value="${information.id }" readonly="readonly" type="hidden" />
    <h1 class="artTit">${information.newsTitle }</h1>
    <h3>${information.releaseTime }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来源：${information.releaseSource }</h3>
	<div class="tips">图片说明：图片（<font> jpg格式，宽不超过400</font> ）</div>
	
	<div class="imgList" style="overflow: visible;">
		<ul>
		<c:forEach items="${pics }" var="pic"  varStatus="status" >
			<li class="${pic.Path}" id="${pic.Id}">	
					<img src="${pic.Path}" style="display: none;"/>
					<img class="PathShow" src="${pic.PathShow}"/>
				      <div class="tools">
						<span class="size" >
							<b>裁剪：</b>
							<a  onclick="saveImg('${pic.Id}')" href="javascript:void(0)" target="_self">保存</a>
	                        <a class="on margin_right"  onclick="sn('${pic.Id}')" href="javascript:void(0)" target="_self">16:9</a>
							<a  onclick="ft('${pic.Id}')" href="javascript:void(0)" target="_self">4:3</a>
						</span>
						<span class="delate">
							<a href="javascript:void(0)" onclick="delConfirm('${pic.Id}')" target="_self">删除</a>
	                        <a class="chooseImage"  href="#" target="_self">替换</a>
	                        <a class="chexiao" onclick="chexiao('${pic.Id}')"  href="#" target="_self">撤销</a>
	                        <a class="sign"  href="javascript:void()" target="_self">标记</a>
						</span>
					</div>
				</li>
		</c:forEach>
		</ul>
	</div>
<textarea name="content" id="content"  cols="500" rows="200" style="width:100%; height:100%;" >${information.newsContent }</textarea>
<!-- <div class="tips">新闻内容摘要</div> -->
<h1 class="artTit" style="margin: 15px 20px;">新闻内容摘要:</h1>
<textarea name="abstractContent" id="abstractContent"  cols="500" rows="200" style="width:100%; height:100%;" >${information.abstractNewsContent }</textarea>
    <script type="text/javascript">
    var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="content"]', {
				cssPath : '../../kindeditor-4.1.10/plugins/code/prettify.css',
				uploadJson : '../../kindeditor-4.1.10/jsp/upload_json.jsp',
				fileManagerJson : '../../kindeditor-4.1.10/jsp/file_manager_json.jsp',
				allowFileManager : true,
				width:"100%",
				height:"500px",
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						submitBtn();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						submitBtn();
					});
				}
			});
			prettyPrint();
		});

var editor2;
KindEditor.ready(function(K) {
	editor2 = K.create('textarea[name="abstractContent"]', {
				cssPath : '../../kindeditor-4.1.10/plugins/code/prettify.css',
				uploadJson : '../../kindeditor-4.1.10/jsp/upload_json.jsp',
				fileManagerJson : '../../kindeditor-4.1.10/jsp/file_manager_json.jsp',
				allowFileManager : true,
				width:"100%",
				height:"200px",
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						submitBtn();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						submitBtn();
					});
				}
			});
			prettyPrint();
		});
</script>
    <!-- 确认按钮 -->
    <div class="submitOp">
    </div>
	
</div>

<script>
$(function(){
    //下拉框样式
    $(".lanmu").cssSelect();
});

//保存
function SaveBtn(){
	var str = "";
	$(".imgList a.sign.on").each(function(){
		str = str + $(this).parent().parent().parent('li').attr("id")+",";
	});
	editor1.sync();
	editor2.sync();
	var id=$("#id").val();
	var wenzhang=$("#content").val();
	var zhaiyao=$("#abstractContent").val();
	debugger;
	//归属栏目
	var gsColumn = $("#lanmuGuishu").val();
	var data={'id':id,'newsContent':wenzhang,'abstractNewsContent':zhaiyao,'gsColumn':gsColumn,"picSign":str};
	$.ajax({
		type:'POST',
		url:'${ctx}/information/updateInformation',
		dataType:'text',
		data:data,
		success:function(data){
			if(data=='success'){
				successDialog("保存成功");
				setTimeout("window.location.reload();","2000");
			}else{
				falseDialog("保存信息错误！")
			}
		}
	});
}

//提交
function submitBtn(){
	var str = "";
	$(".imgList a.sign.on").each(function(){
		str = str + $(this).parent().parent().parent('li').attr("id")+",";
	});
	if(str!=""){
		str = str.substr(0, str.length - 1);  
	}
	editor1.sync();
	editor2.sync();
	var id=$("#id").val();
	//所属栏目
	var xwColumn = $("#lanmu").val();
	//归属栏目
	debugger;
	var gsColumn = $("#lanmuGuishu").val();
	var wenzhang=$("#content").val();
	var zhaiyao=$("#abstractContent").val();
 	if(xwColumn ==0){
 		if(gsComlumn == 0){
 			var data={'id':id,'newsContent':wenzhang,'abstractNewsContent':zhaiyao,"picSign":str};
 		}
 		else{
 			var data={'id':id,'gsColumn':gsColumn,'newsContent':wenzhang,'abstractNewsContent':zhaiyao,"picSign":str};
 		}
 	}else{
 		if(gsColumn == 0){
 			var data={'id':id,'xwColumn':xwColumn,'newsContent':wenzhang,'abstractNewsContent':zhaiyao,"picSign":str};
 		}else{
 			var data={'id':id,'xwColumn':xwColumn,'gsColumn':gsColumn,'newsContent':wenzhang,'abstractNewsContent':zhaiyao,"picSign":str};
 		}
 	}   
	$.ajax({
		type:'POST',
		url:'${ctx}/information/updateInformation',
		dataType:'text',
		data:data,
		success:function(data){
			if(data=='success'){
				successDialog("提交成功");
				if(window.opener && !window.opener.closed){
					window.opener.location.href = '${ctx}/information/informationList?xwColumn=<%=request.getParameter("xwColumn")%>';
					setTimeout("window.close()","2000");
				}else{
					setTimeout("document.getElementById(\"shuaxin\").click()","2000");
				}
			}else{
				falseDialog("提交信息错误！")
			}
		}
	});
}

// 删除图片   删除确认
var id = $("#informationId").val();
function delConfirm(pic_wz){
	$.cachedScript('${ctx }/front/js/artDialog.js').done(function(){
        var d = dialog({
             content:document.getElementById('delDialog'),
             ok:function(){
            	 del(pic_wz);
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
function del(picId) {
	if(picId != "" && id!=""){
		$.ajax({
	        type: "post",
	        url: '${ctx }/information/delPic?id='+id+'&picId='+picId,
	        success: function (data) {
	        	if (data.success) {
	        		successDialog(data.msg);
	        		window.location.reload();
				}else{
					falseDialog(data.msg);
				}
	        },
	        error:function(){
	        	falseDialog("未知错误，请重试！");
	        }
		});
	}
}
</script>
<!-- 图片裁剪 -->
<script type="text/javascript">  
			var x1;
			var y1;
			var width;
			var height;
			var idzoom;
		/* 缩放图片 */
          function ft(id){
        	  idzoom = id;
        	  $('#'+id+" .PathShow").imgAreaSelect({ aspectRatio: '4:3', handles: true,
        		  fadeSpeed: 200, onSelectChange: preview });
          }
          function sn(id){ 
        	  idzoom = id;
        	  $('#'+id+" .PathShow").imgAreaSelect({ aspectRatio: '16:9', handles: true,
        		  fadeSpeed: 200, onSelectChange: preview });
          }
          function preview(img, selection) {
        	  if (!selection.width || !selection.height)
        	  return;
        	  var scaleX = 100 / selection.width;
        	  var scaleY = 100 / selection.height;

        	  x1 = selection.x1;
        	  y1 = selection.y1;
        	  width = selection.width;
        	  height = selection.height;
        	}
          
          
          /* 保存裁剪之后的图片 */
          function saveImg(imgId){
        	  debugger;
        	  var ymWidth=document.getElementById(imgId).offsetWidth;//当前图片在页面上所展示的宽度
        	  var imgSrc=$("#"+imgId+" .PathShow").attr("src");
        	  imgSrc=imgSrc.split("/img");
        	  var id=$("#id").val();
//         	  alert(imgId+"::"+x1+"::"+y1+"::"+width+"::"+height)
			  if(idzoom !=imgId){
				  falseDialog("请保存标记的当前图片！");
				  return ;
			  }
			  if(y1<0){
        		  falseDialog("位置标记错误，请检查！");
        		  return;
			  }
        	  if(!width){
        		  falseDialog("请标记裁剪位置！");
        	  }else{
        		  $.ajax({
          	        type: "GET",
          	        url: imgSrc[0]+'${ctx }/information/updateImg',
          	        data:{
          	        	id:id,
          	        	imgId:imgId,
          	        	x:x1,
          	        	y:y1,
          	        	width:width,
          	        	height:height,
          	        	ymWidth:ymWidth
          	        },
          	      beforeSend :function(xmlHttp){ 

          	    	} ,
          	        success: function (data) {
          	        	if (data.success) {
          	        		$('#'+imgId+" .PathShow").attr("src",data.subpath);
          	        		$('#'+imgId+" .PathShow").imgAreaSelect({ remove: true});
          				}else{
          					falseDialog(data.msg);
          				}
          	        },
          	        error:function(){
          	        	falseDialog("未知错误，请重试！");
          	        },
          		}); 
        	  }
          }
        </script> 
 
 <script type="text/javascript">
 var pic_id;
     KindEditor.ready(function (K) {
         
         K('.chooseImage').click(function () {
        	 pic_id = $(this).parent().parent().parent('li').attr("id");
        	 var editor = K.editor({
                 uploadJson: '${ctx }/uploadimg/upload?picId='+pic_id,
                 dir:"img",
                 allowFileManager: false,
                 filePostName:"uploadFile"
             });
        	 editor.loadPlugin('image', function () {
                 editor.plugin.imageDialog({
                     showRemote: false,
                     imageUrl: K('#PicUrl').val(),
                     clickFn: function (url, message, error) {
                         K("#"+pic_id+" .PathShow").attr("src", url);
                         chooseImage_one = url;
                         editor.hideDialog();
                     }
                 });
             });
         });
     
     });
//      图片撤销
function chexiao(id){
	$.ajax({
		type:'POST',
		url:'${ctx}/information/chexiaoImg',
		dataType:'text',
		data:{id:id},
		success:function(data){
			var a = JSON.parse(data);
			if(a.success){
				successDialog(a.msg);
				$("#"+id+" .PathShow").attr('src',$("#"+id+" .PathShow").prev().attr("src"));
			}else{
				falseDialog(a.msg)
			}
		}
	});
}


//获取图片位置
$(".imgList a.sign").click(function(){
	if($(this).attr("class").indexOf("on")== -1){
		$(this).attr("class","sign on");
	}else{
		$(this).attr("class","sign");
	}
	
});

// 立即执行  图片标记样式展示
$(function(){
	var picSign=$("#picSign").val();	
	var picSigns= picSign.split(",");
	
	for(var i= 0;i<picSigns.length;i++){  
		if(picSigns[i]){
			$("#"+picSigns[i]+" .sign").attr('class',"sign on");
		}
    }  
});
 </script>


 <script type="text/javascript">
 //图片点击放大
	$('.imgList img').zoomify();
</script>
</body>
</html>