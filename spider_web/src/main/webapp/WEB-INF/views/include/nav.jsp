<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>后台管理系统</title>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!-- 加载和操作弹窗 -->
<%@ include file="/WEB-INF/views/include/alertDialog.jsp"%>
<%@ include file="/WEB-INF/views/include/loading.jsp"%>
</head>
<%  
String roletype = session.getAttribute("roletype").toString(); //从session里把roletype拿出来
String leftMenu = session.getAttribute("leftMenu").toString(); //从session里把leftMenu拿出来
%>  
<body>
<!-- topBar -->
<div class="topBar">
    <h1><a href="" title="信息收集系统" target="_self">信息收集系统</a></h1>
    <input type="hidden" value="${leftMenu}" id="leftMenu"/>
    <div class="notice">信息收集系统欢迎您，现在时间是：<font id="date"></font></div>
    <div class="loginInfo">
        <i class="adminIcon"></i><em>您好，</em><a href="" title="" target="_self">${my_admin.nickName}</a>
        <i class="quitIcon"></i><a href="${ctx }/user/outlogin" title="退出" target="_self">退出</a>
        <input type="hidden" id="userid" value="${my_admin.id }"/>
    </div>
</div>
<!-- leftMenu -->
<div class="leftMenu">
    <h3><a class="indexIcon" href="${ctx}/page/index?leftMenu=0" title="首页" target="_self"><p>首页</p></a></h3>
    <h3><a class="newsIcon" href="${ctx}/page/information/informationcolumn?leftMenu=1" title="新闻信息" target="_self"><p>新闻信息</p></a></h3>
    <h3><a class="manageIcon" href="${ctx}/page/website/websitecolumn?leftMenu=2" title="网站管理" target="_self"><p>网站管理</p></a></h3>
	 <c:if test="${ roletype gt 3}">
    <h3><a class="editIcon" href="${ctx}/page/user/userList?leftMenu=3" title="编辑管理" target="_self"><p>编辑管理</p></a></h3>
    </c:if>
    <h3><a class="newsIcon" href="${ctx}/page/log/logList?leftMenu=4" title="日志" target="_self"><p>日志</p></a></h3>
    <h3><a class="manageIcon" href="${ctx}/page/titleCount/titleCountList?leftMenu=5" title="转载统计" target="_self"><p>转载统计</p></a></h3>
    <h3><a class="newsIcon" href="${ctx}/page/keyWork/keyWorkList?leftMenu=6" title="关键词管理" target="_self"><p>关键词管理</p></a></h3>
</div>


<!-- 删除弹窗 -->
<div class="delDialog" id="delDialog">
    <h3>提示</h3>
    <span class="closeBtn" data-id="cancel">x</span>
	<p>确定要删除吗？</p>
    <div class="dialogBtn02">
        <input data-id="ok" class="okBtn" type="submit" value="确定"/><input class="cancelBtn" data-id="cancel" type="button" value="取消"/>
    </div>
</div>
<script>

$(function(){
     $(".leftMenu h3").eq($("#leftMenu").val()).addClass("on");
    //js延迟加载依赖（方法 $.cachedScript，这段js可以放在公共js文件内，无需修改）    
    var scriptsArray = new Array(); $.cachedScript = function (url, options) { for (var s in scriptsArray) { if (scriptsArray[s] == url) { return { done: function (method) { if (typeof method == "function") { method() } } } } } options = $.extend(options || {}, { dataType: "script", url: url, cache: true }); scriptsArray.push(url); return $.ajax(options) };
});

//关闭页面
function closePage(){
  window.close();
 };
//返回上一层
function backPage(){
	history.back();
};
</script>

</body>
</html>